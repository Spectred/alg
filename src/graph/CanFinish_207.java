package graph;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/course-schedule/">207. 课程表</a>
 */
public class CanFinish_207 {
    boolean[] visited;
    boolean[] onPath;
    boolean hasCycle = false;

    public static void main(String[] args) {
        int[][] prerequisites = new int[3][2];
        prerequisites[0] = new int[]{0, 1};
        prerequisites[1] = new int[]{1, 2};
        prerequisites[2] = new int[]{0, 1};
        boolean b = new CanFinish_207().canFinish(3, prerequisites);
        System.out.println(b);
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++)
            traverse(graph, i);

        return !hasCycle;
    }

    List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++)
            graph[i] = new LinkedList<>();

        for (int[] edge : prerequisites)
            graph[edge[0]].add(edge[1]);

        return graph;
    }


    void traverse(List<Integer>[] graph, int s) {
        if (onPath[s]) hasCycle = true;
        if (visited[s] || hasCycle) return;

        visited[s] = onPath[s] = true;
        for (Integer t : graph[s]) {
            traverse(graph, t);
        }
        onPath[s] = false;
    }
}
