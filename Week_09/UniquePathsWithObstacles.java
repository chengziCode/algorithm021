// 63 不同路径2 https://leetcode-cn.com/problems/unique-paths-ii/
public class UniquePathsWithObstacles {


    /**
     *
     * dp[0][0] = 1;
     * dp[0][j] = 1; //j > 0, 需要判断左侧没有障碍物
     * dp[i][0] = 1; //i > 0, 需要判断上方没有障碍物
     * dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1) return 0;
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        int[][] dp = new int[rows][cols];
        dp[0][0] = 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (obstacleGrid[i][j] == 0) {
                    if ((i == 0 || j == 0) && (i > 0 && dp[i - 1][j] > 0 || j > 0 && dp[i][j - 1] > 0))
                        dp[i][j] = 1; //初始化 第0行 第0列都为1
                    else if (i > 0 && j > 0)
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[rows - 1][cols - 1];
    }


}
