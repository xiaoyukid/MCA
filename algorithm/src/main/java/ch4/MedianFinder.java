package ch4;

import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/leetbook/read/top-interview-questions/xalff2/
 *
 * @author yuchao
 * @create 2022-02-10-5:32 下午
 */
public class MedianFinder {

    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;

    private Integer minHeapSize;
    private Integer maxHeapSize;


    public MedianFinder() {
        this.minHeap = new PriorityQueue<>();
        this.maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

        this.minHeapSize = 0;
        this.maxHeapSize = 0;
    }

    public void addNum(int num) {
        if (maxHeapSize == 0) {
            maxHeap.add(num);
            maxHeapSize++;
        } else {
            if (maxHeapSize == minHeapSize) {
                if (num >= minHeap.peek()) {
                    maxHeap.add(minHeap.poll());
                    minHeap.add(num);
                } else {
                    maxHeap.add(num);
                }

                maxHeapSize++;

            } else {

                if (num < maxHeap.peek()) {

                    minHeap.add(maxHeap.poll());
                    maxHeap.add(num);

                } else {
                    minHeap.add(num);
                }

                minHeapSize++;

            }


        }
    }

    public double findMedian() {

        if (minHeapSize.equals(maxHeapSize)) {
            return (double) (maxHeap.peek() + minHeap.peek()) / 2;
        } else {
            return maxHeap.peek();
        }

    }

    public static void main(String[] args) {

        MedianFinder finder = new MedianFinder();

        finder.addNum(128);
        finder.addNum(138);
        finder.addNum(1);
        finder.addNum(2);
        finder.addNum(3);
        finder.addNum(4);
        finder.addNum(12);
        finder.addNum(14);
        finder.addNum(5);
        finder.addNum(6);
        finder.addNum(8);

        System.out.println(finder.findMedian());
    }
}
