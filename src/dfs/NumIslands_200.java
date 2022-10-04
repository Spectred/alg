package dfs;

/**
 * <a href="https://leetcode.cn/problems/number-of-islands/">200. 岛屿数量</a>
 */
public class NumIslands_200 {


    public int numIslands(char[][] grid) {
        int res = 0, m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private void dfs(char[][] matrix, int i, int j) {
        int m = matrix.length, n = matrix[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) return;
        if (matrix[i][j] == '0') return;
        matrix[i][j] = '0';
        for (int[] d : dirs)
            dfs(matrix, i + d[0], j + d[1]);
    }
}
