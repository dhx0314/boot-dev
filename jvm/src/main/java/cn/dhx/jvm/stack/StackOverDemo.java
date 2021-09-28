package cn.dhx.jvm.stack;



// java.lang.StackOverflowError
// -Xss 256k
public class StackOverDemo {

    private static int count;

    public static void main(String[] args) {
        try {
            m1();
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println(count);
        }

    }

    private static void m1() {
        count++;
        m1();
    }
}
