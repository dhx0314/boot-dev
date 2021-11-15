package cn.dhx.util.info;

import java.io.IOException;
import java.net.URLEncoder;

public class Http {
//    public static void main(String[] args) {
//        String netAddress="http://172.16.2.144:8010/vox/2021/10/29/10/20211029_100711_1005.wav";
//        try {
//            byte[] bytes = httpUtil.downFile(netAddress);
//            response.reset();
//            response.addHeader("Content-Type", "audio/wav");
//            response.setContentLengthLong(bytes.length);
//            if (isOnLine) {
//                // 在线打开方式 文件名应该编码成UTF-8
//                response.setHeader("Accept-Ranges", "bytes");
//                response.setHeader("Content-Disposition", "inline; filename=" + URLEncoder.encode(filename, "UTF-8"));
//            } else {
//                //纯下载方式 文件名应该编码成UTF-8
//                response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(filename, "UTF-8"));
//                response.setContentType("application/x-msdownload");
//            }
//            outputStream = response.getOutputStream();
//            outputStream.write(bytes,0,bytes.length);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            logger.info("fileDown error" + e.getMessage());
//        } finally {
//            try {
//                outputStream.flush();
//                outputStream.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        }
//
//    }
}
