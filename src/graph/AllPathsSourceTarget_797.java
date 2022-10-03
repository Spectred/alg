package graph;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/all-paths-from-source-to-target/">797. 所有可能的路径</a>
 */
public class AllPathsSourceTarget_797 {

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        LinkedList<Integer> path = new LinkedList<>();
        traverse(graph, 0, path);
        return res;
    }

    private void traverse(int[][] graph, int i, LinkedList<Integer> path) {
        path.addLast(i);

        if (i == graph.length - 1) {
            res.add(new LinkedList<>(path));
            path.removeLast();
            return;
        }
        for (int v : graph[i]) {
            traverse(graph, i, path);
        }
        path.removeLast();
    }
}
