package snap.class01;

import ch3.Code03_ReverseLinkList;

/**
 * @author yuchao
 * @create 2022-09-06-22:26
 */
public class Class04_reverseList {

    public static class Node {
        private int data;

        private Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static class DoubleNode {

        private int data;

        private DoubleNode next;

        private DoubleNode pre;

        public DoubleNode(int data) {
            this.data = data;
        }
    }

    public static Node reverseList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    // 双向链表反转
    public static DoubleNode reverseDoubleList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.pre = next;
            pre = head;
            head = next;
        }

        return pre;
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(" " + head.data);
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        printList(a);

        printList(reverseList(a));
    }


}
