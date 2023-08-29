package cn.dhx.algorithm.data_structure.linkedlist;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author daihongxin
 * @create 2023/8/22 11:08
 */
@Slf4j
public class SinglyLinkedList {

    private Node head; // 头部节点

    private static class Node { // 节点类
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
