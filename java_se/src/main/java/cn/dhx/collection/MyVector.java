package cn.dhx.collection;

import org.junit.Test;

import java.util.Vector;

public class MyVector {

    @Test
    public void fun1() {
        Vector<String> vector = new Vector<>();
        vector.add("a");
        vector.add(null);
        vector.add("b");
        vector.add(null);
        System.out.println(vector.toString());
//        int newCapacity = oldCapacity + ((capacityIncrement > 0) ?
//                capacityIncrement : oldCapacity);
    }
}
