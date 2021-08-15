package ch3;

/**
 * @author yuchao
 * @create 2021-08-14-10:22 上午
 */
public class Code03_ReverseLinkList {

    public static class Node {
        private int data;

        private Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static Node reverseLinkedList(Node head) {
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

    public static void printNode(Node head) {

        System.out.println();

        while (head != null) {
            System.out.print(" " + head.data);
            head = head.next;
        }

    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);

        a.next = b;
        b.next = c;
        c.next = d;

        printNode(a);

        printNode(reverseLinkedList(a));
    }


}
