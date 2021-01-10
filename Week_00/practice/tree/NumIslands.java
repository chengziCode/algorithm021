package practice.tree;

/**
 * 200 岛屿数量 https://leetcode-cn.com/problems/number-of-islands/
 */
public class NumIslands {

    public static void main(String[] args) {
//        char[][] grid = new char[3][3]{'1','1','0','1','0','1','0','1','1'};
        char[][] grid = {
                {'1','0','1'},
                {'1','0','1'},
                {'1','1','1'}};
        System.out.println(new NumIslands().numIslands(grid));
    }

    /**
     * 解题思路： 根据dfs找到水平/垂直方向的1，直到遇到0，岛屿数加1.
     */

    public int numIslands(char[][] grid) {
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && grid[i][j] == '1') { //没有被访问，并且为陆地(值等于 '1')
                    count++;
                    dfs(grid, i, j, visited);
                }
            }
        }
        return count;
    }


    private void dfs(char[][] grid, int row, int col, boolean[][] visited) {
        //recursion terminator
        if (row == grid.length || col == grid[0].length || row < 0 || col < 0) return;

        //process
        if (grid[row][col] == '1' && !visited[row][col]) {
            visited[row][col] = true;
            //drill down
            dfs(grid, row - 1 , col, visited);
            dfs(grid, row + 1, col, visited);
            dfs(grid, row, col - 1, visited);
            dfs(grid, row, col + 1, visited);
        }
    }
}
