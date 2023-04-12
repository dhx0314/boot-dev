package cn.dhx.boot.controller;


import cn.dhx.boot.aop.Log;
import cn.hutool.core.io.IoUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

/**
 * 文件上传和下载
 */

/**
 * @Author daihongxin
 * @create 2023/3/8 15:27
 */

@RestController
@Slf4j
@Log
public class FileController {


    @PostMapping(value = "/upload")
    public void uploadFile(@RequestParam(value = "file1") MultipartFile multipartFile) throws IOException {
        //获取上传文件名称
        String fileName = multipartFile.getOriginalFilename();
        //获取上传文件类型
        String contentType = multipartFile.getContentType();
        //获取上传文件输入流，便于文件内容读写操作
        InputStream inputStream = multipartFile.getInputStream();
        String upLoadPath = "file\\upload.txt";
        File file = new File(upLoadPath);
        IoUtil.copy(inputStream, new BufferedOutputStream(new FileOutputStream(upLoadPath)));
        System.out.println("fileName = " + fileName + ", contentType = " + contentType);
    }


    @PostMapping(value = "/upload1")
    public void uploadFile1(HttpServletRequest request) throws IOException {

        // 强制将HttpServletRequest转为MultipartHttpServletRequest
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        //获取指定MultipartFile文件
        MultipartFile file = multipartRequest.getFile("file1");
        //获取文件名称
        String originalFilename = file.getOriginalFilename();
        System.out.println("原文件" + originalFilename);

    }


    @PostMapping(value = "/upload2")
    public void uploadFile2(HttpServletRequest request, @RequestParam("tips") String tips) throws IOException {

        System.out.println(tips);
        // 强制将HttpServletRequest转为MultipartHttpServletRequest
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;


        //不指定上传文件参数,而是获取整个上传文件集合
        MultiValueMap<String, MultipartFile> multiFileMap = multipartRequest.getMultiFileMap();
        //遍历整个上传文件集合，获取上传文件
        Iterator<String> MultipartFileIterator = multiFileMap.keySet().iterator();
        while (MultipartFileIterator.hasNext()) {
            String key = MultipartFileIterator.next();
            System.out.println("当前上传文件参数: " + key);
            //这里是集合的原因是，可能一个参数上传多个文件。
            List<MultipartFile> multipartFiles = multiFileMap.get(key);

            multipartFiles.forEach(multipartFile -> {
                System.out.println("上传文件名称: " + multipartFile.getOriginalFilename() + ", 上传文件类型:" + multipartFile.getContentType());
            });
            System.out.println("------------分割----------");
        }
    }


    @GetMapping("download")
    public void downLoad(HttpServletResponse response) throws IOException {
        String downloadFileName = "download_demo.txt";
        boolean isOnLine = false;
        if (isOnLine) { // 预览模式
            response.setHeader("Accept-Ranges", "bytes");
            response.setHeader("Content-Disposition", "inline; filename=" + downloadFileName);
        } else { // 下载模式
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment; filename=" + downloadFileName);
        }
        String downloadPath = "file\\upload.txt";
        FileInputStream fileInputStream = new FileInputStream(downloadPath);
        byte[] bytes = IoUtil.readBytes(fileInputStream);

        OutputStream outputStream = response.getOutputStream();
//            response.addHeader("Content-Type", "audio/wav");
        response.addHeader("Content-Type", "text/plain");
        response.setContentLengthLong(bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }


}
