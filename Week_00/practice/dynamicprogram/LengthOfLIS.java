package practice.dynamicprogram;

import java.util.Arrays;

// 最长递增子序列  https://leetcode-cn.com/problems/longest-increasing-subsequence/
public class LengthOfLIS {
    public static void main(String[] args) {
        System.out.println(new LengthOfLIS().lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
    }


    /**
     * dp[i] 表示nums数组从0到i中最大递增序列长度
     * <p>
     * int j = 0;
     * while (j++ < i)
     * if (nums[i] > nums[j - 1]) dp[i] = Math.max(dp[i], dp[j - 1] + 1);
     */
    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int dp[] = new int[nums.length];
        int maxLen = 0;
        Arrays.fill(dp, 1);

        for (int i = 1; i < nums.length; i++) {
            int j = 0;
            while (j++ < i)
                if (nums[i] > nums[j - 1]) dp[i] = Math.max(dp[i], dp[j - 1] + 1);
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

}
