package com.zuoshen.code.lesson.class3;

import java.util.*;

/**
 * 翻转链表
 *
 * @author 19041347
 */
public class ReverseLinkList {

    /**
     * A -> B -> C .. C-> B-> A
     */
    public static Node reverseMethod(Node h) {

        Node pre = null;
        Node next = null;
        while (h != null) {
            next = h.next;
            h.next = pre;
            pre = h;
            h = next;
        }

        return pre;
//        Node head = h;
//        Node next = null;
//        while (h.next != null) {
//            head = head.next;
//            head.next = next;
//            next = head;
//        }
//        return head;
    }

    public static Node arrayMethod(Node h) {
        Node head = h;
        List<Node> list = new ArrayList<>();
        while (head.next != null) {
            list.add(head);
            head = head.next;
        }
        Node curNode = head;
        for (int i = list.size() - 2; i >= 0; i--) {
            Node node = list.get(i);
            curNode.next = node;
        }
        return head;
    }


    public static void main(String[] args) {
//        Node node1= new Node(1, null);
//        Node node2= new Node(2, null);
//        Node node3= new Node(3, null);
//        node1.next = node2;
//        node2.next = node3;
//
//        Node node = reverseMethod(node1);
//        System.out.println(node.value);


        int testTime = 100;
        int listRange = 9;
        int valueRange = 100;
        System.out.println("开始");
        for (int i = 0; i < testTime; i++) {
            int size = (int) (Math.random() * listRange) + 1;
            Node head = randomList(size, valueRange);
            Node copyHead = copyList(head);
            Node node = reverseMethod(head);
            Node copyNode = arrayMethod(copyHead);

            if (node.value == copyNode.value) {
                System.out.println("出错了");
            }
        }
        System.out.println("success");
    }

    private static Node copyList(Node head) {
        Node copyH = new Node(head.value, null);
        Node cur = copyH;
        while (head.next != null) {
            cur.next = new Node(head.next.value, null);
            cur = cur.next;
        }
        return copyH;
    }

    private static Node randomList(int size, int valueRange) {
        Node head = new Node(getRandomValue(valueRange), null);
        Node cur = head;
        Node returnNode = head;
        for (int i = 1; i < size; i++) {
            Node next = new Node(getRandomValue(valueRange), null);
            cur.next = next;
        }
        return returnNode;
    }

    private static int getRandomValue(int valueRange) {
        return ((int) (Math.random() * valueRange) + 1) - ((int) (Math.random() * valueRange) + 1);
    }

}

class Node {
    public Node(int value, Node node) {
        this.next = node;
        this.value = value;
    }
    public int value;
    public Node next;
}
