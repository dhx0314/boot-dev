package cn.dhx.jvm.a2_5;


//  StringTable ["a","b","ab"]  hashtable结构 不能扩容

public class StringDemo {

    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "b";
        String s3 = "ab";
        String s4 = s1 + s2; //new StringBuilder().append("a").append("b").toString()   --> new String("ab")

        System.out.println(s3 == s4);

    }
}
