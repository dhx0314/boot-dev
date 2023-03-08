package cn.dhx.collection;

import org.junit.Test;

import java.util.HashSet;

public class MyHashSetIncrement {


    @Test
    public void fun1() {
        HashSet<Object> hashSet = new HashSet<>(64);
        for (int i = 0; i < 12; i++) {
            hashSet.add(new A(i));
        }

    }

}

class A{

    private int i;

    public A(int i) {
        this.i = i;
    }


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        A a = (A) o;
//        return i == a.i;
//    }

    @Override
    public int hashCode() {
        return 15;
    }
}
