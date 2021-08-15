package ch3;

/**
 * @author yuchao
 * @create 2021-08-14-10:54 上午
 */
public class Code03_DeleteGivenNum {


    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node removeValue(Node head, int num) {

        while (head != null && head.value == num) {
            head = head.next;
        }

        Node cur = head;
        Node pre = head;
        while (cur != null) {
            if (cur.value == num) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }

            cur = cur.next;
        }

        return head;
    }


}


//双链表实现队列,栈

//数组实现

//如何用栈结构实现队列结构

//如何用队列结构实现栈结构