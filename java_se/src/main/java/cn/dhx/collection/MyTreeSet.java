package cn.dhx.collection;

import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;

public class MyTreeSet {

    @Test
    public void fun1() {
        TreeSet<String> treeSet = new TreeSet<>(new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {

                // 从小到大
//                return ((String) o1).compareTo((String) o2);

//                return ((String) o2).compareTo((String) o1);

                return ((String) o1).length() - ((String) o2).length();

            }
        });

        treeSet.add("ddd");
        treeSet.add("cccc");
        treeSet.add("aa");
        treeSet.add("t");
        System.out.println(treeSet);
    }
}
