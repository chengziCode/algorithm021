package practice.dynamicprogram;


/**
 * 1143 最长公共子序列  https://leetcode-cn.com/problems/longest-common-subsequence/
 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        System.out.println(new LongestCommonSubsequence().longestCommonSubsequence("abced","acd"));

    }

    /**
     * 解法：
     * 分治： 如果2个比较的子串的最后一个相同时，那么就是除最后一个字符串以外前面的最大子序列数 + 1.
     *       当2个比较的子串的最后一个不相同时，那么就是取 “每个子串分别删除最后一个字符时”取最大的列数。
     */
    public int longestCommonSubsequence(String text1, String text2){
        int len1 = text1.length() + 1;// + 1 是因为index = 0 作为dp方程式的累加启动行，实际操作的数值从index = 1开始
        int len2 = text2.length() + 1;//
        int[][] dp = new int[len1][len2];

        //构造 dp table
        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) { //比较2个子串的是否相同
                    dp[i][j] = 1 + dp[i - 1][j - 1]; // 相同就是上一个子串的最长公共子序列数 + 1
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]); // 否则就是 删除每个子串的最后一个字符后，取最大公共数
                }
            }
        }
        return dp[len1 - 1][len2 - 1];
    }
}
