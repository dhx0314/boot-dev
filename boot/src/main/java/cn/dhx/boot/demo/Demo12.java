package cn.dhx.boot.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Demo12 {
    public static void main(String[] args)  {

////
//        List<String> list2 = new ArrayList<>();
//        list2.add("123");
//        list2.add("2332");
//        list2.add("awef");
//        list2.add("awe324f");
//
//        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>(list2);
//        Iterator<String> iterator = list.iterator();
//        while(iterator.hasNext()){
//            String next = iterator.next();
//            System.out.println("o  "+next);
//            if(next.equals("awef")) {
////                iterator.remove();
//                list.remove(next);
//            }
//            System.out.println(next);
//            System.out.println(list.size());
//        }
//
//        System.out.println("-----------------");
//        for (String s : list) {
//            System.out.println(s);
//        }
        ArrayList<Stu> stus = new ArrayList<>();
        stus.add(new Stu("aa", "11"));
        stus.add(new Stu("bb", "12"));
        stus.add(new Stu("cc", "13"));
        stus.add(new Stu("dd", "14"));

        for (Stu stu : stus) {
            System.out.println(stu);
        }

        stus.remove(new Stu("cc", "13"));

        System.out.println("----------------");
        for (Stu stu : stus) {
            System.out.println(stu);
        }
    }


}

class Stu {
    private String name;
    private String age;

    public Stu(String name, String age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stu stu = (Stu) o;

        if (name != null ? !name.equals(stu.name) : stu.name != null) return false;
        return age != null ? age.equals(stu.age) : stu.age == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (age != null ? age.hashCode() : 0);
        return result;
    }
}