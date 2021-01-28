public class MaxProfit {


    public int maxProfit(int[] prices) {

        /**
         *
         * i - 天
         * k - 是否卖出 1：卖出  0：没有卖出
         *
         * dp[0][0] = prices[i]; //持有股票的钱
         *
         * i > 0
         * dp[i][1] = Math.max(dp[i - 1][1], prices[i] - dp[i - 1][0]); //卖了的利润
         * dp[i][0] = Math.min(dp[i - 1][0], prices[i]); //持有成本最低的股票
         *
         */

        int[][] dp = new int[prices.length][2];
        dp[0][0] = prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][1] = Math.max(dp[i - 1][1], prices[i] - dp[i - 1][0]); //卖了的利润
            dp[i][0] = Math.min(dp[i - 1][0], prices[i]); //持有成本最低的股票
        }
        return dp[prices.length - 1][1];
    }
}
