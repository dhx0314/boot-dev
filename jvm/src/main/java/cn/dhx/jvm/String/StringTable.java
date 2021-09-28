package cn.dhx.jvm.String;

public class StringTable {
    public static void main(String[] args) {
        String s = new String("a") + new String("b");
        String s2 = s.intern(); // 将这个字符串对象尝试放入串池，如果有则不会放入，
                                // 如果没有则放入串池，会把串池中的对象返回
        String x = "ab";
        System.out.println(s2 == x);  //true
        System.out.println(s == x);   //true

    }
}