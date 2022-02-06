package ch4;

/**
 * 堆排序
 *
 * @author yuchao
 * @create 2022-02-06-10:38 下午
 */
public class Code02_HeapSort {

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        //构建堆结构 最大堆
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }

        // TODO: 2022/2/6

    }

    //heap insert 插入堆中 放入最后的位置 能否往上走
    private static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
