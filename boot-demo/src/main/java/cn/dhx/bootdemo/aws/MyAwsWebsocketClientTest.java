package cn.dhx.bootdemo.aws;

import com.amazonaws.services.s3.model.Bucket;
import org.junit.Test;

import java.io.File;

public class MyAwsWebsocketClientTest {


    @Test
    public void fun1() {
//        Bucket bucket = Aws.getBucket(Aws.getBucket_name());
//        System.out.println(bucket.toString());
        String str="D:\\a\\20221020_095027_1009.wav";
//        File file = new File(str);
//        boolean exists = file.exists();
////        System.out.println(exists);
//        Aws.PutObject(str);
        Aws.PutObject2(str);

        String[] strings = Aws.QueryObjectALL();
    }

    @Test
    public void fun12() {
//        Bucket bucket = Aws.getBucket(Aws.getBucket_name());
//        System.out.println(bucket.toString());
//        String str="D:\\a\\20221020_095027_1009.wav";
//        File file = new File(str);
//        boolean exists = file.exists();
////        System.out.println(exists);
//        Aws.PutObject(str);
        String str = "record/20221020_095027_1008.wav";
        Aws.DeleteObject(str);

        String[] strings = Aws.QueryObjectALL();
    }
}
