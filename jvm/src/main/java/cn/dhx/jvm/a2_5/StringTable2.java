package cn.dhx.jvm.a2_5;

public class StringTable2 {
    public static void main(String[] args) {

        String x = "ab";
        String s = new String("a") + new String("b");
        String s2 = s.intern(); // 将这个字符串对象尝试放入串池，如果有则不会放入，
        // 如果没有则放入串池，会把串池中的对象返回

        System.out.println(s2 == x);  //true
        System.out.println(s == x);   // false

    }
}
