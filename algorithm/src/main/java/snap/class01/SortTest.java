package snap.class01;

import static ch4.Code02_HeapSort.printArray;

/**
 * @author yuchao
 * @create 2022-08-28-22:29
 */
public class SortTest {

    //选择
    public static void selectSort(int[] array) {
        //0 ~ N-1  找到最小值，在哪，放到0位置上
        //1 ~ N-1  找到最小值，在哪，放到1位置上
        //2 ~ N-1  找到最小值，在哪，放到2位置上
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                //fixme 不需要每次交换，记住最小下标最后交换
//                if (array[i] > array[j]) {
//                    swap(array, i, j);
//                }

                minIndex = array[minIndex] > array[j] ? j : minIndex;
            }

            swap(array, i, minIndex);

        }

    }

    //冒泡
    // 0 ~ N-1
    // 0 ~ N-2
    // 0 ~ N-3
    public static void bubbleSort(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    //插入
    //0-0
    //0-1
    //0-2
    //0-n-1
    public static void insertSort(int[] array) {

        for (int i = 1; i < array.length; i++) {

            for (int j = i; j > 0 && array[j] < array[j - 1]; j--) {
                swap(array, j, j - 1);
            }

        }
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static int binarySearch(int[] array, int target) {

        insertSort(array);

        int L = 0;
        int R = array.length;

        while (L < R) {

            int mid = L + ((R - L) >> 1);

            if (array[mid] > target) {
                R = mid - 1;
            } else if (array[mid] < target) {
                L = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public static boolean exists(int[] sortedArr, int num) {

        int L = 0;
        int R = sortedArr.length;
        int mid = 0;

        while (L < R) {
            mid = L + ((R - L) >> 1);
            if (sortedArr[mid] == num) {
                return true;
            } else if (sortedArr[mid] > num) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }

        return sortedArr[mid] == num;
    }


    public static void main(String[] args) {

        int[] array = new int[]{5, 4, 7, 8, 29, 18, 1, 22};
        selectSort(array);
        printArray(array);

        System.out.println(binarySearch(array, 30));
        System.out.println(exists(array, 30));
    }

}
