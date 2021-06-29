package cn.dhx.boot.file;

public class ThreadDemo implements Runnable {
    @Override
    public void run() {
        while (true) {
            int i=0;
            for ( i= 0; i < 100; i++) {

            }
            if (i % 5 == 0) {
                break;
            }
        }
        System.out.println("---------------");
    }
}
