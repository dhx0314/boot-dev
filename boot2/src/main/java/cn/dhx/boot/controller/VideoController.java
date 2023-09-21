package cn.dhx.boot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.UUID;

/**
 * @Author daihongxin
 * @create 2023/9/20 17:56
 */
@Slf4j
@RestController
public class VideoController {


    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("getVideo")
    public void getVideo(HttpServletResponse response) {
        String downPath = "http://172.16.6.77:8010/vox/1001202309201634392972-9673-163214437-1001202309201634392840_46251828.mp4";
        HttpHeaders headers = new HttpHeaders();
        ResponseEntity<byte[]> res = restTemplate.exchange(
                downPath,
                HttpMethod.GET,
                new HttpEntity<String>(headers),
                byte[].class,
                UUID.randomUUID().toString());
        if (res.getStatusCode() == HttpStatus.OK) {

            BufferedOutputStream bufferedOutputStream = null;
            try {
                byte[] bytes = res.getBody();

                File file = new File("boot2/file/bb.mp4");
                 bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                bufferedOutputStream.write(bytes);
                bufferedOutputStream.flush();
            } catch (Exception e) {
                log.error("error", e);
            }finally {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    @GetMapping("play")
    public void play(HttpServletRequest request, HttpServletResponse response) {
        String path = "boot2/file/a.mp4";
        File file = new File(path);
        log.info("file {}",file.exists());
        play(path, request, response);




    }

    //path为本地文件路劲
    public void play(String path, HttpServletRequest request, HttpServletResponse response) {

        RandomAccessFile targetFile = null;
        OutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            response.reset();
            //获取请求头中Range的值
            String rangeString = request.getHeader(HttpHeaders.RANGE);

            //打开文件
            File file = new File(path);
            if (file.exists()) {
                //使用RandomAccessFile读取文件
                targetFile = new RandomAccessFile(file, "r");
                long fileLength = targetFile.length();
                long requestSize = (int) fileLength;
                //分段下载视频
                if (StringUtils.hasText(rangeString)) {
                    //从Range中提取需要获取数据的开始和结束位置
                    long requestStart = 0, requestEnd = 0;
                    String[] ranges = rangeString.split("=");
                    if (ranges.length > 1) {
                        String[] rangeDatas = ranges[1].split("-");
                        requestStart = Integer.parseInt(rangeDatas[0]);
                        if (rangeDatas.length > 1) {
                            requestEnd = Integer.parseInt(rangeDatas[1]);
                        }
                    }
                    if (requestEnd != 0 && requestEnd > requestStart) {
                        requestSize = requestEnd - requestStart + 1;
                    }
                    //根据协议设置请求头
                    response.setHeader(HttpHeaders.ACCEPT_RANGES, "bytes");
                    response.setHeader(HttpHeaders.CONTENT_TYPE, "video/mp4");
                    if (!StringUtils.hasText(rangeString)) {
                        response.setHeader(HttpHeaders.CONTENT_LENGTH, fileLength + "");
                    } else {
                        long length;
                        if (requestEnd > 0) {
                            length = requestEnd - requestStart + 1;
                            response.setHeader(HttpHeaders.CONTENT_LENGTH, "" + length);
                            response.setHeader(HttpHeaders.CONTENT_RANGE, "bytes " + requestStart + "-" + requestEnd + "/" + fileLength);
                        } else {
                            length = fileLength - requestStart;
                            response.setHeader(HttpHeaders.CONTENT_LENGTH, "" + length);
                            response.setHeader(HttpHeaders.CONTENT_RANGE, "bytes " + requestStart + "-" + (fileLength - 1) + "/"
                                    + fileLength);
                        }
                    }
                    //断点传输下载视频返回206
                    response.setStatus(HttpServletResponse.SC_PARTIAL_CONTENT);
                    //设置targetFile，从自定义位置开始读取数据
                    targetFile.seek(requestStart);
                } else {
                    //如果Range为空则下载整个视频
                    response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=test.mp4");
                    //设置文件长度
                    response.setHeader(HttpHeaders.CONTENT_LENGTH, String.valueOf(fileLength));
                }

                //从磁盘读取数据流返回
                byte[] cache = new byte[4096];
                try {
                    while (requestSize > 0) {
                        int len = targetFile.read(cache);
                        if (requestSize < cache.length) {
                            outputStream.write(cache, 0, (int) requestSize);
                        } else {
                            outputStream.write(cache, 0, len);
                            if (len < cache.length) {
                                break;
                            }
                        }
                        requestSize -= cache.length;
                    }
                } catch (IOException e) {
                    // tomcat原话。写操作IO异常几乎总是由于客户端主动关闭连接导致，所以直接吃掉异常打日志
                    //比如使用video播放视频时经常会发送Range为0- 的范围只是为了获取视频大小，之后就中断连接了
                    log.info(e.getMessage());
                }
            } else {
                log.error("文件不存在");
            }
            outputStream.flush();
        } catch (Exception e) {
            log.error("文件传输错误", e);
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    log.error("流释放错误");
                }
            }
            if (targetFile != null) {
                try {
                    targetFile.close();
                } catch (IOException e) {
                    log.error("文件流释放错误");
                }
            }
        }
    }


}
