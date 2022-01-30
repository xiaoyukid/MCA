package ch11;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author yuchao
 * @create 2022-01-30-10:53 上午
 */
public class Graph {
    public HashMap<Integer, Node> nodes;
    public HashSet<Edge> edges;

    public Graph() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}
