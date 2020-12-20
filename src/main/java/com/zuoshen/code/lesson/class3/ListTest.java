package com.zuoshen.code.lesson.class3;

public class ListTest {

    public static class DoubleNode {
        public int value;
        public DoubleNode last;
        public DoubleNode next;

        public DoubleNode(int data) {
            value = data;
        }
    }

    /**
     * 反转双向链表
     *
     * @param head
     */
    public DoubleNode reverseDoubleList(DoubleNode head) {
        // pre next 作用是记录前一个后一个
        DoubleNode pre = null;
        DoubleNode next = null;

        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;

    }




}
