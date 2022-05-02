package ch12;

import java.util.Stack;

/**
 * @author yuchao
 * @create 2022-02-14-9:14 上午
 */
public class Code05_ReverseStackUsingRecursive {

    public static void recursive(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int last = f(stack);
        recursive(stack);
        stack.push(last);
    }

    public static int f(Stack<Integer> stack) {

        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = f(stack);
            stack.push(result);
            return last;
        }
    }

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);

        System.out.println(stack);

        recursive(stack);

        System.out.println(stack);
    }

}
