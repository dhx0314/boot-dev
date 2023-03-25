package cn.dhx.jvm.ClassLoader02;

/**
 * @Author daihongxin
 * @create 2023/3/25 16:43
 */
public class ClassInitTest2 {


    static {
        System.out.println("init");
    }

    /**
     * static 代码块在类加载阶段只会执行一次
     * @param args
     */
    public static void main(String[] args) {
        ClassInitTest2 classInitTest2 = new ClassInitTest2();
        ClassInitTest2 classInitTest3 = new ClassInitTest2();
    }
}
