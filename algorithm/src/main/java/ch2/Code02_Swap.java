package ch2;

/**
 * @author yuchao
 * @create 2021-08-11-12:43 下午
 */
public class Code02_Swap {

    public static void main(String[] args) {
        int a = 16;
        int b = 603;

        System.out.println(a);
        System.out.println(b);


        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println(a);
        System.out.println(b);


        int[] arr = {3,1,100};

        int i = 0;
        int j = 1;

        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];

        System.out.println(arr[i] + " , " + arr[j]);


    }


    public static void swap(int[] array, int i, int j) {
        array[i] = array[i] ^ array[j];
        array[j] = array[i] ^ array[j];
        array[i] = array[i] ^ array[j];
    }

}
