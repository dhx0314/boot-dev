package cn.dhx.jvm.ClassLoader02;

/**
 * @Author daihongxin
 * @create 2023/3/25 16:43
 */
public class ClassInitTest {

    private static int a=1;

    static {
        a=10;
        b=20;
//        System.out.println(b); Illegal forward reference
    }


    private static int b=2;

    /**
     * static 有执行顺序 按语句在源文件中出现的顺序执行
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(ClassInitTest.a);//10
        System.out.println(ClassInitTest.b);//2
    }
}
