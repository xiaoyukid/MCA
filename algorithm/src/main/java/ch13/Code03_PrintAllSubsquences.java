package ch13;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuchao
 * @create 2022-02-18-2:38 下午
 */
public class Code03_PrintAllSubsquences {

    public static List<String> subs(String s) {
        char[] str = s.toCharArray();
        String path = "";
        List<String> ans = new ArrayList<>();
        process1(str, 0, ans, path);
        return ans;
    }

    private static void process1(char[] str, int index, List<String> ans, String path) {
        if (index == str.length) {
            ans.add(path);
            return;
        }
        process1(str, index + 1, ans, path);
        process1(str, index + 1, ans, path + String.valueOf(str[index]));
    }

    public static void main(String[] args) {
        String test = "acccc";
        List<String> ans1 = subs(test);

        for (String str : ans1) {
            System.out.println(str);
        }
        System.out.println("=================");


    }

}
