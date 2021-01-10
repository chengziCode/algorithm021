package practice.dynamicprogram;


/**
 * 198 打家劫舍 https://leetcode-cn.com/problems/house-robber/
 */
public class Rob {
    public static void main(String[] args) {
        System.out.println(new Rob().rob(new int[]{2, 1, 1, 2}));
    }

    /**
     * 动态规划：
     * dp方程： 二维数组第二维 ： 1 - 偷， 0 - 不偷
     *
     * // 这一次不偷 = max（上一次不偷， 上一次偷） 注意的是“上一次偷” 不一定大于 “上一次不偷”
     * dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
     *
     * // 这一次偷 = 上一次不偷 + 偷这一次的钱
     * dp[i][1] = dp[i - 1][0] + nums[i];
     *
     */
    public int rob(int[] nums) {
        int size = nums.length + 1;
        int[][] dp = new int[size][2];
        for (int i = 1; i < size; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i - 1];
        }
        return Math.max(dp[size - 1][0], dp[size - 1][1]);
    }

}
