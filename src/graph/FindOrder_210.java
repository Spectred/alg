package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/course-schedule-ii/">210. 课程表 II</a>
 */
public class FindOrder_210 {
    List<Integer> res = new LinkedList<>();
    boolean[] visited;
    boolean[] onPath;
    boolean hasCycle = false;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) traverse(i, graph);

        if (hasCycle) return new int[]{};


        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) ans[i] = res.get(i);

        return ans;
    }

    private void traverse(int s, List<Integer>[] graph) {
        if (onPath[s]) hasCycle = true;
        if (visited[s] || hasCycle) return;

        visited[s] = onPath[s] = true;
        for (int v : graph[s]) traverse(v, graph);

        onPath[s] = false;
        res.add(s);
    }

    private List<Integer>[] buildGraph(int s, int[][] prerequisites) {
        List<Integer>[] graph = new LinkedList[s];
        for (int i = 0; i < s; i++) graph[i] = new LinkedList<>();
        for (int[] e : prerequisites) graph[e[0]].add(e[1]);
        return graph;
    }
}
