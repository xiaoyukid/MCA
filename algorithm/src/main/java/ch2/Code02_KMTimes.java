package ch2;

/**
 * @author yuchao
 * @create 2021-08-12-12:51 下午
 */
public class Code02_KMTimes {

    public static int onlyKTimes(int[] arr, int k, int m) {

        int[] t = new int[32];

        for (int num : arr) {

            for (int i = 0; i < 32; i++) {
                t[i] += (num >> i) & 1;
            }
        }

        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if (t[i] % m != 0) {
                ans |= (1 << i);
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] arr = new int[]{2, 2, 1, 1, 1, 1};

        System.out.println(onlyKTimes(arr, 2, 4));
    }

}
