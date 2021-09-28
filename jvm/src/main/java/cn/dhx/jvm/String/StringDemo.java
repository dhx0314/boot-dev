package cn.dhx.jvm.String;


//  StringTable ["a","b","ab"]  hashtable结构 不能扩容

public class StringDemo {

    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "b";
        String s3 = "ab";
        String s4 = s1 + s2; //new StringBuilder().append("a").append("b").toString()   --> new String("ab")
        String s5 = "a" + "b";  // javac在编译器的优化，结果已经在编译期间确定  确定为ab

        System.out.println(s3 == s4);//false
        System.out.println(s4 == s5);//false


    }
}
