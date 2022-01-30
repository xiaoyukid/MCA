package ch11;

/**
 * @author yuchao
 * @create 2022-01-30-10:54 上午
 */
public class Edge {
    public int weight;
    public Node form;
    public Node to;

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.form = from;
        this.to = to;
    }
}
