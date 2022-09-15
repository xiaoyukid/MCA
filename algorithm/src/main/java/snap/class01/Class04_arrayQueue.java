package snap.class01;

/**
 * 数组实现队列
 *
 * @author yuchao
 * @create 2022-09-08-15:25
 */
public class Class04_arrayQueue {

    public static class ArrayQueue {

        private int size;

        private int[] array;

        private int pushIndex;

        private int popIndex;

        private final int limit;

        public ArrayQueue(int limit) {
            this.limit = limit;
            this.size = 0;
            array = new int[limit];
            pushIndex = 0;
            popIndex = 0;
        }

        public int deQueue() throws Exception {
            if (size == 0) {
                throw new Exception("queue is empty");
            }

            size--;

            int result = array[popIndex];

            this.popIndex = getNextIndex(popIndex);

            return result;
        }

        public void enQueue(int num) throws Exception {
            if (size == limit) {
                throw new Exception("queue is full");
            }
            size++;

            array[pushIndex] = num;

            this.pushIndex = getNextIndex(pushIndex);

            System.out.println(pushIndex);
        }

        private int getNextIndex(int index) {
            return index < array.length ? ++index : 0;
        }
    }

    public static void main(String[] args) throws Exception {
        ArrayQueue arrayQueue = new ArrayQueue(5);
        arrayQueue.enQueue(1);
        arrayQueue.enQueue(2);
        arrayQueue.enQueue(3);
        arrayQueue.enQueue(4);
        arrayQueue.enQueue(5);

        System.out.println(arrayQueue.deQueue());
        System.out.println(arrayQueue.deQueue());
        System.out.println(arrayQueue.deQueue());
        System.out.println(arrayQueue.deQueue());
        System.out.println(arrayQueue.deQueue());
        System.out.println(arrayQueue.deQueue());
        System.out.println(arrayQueue.deQueue());
    }

}
