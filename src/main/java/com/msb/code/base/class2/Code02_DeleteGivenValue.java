package com.msb.code.base.class2;

/**
 * 删除链表中所有给定的数的节点
 */
public class Code02_DeleteGivenValue {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node removeValue(Node head, int num) {
        // 删除头结点为num的节点
        while (head != null) {
            if (head != null) {
                break;
            }
            head = head.next;
        }

        Node pre = head;
        Node cur = head;

        while (cur != null) {
//            if (cur.value == num) {
//                pre.next = cur.next;
//            } else {
//                pre = cur;
//            }
//            cur = cur.next;

            // 下面是自己写的，不完善 todo num的上一个节点不能找到下一个节点
            Node next = cur.next;

            if (cur.value == num) {
                cur.next = next.next;
            }
            cur = next;
        }

        return head;
    }
}
