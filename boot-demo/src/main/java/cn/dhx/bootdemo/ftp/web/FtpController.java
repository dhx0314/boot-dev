package cn.dhx.bootdemo.ftp.web;

import cn.dhx.bootdemo.ftp.FileUtil2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping("/common")
public class FtpController {


    @Autowired
    FileUtil2 fileUtil;

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {

        String url = fileUtil.upload(file.getInputStream(), file.getOriginalFilename());
        return url;

    }


    @PostMapping("/down")
    public String down() throws IOException {

       fileUtil.down();
        return "down";
    }

}
