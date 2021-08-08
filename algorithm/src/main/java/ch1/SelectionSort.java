package ch1;

/**
 * sort
 *
 * @author yuchao
 * @create 2021-08-08-9:34 上午
 */
public class SelectionSort {


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


    public static void bubbleSort(int[] arr) {

        if (arr == null || arr.length < 2) {
            return;
        }
        // 0 ~ N-1
        // 0 ~ N-2
        // 0 ~ N-3
        for (int i = arr.length - 1; i > 0; i--) {

            for (int j = 0; j < i; j++) {

                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }

            }
        }

    }

    public static void insertSort(int[] arr) {

        if (arr == null || arr.length < 2) {
            return;
        }
        // 0 ~ i 做到有序
        for (int i = 1; i < arr.length; i++) {

            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }

        }

    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[j] = arr[i];
        arr[i] = tmp;
    }
}
