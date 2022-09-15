package snap.class01;

import java.util.Stack;

/**
 * 栈实现队列
 *
 * @author yuchao
 * @create 2022-09-15-15:27
 */
public class Class04_stackQueue {

    public static class MyStackQueue<T> {

        private Integer size;

        private Integer limit;

        private Stack<T> pushStack;

        private Stack<T> popStack;

        public MyStackQueue(int limit) {
            pushStack = new Stack<>();
            popStack = new Stack<>();
            this.size = 0;
            this.limit = limit;
        }

        public void enQueue(T t) {
            if (size == limit) {
                throw new RuntimeException("queue is full");
            }
            size++;
            pushStack.push(t);
        }

        public T deQueue() {
            size--;
            if (!popStack.empty()) {
                return popStack.pop();
            }

            while (!pushStack.empty()) {
                popStack.push(pushStack.pop());
            }

            T val = popStack.pop();

            return val;
        }

        public boolean empty() {
            return size == 0;
        }

    }

    public static void main(String[] args) {
        MyStackQueue<Integer> stackQueue = new MyStackQueue<>(5);
        stackQueue.enQueue(1);
        stackQueue.enQueue(2);

        System.out.println(stackQueue.deQueue());

        System.out.println("-------------------------------");
        stackQueue.enQueue(3);
        stackQueue.enQueue(4);
        stackQueue.enQueue(5);


        while (!stackQueue.empty()) {
            System.out.println(stackQueue.deQueue());
        }


    }

}
