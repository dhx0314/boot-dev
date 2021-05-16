package cn.dhx.jvm.a2_2;

public class StacksDemo2 {

    public static void main(String[] args) throws InterruptedException {
        StringBuilder sb = new StringBuilder();
        sb.append(4);
        new Thread(()->{
            m2(sb);
        }).start();
        sb.append(5);
        sb.append(6);
        Thread.sleep(1000);
        System.out.println("---------------");
        StringBuffer sb2 = new StringBuffer();
        sb2.append(4);
        new Thread(()->{
            m3(sb2);
        }).start();
        sb2.append(5);
        sb2.append(6);


    }



    public static void m1() {
        StringBuffer sb = new StringBuffer();
        sb.append(1);
        sb.append(2);
        sb.append(3);
        System.out.println(sb.toString());
    }

    public static void m2(StringBuilder sb) {
        sb.append(1);
        sb.append(2);
        sb.append(3);
        System.out.println(sb.toString());
    }

    public static void m3(StringBuffer sb) {
        sb.append(1);
        sb.append(2);
        sb.append(3);
        System.out.println(sb.toString());
    }


    public static StringBuilder m4() {
        StringBuilder sb = new StringBuilder();
        sb.append(1);
        sb.append(2);
        sb.append(3);
        return sb;
    }




}
