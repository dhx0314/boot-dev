package cn.dhx;

import cn.dhx.boot.util.MinioUtil;
import io.minio.Result;
import io.minio.errors.*;
import io.minio.messages.Bucket;
import io.minio.messages.Item;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * @Author daihongxin
 * @create 2023/6/29 16:42
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class MyMinioTest {

    @Autowired
    private MinioUtil minioUtil;

    @Test
    public void fun1() {

        String path = "a.txt";
        File file = new File(path);
        System.out.println(file.exists());
    }


    @Test
    public void fun2() {

//        String path = "a.txt";


        String bucketName = "myio";
        String path2 = "/2023/06/29/a.txt";
//        minioUtil.upload("myio", "/2023/06/29/a.txt", path);

//        List<Bucket> allBucket = minioUtil.getAllBucket();

//            Iterable<Result<Item>> myio = minioUtil.listObjects("myio");

        minioUtil.downLocal(bucketName, path2, "minioUtil_a.txt");



    }


}
