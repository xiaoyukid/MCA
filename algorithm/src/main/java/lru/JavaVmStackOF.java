package lru;

/**
 * -Xss160K
 * @author yuchao
 * @create 2022-02-24-4:00 下午
 */
public class JavaVmStackOF {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVmStackOF oom = new JavaVmStackOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stackLength =" + oom.stackLength);
            throw e;
        }
    }
}
