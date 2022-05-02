package ch12;

/**
 * @author yuchao
 * @create 2022-02-15-10:08 下午
 */
public class Code05_hanoi {

    public static class Record {
        public boolean finish1;
        public int base;
        public String from;
        public String to;
        public String other;

        public Record(boolean f1, int b, String f, String t, String o) {
            this.finish1 = f1;
            this.base = b;
            this.from = f;
            this.to = t;
            this.other = o;
        }
    }

    public static void hanoi3(int M) {

    }

    public static void hanoi2(int n) {
        if (n > 0) {
            func(n, "left", "right", "mid");
        }
    }

    private static void func(int n, String from, String to, String other) {
        if (n == 1) {
            System.out.println("Move 1 from " + from + " to " + to);
        } else {
            func(n - 1, from, other, to);
            System.out.println("Move " + n + " from " + from + " to " + to);
            func(n - 1, other, to, from);

        }
    }

    public static void main(String[] args) {
        hanoi2(10);
    }

}
