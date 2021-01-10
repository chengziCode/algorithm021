package practice.dynamicprogram;

/**
 * 64 最小路径和 https://leetcode-cn.com/problems/minimum-path-sum/
 */
public class MinPathSum {

    public static void main(String[] args) {
        System.out.println(new MinPathSum().minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }


    /**
     * 动态规划：
     * 构造一个二维数组， 每个格子代表从(0,0)位置到当前位置的最小和。 结果取 (m, n)
     *
     * dp方程：
     * 初始化(除 (0, 0)外 )：
     * dp[m][n] = dp[m][n - 1] + grid[m][n];   //m = 0
     * dp[m][n] = dp[m - 1][n] + grid[m][n];   //n = 0
     *
     * dp[m][n] = Math.min(dp[m][n - 1], dp[m - 1][n]) + grid[m][n];
     */
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];

        for (int m = 0; m < row; m++) {
            for (int n = 0; n < col; n++) {
                if (m == 0 && n > 0) dp[m][n] = dp[m][n - 1] + grid[m][n]; //初始化 m = 0 && n > 0
                else if (m > 0 && n == 0) dp[m][n] = dp[m - 1][n] + grid[m][n]; //初始化 n = 0 && m > 0
                else if (m > 0) {
                    dp[m][n] = Math.min(dp[m][n - 1], dp[m - 1][n]) + grid[m][n];
                }
            }
        }

        return dp[row - 1][col - 1];
    }


}
