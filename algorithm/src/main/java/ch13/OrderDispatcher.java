package ch13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/3f495307bfca40e49b0e2b15b14ce923
 * 来源：牛客网
 * <p>
 * 打车派单场景, 假定有N个订单， 待分配给N个司机。每个订单在匹配司机前，会对候选司机进行打分，打分的结果保存在N*N的矩阵A， 其中Aij 代表订单i司机j匹配的分值。
 * <p>
 * 假定每个订单只能派给一位司机，司机只能分配到一个订单。求最终的派单结果，使得匹配的订单和司机的分值累加起来最大，并且所有订单得到分配。
 *
 *
 * 增量调整 N个司机，可能有 M （M>N）个订单
 *
 * @author yuchao
 * @create 2022-04-29-12:56 下午
 */
public class OrderDispatcher {

    static double total = Integer.MIN_VALUE;
    static List<List<Integer>> res;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        double[][] scores = new double[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                scores[i][j] = sc.nextDouble();
            }
            sc.nextLine();
        }
        boolean[] vis = new boolean[N];
        dfs(0, N, scores, new ArrayList<>(), 0, vis);
        System.out.println(total);
        for (int i = 0; i < res.size(); i++) {
            for (int e : res.get(i)) {
                System.out.print(e + 1);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void dfs(int x, int n, double[][] scores, List<List<Integer>> temp, double sum, boolean[] vis) {
        if (x < 0 || x > n) return;
//        System.out.println("x:"+x);
//        System.out.println("sum:"+sum);
        if (x == n && sum > total) {
            res = new ArrayList<>(temp);
            total = sum;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                temp.add(Arrays.asList(x, i));
                vis[i] = true;
                dfs(x + 1, n, scores, temp, sum + scores[x][i], vis);
                vis[i] = false;
                temp.remove(temp.size() - 1);
            }
        }

    }
}
