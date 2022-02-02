package ch11;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yuchao
 * @create 2022-01-30-4:07 下午
 */
public class Code01_BFS {

    public static void bfs(Node start) {
        if (start == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        queue.add(start);
        set.add(start);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.println(cur.value);
            for (Node next : cur.nexts) {
                if (!set.contains(next)) {
                    set.add(next);
                    queue.add(next);
                }
            }
        }

    }
}
