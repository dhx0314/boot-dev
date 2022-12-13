package cn.dhx.demo;

import cn.dhx.util.DateToolUtil;
import cn.dhx.util.JsonUtil;
import cn.dhx.util.MySecurityUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Test;

import javax.crypto.KeyGenerator;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Demo {

    private final ConcurrentLinkedQueue<byte[]> pool = new ConcurrentLinkedQueue<>();


    @Test
    public void fun22test() throws Exception{

//        String filePath="D:\\a\\audio-dtmf\\Dtmf-0.wav";
        String filePath="/home/wilcom/media-processor-service/dtmf/Dtmf-0.wav";
        File file = new File(filePath);
        long length = file.length();
        System.out.println(length);
        RandomAccessFile raf = new RandomAccessFile(filePath, "r");
        long length1 = raf.length();
        System.out.println(length1);
        raf.seek(58);

        List<byte[]> blists = new ArrayList<>();
        byte[] bs1 = new byte[160];
        while (raf.read(bs1)!=-1) {
            blists.add(bs1);
        }

        System.out.println(blists.size());



//        String s="ZSmTRKlczDaGxa1UTKghZUh7zpR7kVUv8xVUpZThqEWB4sqBcmKRSxUoaZ2D1eYYRnhZ7PF/iel/XVEl5MOmyCjnYv1OEQi8kOfGJgmhXZBDD/Tsk3qZAVUxitMs6M5l";
//
//        String decode1 = MySecurityUtil.decode(s);
//        System.out.println(decode1);


         Long l;
//        System.out.println(null == l);
//        System.out.println(0==l);
//        String key="wilcomwilcom@123";
//        byte[] bytes = key.getBytes(StandardCharsets.UTF_8);
//        AES aes = SecureUtil.aes(bytes);
//        HashMap<String, String> map = new HashMap<>();
//        map.put("key","1");
//        map.put("value","1");
//        String s = JsonUtil.toString(map);
//        String hello = aes.encryptBase64(s);
//        System.out.println(hello);


//        osName=properties.getProperty("os.name");

//        LinkedHashMap<String, String> hashMap = new LinkedHashMap<>();
//        hashMap.put("11","22");
//        hashMap.put("11a","22");
//        hashMap.put("11ac","22");
//        System.out.println(hashMap);
//        Iterator<Map.Entry<String, String>> iterator = hashMap.entrySet().iterator();
//        while (iterator.hasNext()) {
//            iterator.next();
//            iterator.remove();
//            break;
//        }
//        System.out.println(hashMap);


//        String password="wilcom1234";
//        byte[] keyBytes = Arrays.copyOf(password.getBytes("ASCII"), password.length());
//        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
//        keyGen.init(128);//128,192,256三者选一
//        Key key = keyGen.generateKey();
//        System.out.println("Finish generating DES key");
//        // save key
//        byte[] encoded = key.getEncoded();
//        System.out.println(new String(encoded));
//        System.out.println(encoded.length);
//        System.out.println(new String(keyBytes));
    }

    @Test
    public void funae() throws InterruptedException {
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(100);
        arrayBlockingQueue.add("1");
        arrayBlockingQueue.add("2");
        arrayBlockingQueue.add("3");
        arrayBlockingQueue.add("4");
        String take = arrayBlockingQueue.take();
        System.out.println(take);

        System.out.println("------------");
        for (String s : arrayBlockingQueue) {
            System.out.println(s);
        }

    }



    @Test
    public void fun1aa232() {
        int a=1767224700;
//        Date date = DateToolUtil.;
//        LocalDateTime localDateTime = DateToolUtil.dateToLocalDateTime(date);

        Date date = DateToolUtil.timeStampToDate(a);
        LocalDateTime localDateTime = DateToolUtil.dateToLocalDateTime(date);
        System.out.println(localDateTime);

        String s = DateToolUtil.localDateTimeToStr(localDateTime);
        Long aLong = DateToolUtil.strToTimeStamp(s);
        System.out.println(aLong);
    }






    @Test
    public void fun2a() {

        byte[] voiceBytes = new byte[320];
        for (int i = 0; i < 100; i++) {
            voiceBytes[i]= (byte) i;
        }
        byte[] bytes = new byte[320];
        System.arraycopy(voiceBytes,0,bytes,0,voiceBytes.length);
        for (byte aByte : bytes) {
            System.out.println(aByte);
        }
    }



    @Test
    public void fun22() {
        for (int i = 0; i <100; i++) {
            byte[] bytes = new byte[320];
            pool.add(bytes);
//            System.out.println(pool.size());
        }

        for (int i = 0; i < 100; i++) {
            byte[] poll = pool.poll();
            if ((i % 2 == 0)) {
                pool.add(poll);
            }
            System.out.println(pool.size());
        }

        System.out.println(pool.size());

    }



    @Test
    public void fun1aa() {
//        byte[] headerOfPCMU = WaveFIle.headerOfPCMU;
//        System.out.println(Arrays.toString(headerOfPCMU));
//        String s = byteToHexString(headerOfPCMU);
//        System.out.println(s);

//        for (byte b : headerOfPCMU) {
//            short s=(short) b;
//            System.out.println(s);
//        }

        byte[] bytes = new byte[172];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i]=1;
        }
        System.out.println(Arrays.toString(bytes));
        byte[] bytes1 = new byte[160];
//        System.out.println(bytes1);
        System.out.println(Arrays.toString(bytes1));


        System.arraycopy(bytes, 12, bytes1, 0, 160);
        System.out.println(Arrays.toString(bytes1));
    }

    private String byteToHexString(byte[] bytes)
    {
        StringBuilder resultHexString = new StringBuilder();
        String tempStr;
        for (byte b: bytes) {
            //这里需要对b与0xff做位与运算，
            //若b为负数，强制转换将高位位扩展，导致错误，
            //故需要高位清零
            tempStr = Integer.toHexString(b & 0xff);
            //若转换后的十六进制数字只有一位，
            //则在前补"0"
            if (tempStr.length() == 1) {
                resultHexString.append(0).append(tempStr);
            } else {
                resultHexString.append(tempStr);
            }
        }
        return resultHexString.toString();
    }

























    public static void main(String[] args) throws JsonProcessingException {
//        byte[] bytes = NetByteUtil.intToBytes(100);
//        System.out.println(Arrays.toString(bytes));
//
//        byte[] bytes2 = NetByteUtil.intToByteBig(100);
//        System.out.println(Arrays.toString(bytes2));

//        byte[] bytes = new byte[4];
//        bytes[0]= (byte) 0x90;
//        bytes[1]= (byte) 0x01;
//        bytes[2]= 0;
//        bytes[3]= 0;
//        int i1 = NetByteUtil.bytesToIntLittle(bytes);
//        System.out.println(i1);

//        String s=null;
//        System.out.println("aa".equals(s));

        Name name = new Name();
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(name);
        System.out.println(s);

    }

    @Test
    public void fun1() {
        AtomicInteger atomicInteger = new AtomicInteger(1);

        for (int i = 0; i < 10; i++) {
        int andIncrement = atomicInteger.getAndIncrement();
        System.out.println(andIncrement);
        }
        System.out.println(atomicInteger);
        System.out.println(atomicInteger);
        System.out.println(atomicInteger);

    }

}
