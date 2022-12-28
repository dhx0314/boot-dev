package cn.dhx.bootdemo.ftp;

import cn.dhx.bootdemo.ftp.ftppool.FtpPool;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@Component
public class FileUtil2 {

    //ftp服务器ip地址
    @Value("${ftp.host}") // 相关配置放在application.properties 中
            String FTP_ADDRESS;
    //端口号
    @Value("${ftp.port}")
    Integer FTP_PORT;
    //用户名
    @Value("${ftp.username}")
    String FTP_USERNAME;
    //密码
    @Value("${ftp.password}")
    String FTP_PASSWORD;
    //图片路径
    @Value("${ftp.basePath}")
    String FTP_BASEPATH;

//    @Autowired
    private FtpPool ftpPool;

    //根据当前文件生成 文件夹
    private static String getTimePath() {
        Date now = new Date();

        DateFormat format = new SimpleDateFormat("yyyy/MM/dd/");
        return format.format(now);
    }

    /**
     * author : wangwei
     * description: 使用ftp 上传文件
     * date:      2019/6/5
     */

    public String upload(InputStream inputStream, String originName) {

        StringBuilder url = new StringBuilder();
        FTPClient ftp = null;
//        FTPClient ftp = new FTPClient();
//        ftp.setControlEncoding("GBK");
        try {
//            int reply;
//            ftp.connect(FTP_ADDRESS, FTP_PORT);// 连接FTP服务器
//            ftp.login(FTP_USERNAME, FTP_PASSWORD);// 登录
//            reply = ftp.getReplyCode();
//            System.out.println("reply:" + reply);
//
//            ftp.enterLocalPassiveMode();//开启被动模式，否则文件上传不成功，也不报错
//
            String timePath = "2020/10";
            String saveDir = FTP_BASEPATH + timePath;
//            url.append(saveDir);
//
//            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftp = ftpPool.borrowObject();
            createDir(ftp, saveDir);
//            ftp.makeDirectory(saveDir);
            //   ftp.changeWorkingDirectory(FTP_BASEPATH);
            originName = System.currentTimeMillis() +"ttt"+ originName.substring(originName.lastIndexOf('.'));
            url.append(originName);
            ftp.storeFile(originName, inputStream);


        } catch (Exception e) {
            throw new RuntimeException("文件上传失败");
        } finally {
            try {
                inputStream.close();
                ftpPool.returnObject(ftp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return url.toString();
    }

    // 创建文件夹，并切换到该文件夹
    // 比如： hello/test
    //最终会切换到test 文件夹返回
    private void createDir(FTPClient client, String path) throws IOException {
        String[] dirs = path.split("/");
        for (String dir : dirs) {
            if (StringUtils.isEmpty(dir)) {
                continue;
            }
            if (!client.changeWorkingDirectory(dir)) {
                client.makeDirectory(dir);
            }
            client.changeWorkingDirectory(dir);
        }
    }


    public void down() throws IOException {
//        FTPClient ftp = new FTPClient();
//        ftp.connect(FTP_ADDRESS, FTP_PORT);// 连接FTP服务器
//        ftp.login(FTP_USERNAME, FTP_PASSWORD);// 登录
        FTPClient ftp=null;
        InputStream inputStream=null;
        try {
             ftp = ftpPool.borrowObject();
            ftp.changeWorkingDirectory("2021/06/02");//找到指定目录
            inputStream = ftp.retrieveFileStream("1622621855647.wav");//根据指定名称获取指定文件
            int reply = ftp.getReplyCode();
            System.out.println("reply:" + reply);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            ftpPool.returnObject(ftp);
        }



        int available = inputStream.available();
        System.out.println(available);
        byte[] b = new byte[available];
        inputStream.read(b);
//        System.out.println("1"+b.length);
//        File file = new File("HelloWorld");
//        file.read
//        byte[] bytes = Byte2InputStream.inputStream2byte(inputStream);
//        System.out.println("2"+bytes.length);
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "GBK"));
//        String line = null;
//        StringBuilder stringBuilder = new StringBuilder(150);
//        while ((line = bufferedReader.readLine()) != null) {
//            stringBuilder.append(line + "\n");
//        }
//        String context = stringBuilder.toString();
//
//        String[] sz = context.replaceAll("\"", "").split("\n");
//        for (int i = 0; i < sz.length; i++) {
//            System.out.println(sz[i]);//输出每一行的数据
//        }
//


    }

}

