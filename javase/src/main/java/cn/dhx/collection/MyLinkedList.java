package cn.dhx.collection;


import org.junit.Test;

import java.util.LinkedList;

public class MyLinkedList {

    @Test
    public void fun1() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");
        linkedList.add("4");
        System.out.println(linkedList.toString());

        linkedList.remove(1);
        System.out.println(linkedList.toString());
    }
}
