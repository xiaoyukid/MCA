package ch1;

/**
 * sort
 *
 * @author yuchao
 * @create 2021-08-08-9:34 上午
 */
public class Sort {


    public static void selectionSort(int[] arr) {

        if (arr == null || arr.length < 2) {
            return;
        }

        //0 ~ N-1  找到最小值，在哪，放到0位置上
        //1 ~ N-1  找到最小值，在哪，放到1位置上
        //2 ~ N-1  找到最小值，在哪，放到2位置上
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);

        }
    }


    public static void bubbleSort() {

    }

    public static void insertSort() {

    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[j] = arr[i];
        arr[i] = tmp;
    }
}
