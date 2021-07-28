package cn.dhx.boot.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Demo12 {
    public static void main(String[] args)  {

        Stu stu = new Stu("1","2");
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                List<String> stringList = stu.getStringList();
                synchronized (stringList) {
                    stringList.add("23");
                    System.out.println(Thread.currentThread().getName()+"-----");
                    System.out.println(stringList.size());
                    stringList.remove(1);
                }
                synchronized (stringList) {

                }
            }).start();
        }

    }


}

class Stu {
    private String name;
    private String age;

    private List<String> stringList=new ArrayList<>();

    public List<String> getStringList() {
        return stringList;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    public Stu(String name, String age) {
        this.name = name;
        this.age = age;
        init();
    }

    public void init() {
        stringList.add("132");
        stringList.add("324");
        stringList.add("24");
        stringList.add("32");
        stringList.add("234");
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