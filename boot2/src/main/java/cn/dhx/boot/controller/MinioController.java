package cn.dhx.boot.controller;

import cn.dhx.boot.pojo.PresignParam;
import io.minio.MinioClient;
import io.minio.PostPolicy;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;
import java.util.Map;
import java.util.UUID;

/**
 * @Author daihongxin
 * @create 2023/10/12 10:01
 */
@Slf4j
@RestController
public class MinioController {

    @Autowired
    private MinioClient minioClient;

    @RequestMapping(value = "/presign", method = {RequestMethod.POST})
    public Map<String, String> presign(@RequestBody PresignParam presignParam) {
        // 如果前端不指定桶，那么给一个默认的
        if (StringUtils.isEmpty(presignParam.getBucket())) {
            presignParam.setBucket("myio");
        }

        // 前端不指定文件名称，就给一个UUID
        if (StringUtils.isEmpty(presignParam.getFilename())) {
            presignParam.setFilename(UUID.randomUUID().toString());
        }

        // 如果想要以子目录的方式保存，就在前面加上斜杠来表示
        //        presignParam.setFilename("/2023/" + presignParam.getFilename());

        // 设置凭证过期时间
        ZonedDateTime expirationDate = ZonedDateTime.now().plusMinutes(10);
        // 创建一个凭证
        PostPolicy policy = new PostPolicy(presignParam.getBucket(), presignParam.getFilename(), expirationDate);
        // 限制文件大小，单位是字节byte，也就是说可以设置如：只允许10M以内的文件上传
        //        policy.setContentRange(1, 10 * 1024);
        // 限制上传文件请求的ContentType
        //        policy.setContentType("image/png");

        try {
            // 生成凭证并返回
            final Map<String, String> map = minioClient.presignedPostPolicy(policy);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }
            return map;
        } catch (Exception e) {
            log.error("error", e);
        }

        return null;
    }

}
