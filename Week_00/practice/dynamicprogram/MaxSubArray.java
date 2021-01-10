package practice.dynamicprogram;

/**
 * 53 最大序和 https://leetcode-cn.com/problems/maximum-subarray/
 */
public class MaxSubArray {

    public static void main(String[] args) {
        System.out.println(new MaxSubArray().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
//        System.out.println(new MaxSubArray().maxSubArray(new int[]{-2,-1}));
    }

    /**
     * 动态规划：dp[i] = Math.max(dp[i - 1], 0) + nums[i];  当前数的上一个序列和是否大于0， 大于0就加上当前数作为当前最大序列和，
     * 否则取当前数作为最大序列和。
     */
    public int maxSubArray(int[] nums) {
        int cur = 0,  res = nums[0];
        for(int i = 0; i < nums.length; i++){
            cur = Math.max(cur, 0) + nums[i];
            res = Math.max(cur, res);
        }
        return res;
    }
}
