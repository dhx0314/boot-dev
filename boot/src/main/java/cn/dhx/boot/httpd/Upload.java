package cn.dhx.boot.httpd;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;


@Slf4j
@Service
public class Upload {

    @Autowired
    private RestTemplate restTemplate;





    public boolean downAndUploadFile(String downPath, String uploadPath) {
        byte[] data = null;
        long start, end;
        log.info("begin download file [{}] and upload to [{}]", downPath, uploadPath);
        try {
            start = System.currentTimeMillis();
            HttpHeaders headers = new HttpHeaders();
//            headers.add("Authorization", "Basic "
//                    + Base64.encodeBase64String(("admin" + ":"+"admin").getBytes()));
            ResponseEntity<byte[]> response = restTemplate.exchange(
                    downPath,
                    HttpMethod.GET,
                    new HttpEntity<String>(headers),
                    byte[].class);
            if (response.getStatusCode() == HttpStatus.OK) {
                data = response.getBody();
                end = System.currentTimeMillis();
                System.out.println(data.length);
                log.info("SUCCESS download file [{}]. cost [ {} ] ms", downPath, end - start);
            } else {
                log.error("FAILED download file [{}]! response code : {}", downPath, response.getStatusCodeValue());
                return false;
            }
        } catch (Exception e) {
            log.error("ERROR download file [{}]!", downPath, e);
            return false;
        }

        try {
            start = System.currentTimeMillis();
//            restTemplate.delete(downPath);
            end = System.currentTimeMillis();
            log.info("SUCCESS delete file [{}]. cost [ {} ] ms", uploadPath, end - start);
        } catch (RestClientException e) {
            log.error("ERROR delete file [{}]!", uploadPath, e);
        }

        try {
            start = System.currentTimeMillis();
//            restTemplate.put(uploadPath, data);
            end = System.currentTimeMillis();
            log.info("SUCCESS put file [{}]. cost [ {} ] ms", uploadPath, end - start);
            return true;
        } catch (RestClientException e) {
            log.error("ERROR put file [{}]!", uploadPath, e);
        }
        return false;
    }




}
