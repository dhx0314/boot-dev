package cn.dhx.boot.file;

public class Demo2 {

    public static void main(String[] args) {
        new Thread(() -> {
            int i = 1;
            while (true) {
                for (; i < 24; i++) {
                    System.out.println(i);
                    if (i % 5 == 0) {
                        break;
                    }
                }
                if (i % 5 == 0) {
                    break;
                }
            }
            System.out.println("---------------");
        }).start();

    }
}
