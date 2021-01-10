package practice.dynamicprogram;

import java.util.Arrays;

/**
 * 322 零钱兑换 https://leetcode-cn.com/problems/coin-change/
 */
public class CoinChange {
    public static void main(String[] args) {
        System.out.println(new CoinChange().coinChange(new int[]{1, 2, 5}, 11));
    }

    /**
     * 解法：
     * 1 递归
     * 2 动态规划
     *
     *  动态规划：
     *  类似爬楼梯的斐波那契数列。
     *  分治：dp[amount] = Math.min(dp[amount - k]) + 1; k为 coints数组中的硬币数。 即： 取amount - k对应的钱的最小硬币数加上 1个（k硬币）
     *  即为当前最小硬币数
     */
    public int coinChange(int[] coins, int amount) {
        int size = amount  + 1;
        int[] dp = new int[size];
        Arrays.fill(dp, size); //填充数组，用于最后判断，如果只数组下标对应的为amount + 1 (size),说明没有被改动，就是没有对应的硬币分配方案。
        dp[0] = 0;

        for (int i = 1; i < size; i++) {
            for(int k = 0; k < coins.length; k++){
                if(i - coins[k] >= 0)
                    dp[i] = Math.min(dp[i],dp[i - coins[k]] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
