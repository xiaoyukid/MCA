package ch2;

/**
 *
 *
 * 1. 不用 for 循环，找到二进制最右侧的 1
 * (x & (-x))
 *
 * -x 相当于 ~x+1。~x 将所有位取反，则最右侧连续的 0 变成 1。再加 1，
 * 会使得 ~x 最右侧的 0 进 1 变成 1，最右侧连续的 1 变成 0。这样 x 与 -x 只有最右侧的 1 相同，其他位都相反：
 *
 * x:  1 1 0 0 0 ... 1 0 0 0
 * ~x: 0 0 1 1 1 ... 0 1 1 1
 * -x: 0 0 1 1 1 ... 1 0 0 0
 *
 * @author yuchao
 * @create 2021-08-11-12:52 下午
 */
public class Code02_EvenTimesOddTimes {

    //arr 中只有一种数，出现了奇数次
    public static void printOddTimesNum1(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        System.out.println(eor);
    }

    // arr 中有两种数，出现了奇数次
    public static void printOddTimesNum2(int[] arr) {

        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        //假设两个出线奇数次的数是A，B，此时ero = A^B

        //最右1  0000000010000
        int rightOne = eor & (-eor);

        int onlyOne = 0;

        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & rightOne) != 0) {
                onlyOne = onlyOne ^ arr[i];
            }
        }

        System.out.println(onlyOne + " " + (eor ^ onlyOne));

    }

    public static void main(String[] args) {
        int[] arr1 = { 3, 3, 2, 3, 1, 1, 1, 3, 1, 1, 1 };
        printOddTimesNum1(arr1);

        int[] arr2 = { 4, 3, 4, 2, 2, 2, 4, 1, 1, 1, 3, 3, 1, 1, 1, 4, 2, 2 };
        printOddTimesNum2(arr2);
    }
}
