package cn.dhx.demo;


public class MyTest {

    public static void main(String[] args) {

        try {
            int a = 20;
            int b = 20;
            float f = (float) (a + 1.2);
            double d = b + 1.2;
            float f2 = a + 1.2;
            System.out.println(f2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}



