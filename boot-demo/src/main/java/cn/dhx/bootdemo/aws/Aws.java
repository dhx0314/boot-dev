package cn.dhx.bootdemo.aws;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Aws {
    private static String access_key_id = "AKIASYBWREMREEWL7A5N";
    private static String secret_key_id = "vEB1naJw0bA54pw3PprucyailPEI+ZFVUPL7h75S";
//    private static String bucket_name = "siprec-stage";
    private static String bucket_name = "genesys-dev";
    private static AmazonS3 s3Client;
    private static List<String> object_list = new ArrayList<>();

    public static String getBucket_name() {
        return bucket_name;
    }

    static {
        //通过sdk创建与S3的链接
        BasicAWSCredentials awsCredentials = new BasicAWSCredentials(access_key_id, secret_key_id);
        s3Client = AmazonS3Client.builder()
//                .withRegion(Regions.CN_NORTH_1)//可以根据自己的需求进行选择
                .withRegion(Regions.CN_NORTHWEST_1)//可以根据自己的需求进行选择
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();

    }


    //创建桶
//    public static Bucket createBucket() {
//        Bucket b = null;
//        if (s3Client.doesBucketExistV2(bucket_name)) {
//            System.out.format("Bucket %s already exists.\n", bucket_name);
//            b = getBucket(bucket_name);
//        } else {
//            try {
//                b = s3Client.createBucket(bucket_name);
//            } catch (AmazonS3Exception e) {
//                System.err.println(e.getErrorMessage());
//            }
//        }
//        return b;
//    }

    //获取桶
    public static Bucket getBucket(String bucket_name) {
        Bucket named_bucket = null;
        List<Bucket> buckets = s3Client.listBuckets();
        for (Bucket b : buckets) {
            System.err.println(b.getName());
            if (b.getName().equals(bucket_name)) {
                named_bucket = b;
            }
        }
        return named_bucket;
    }

    //上传文件到桶
    public static void PutObject(String file_path){
        String key_name = Paths.get(file_path).getFileName().toString();
        try {
            s3Client.putObject(bucket_name, key_name, new File(file_path));
        } catch (AmazonServiceException e) {
            System.err.println(e.getErrorMessage());
        }
        System.err.println("Done!");
    }


    public static void PutObject2(String file_path) {
        String key_name = Paths.get(file_path).getFileName().toString();
        key_name = "/record/" + key_name;
        try {
            s3Client.putObject(bucket_name, key_name, new File(file_path));
        } catch (AmazonServiceException e) {
            System.err.println(e.getErrorMessage());
        }
        System.err.println("Done!");
    }

    //删除对象
    public static void DeleteObject(String object_key){
        try {
            s3Client.deleteObject(bucket_name, object_key);
        } catch (AmazonServiceException e) {
            System.err.println(e.getErrorMessage());
        }
        System.err.println("Done!");
    }

    //删除桶下的所有对象
    public static void DeleteObjectALL() {
        try {
            String[] object_keys = QueryObjectALL();
            DeleteObjectsRequest dor = new DeleteObjectsRequest(bucket_name)
                    .withKeys(object_keys);;
            s3Client.deleteObjects(dor);
        } catch (AmazonServiceException e) {
            System.err.println(e.getErrorMessage());
        }
        System.err.println("Done!");
    }

    //上传json到桶(特性化处理上传到文件夹)
    public static void PutJsonString(String file_name,String content){
        try {

            s3Client.putObject(bucket_name, file_name, content);
        } catch (AmazonServiceException e) {
            System.err.println(e.getErrorMessage());
        }
        System.err.println("Done!");
    }

    //查询指定桶下所有的对象
    public static String[] QueryObjectALL(){
        ListObjectsV2Result result = s3Client.listObjectsV2(bucket_name);
        List<S3ObjectSummary> objects = result.getObjectSummaries();
        for (S3ObjectSummary os : objects) {
            object_list.add(os.getKey());
            System.err.println("* " + os.getKey());
        }
        String[] object_keys = object_list.stream().map(el->el.toString()).toArray(String[]::new);
        object_list.clear();
        return object_keys;
    }

    //下载指定文件(key_name桶名)
    public static void GetObject(String key_name){
        try {
            S3Object o = s3Client.getObject(bucket_name, key_name);
            S3ObjectInputStream s3is = o.getObjectContent();
            FileOutputStream fos = new FileOutputStream(new File(key_name));
            byte[] read_buf = new byte[1024];
            int read_len = 0;
            while ((read_len = s3is.read(read_buf)) > 0) {
                fos.write(read_buf, 0, read_len);
            }
            s3is.close();
            fos.close();
        } catch (AmazonServiceException e) {
            System.err.println(e.getErrorMessage());
            System.exit(1);
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        System.out.println("Done!");
    }

    //删除指定桶下的指定对象
    public static void DeleteAssignObject(String appBucket, String appName) {
        appName = "public/" + appName;
        try {
            s3Client.deleteObject(appBucket, appName);
        } catch (AmazonServiceException e) {
            System.err.println(e.getErrorMessage());
        }
        System.err.println("Done!");
    }

    //上传指定json到桶(特性化处理上传到文件夹)
    public static void PutAssignJsonString(String appBucket, String file_name,String content){
        try {
            s3Client.putObject(appBucket, file_name, content);
        } catch (AmazonServiceException e) {
            System.err.println(e.getErrorMessage());
        }
        System.err.println("Done!");
    }

}
