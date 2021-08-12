package ch2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuchao
 * @create 2021-08-12-12:51 下午
 */
public class Code02_KMTimes {

    public static int test(int[] arr, int k, int m) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int num : arr) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        for (int num : map.keySet()) {
            if (map.get(num) == k) {
                return num;
            }
        }

        return -1;
    }

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

        System.out.println(test(arr, 2, 4));
    }

}
