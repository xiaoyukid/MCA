package ch13;

/**
 * @author yuchao
 * @create 2022-05-02-9:25 下午
 */
public class Code02_CardsInLine {

    public static int win1(int[] arr) {

        if (arr == null || arr.length == 0) {
            return 0;
        }

        int first = f1(arr, 0, arr.length - 1);
        int second = g1(arr, 0, arr.length - 1);

        return Math.max(first, second);

    }

    private static int f1(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }

        int p1 = arr[R] + g1(arr, L, R - 1);
        int p2 = arr[L] + g1(arr, L + 1, R);

        return Math.max(p1, p2);
    }

    private static int g1(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }

        int p1 = f1(arr, L, R - 1);
        int p2 = f1(arr, L + 1, R);

        return Math.min(p1, p2);
    }


    public static void main(String[] args) {
        int[] arr = {5, 7, 4, 5, 8, 1, 6, 0, 3, 4, 6, 1, 7};
        System.out.println(win1(arr));
    }


}
