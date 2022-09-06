package snap.class01;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static ch4.Code02_HeapSort.printArray;

/**
 * @author yuchao
 * @create 2022-09-02-08:58
 */
public class Class02 {
    //printOddTimesNum1

    public static void printOddTimesNum1(int[] array) {
        int eor = 0;
        for (int i = 0; i < array.length; i++) {
            eor = eor ^ array[i];
        }

        System.out.println(eor);
    }

    //printOddTimesNum2 两种数出现了奇数次
    public static void printOddTimesNum2(int[] array) {

        int eor = 0;
        for (int i = 0; i < array.length; i++) {
            eor = eor ^ array[i];
        }
        //eor = a^b
        int rightOne = eor & (-eor);

        int eor2 = 0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & rightOne) == 1) eor2 = eor2 ^ array[i];
        }

        System.out.println(eor2 + "," + (eor ^ eor2));

    }

    /**
     * 数组中有一个数出现k次，其他数都出现了m次,K<M
     *
     * @param array
     * @param k
     * @param m
     */
    public static int kmTimes(int[] array, int k, int m) {

        int[] t = new int[32];

        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j < 32; j++) {
                t[j] += (array[i] >> j) & 1;
            }

        }

        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if (t[i] % m != 0) {
                ans = ans | (1 << i);
            }
        }

        return ans;

    }

    public static int test(int[] array, int k, int m) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : array) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        for (Integer integer : map.keySet()) {
            if (map.get(integer) == k) {
                return integer;
            }
        }
        return -1;
    }

    public static int randomNumber(int range) {
        return (int) (Math.random() * range) + 1;
    }

    public static int[] randomArray(int maxKind, int range, int k, int m) {

        int numKinds = ((int) (Math.random() * maxKind)) + 2;

        int[] array = new int[k + (numKinds - 1) * m];

        int kTimeNumber = randomNumber(range);

        int index = 0;
        for (; index < k; index++) {
            array[index] = kTimeNumber;
        }

        numKinds--;

        Set<Integer> set = new HashSet<>();
        set.add(kTimeNumber);
        while (numKinds != 0) {
            int curNum = 0;
            do {
                curNum = randomNumber(range);
            } while (set.contains(curNum));

            set.add(curNum);
            numKinds--;

            for (int i = 0; i < m; i++) {
                array[index++] = curNum;
            }

        }

        return array;
    }


    public static void main(String[] args) {

//        int[] array = new int[]{1, 2, 2, 2, 2, 4, 4};
//        printOddTimesNum1(array);
//
//        array = new int[]{1, 2, 2, 2, 2, 4, 4, 2};
//        printOddTimesNum2(array);
//
//
//        int[] arr = new int[]{2, 2, 1, 1, 1, 1, 5, 5, 5, 5};
//
//        System.out.println(kmTimes(arr, 2, 4));
//
//        System.out.println(test(arr, 2, 4));

//        int[] arr = new int[]{2, 2, 1, 1, 1, 1, 0, 0, 0, 0};
//
//        System.out.println(kmTimes(arr, 2, 4));
//
//        System.out.println(test(arr, 2, 4));

        int maxKid = 10;
        int range = 200;
        int testTime = 10;

        int max = 9;
        for (int i = 0; i < testTime; i++) {

            int a = (int) (Math.random() * max) + 1; // 1 ~ 9
            int b = (int) (Math.random() * max) + 1; // 1 ~ 9

            int k = Math.min(a, b);
            int m = Math.max(a, b);

            if (k == m) {
                m++;
            }

            int[] array = randomArray(maxKid, range, k, m);

            int t1 = kmTimes(array, k, m);
            int t2 = test(array, k, m);

            if (t1 != t2) {
                System.out.println("k:" + k + " m:" + m);
                printArray(array);
                System.out.println("wrong !!  t1:" + t1 + " t2:" + t2);
            }

        }
    }
}
