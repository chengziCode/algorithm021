package practice.dynamicprogram;

/**
 * 91 解码方法 https://leetcode-cn.com/problems/decode-ways/
 */

public class NumDecodings {
    public static void main(String[] args) {
        System.out.println(new NumDecodings().numDecodings("203"));
    }
    /**
     * 动态规划：
     *  解法类似爬楼梯：因为编码数值最大到26，所以切分的子字符串最大长度为2，因此只需要关注字符串的最后2个字符即可.
     *  dp[i] 就等于i - 2到i要走的步数加上 i - 1到i要走的步数。但是有多种边界条件致使dp方程不一定是dp[i] =  dp[i -1] + dp[i - 2].
     *
     * dp方程： dp[i] 表示从第0个字符到第i个字符形成的字符串的解码数。
     *
     *
     *  当s[i] = '0' 时
     *      ①  s[i - 1] = '1' || s[i - 1] = '2' 方程式为 dp[i] = dp[i - 2].
     *  解释：
     *      因为最后一个字符为0，不能单独被解码，它只有和它前面的一个字符合为一个整体才有可能被解码，当字符是 1 或者 2，就可以当10或者20被解码了，
     * 那也就意味着和dp[i - 2]的解码数一样。
     *      例如： 2220 .   dp[3] = dp[3 -2].
     *                     dp[1]对应的字符串（22）组合有 2 2 和 22，共2种。
     *                     dp[3]对应的字符串（2220）组合有 2 2 20 和 22 20 共2种。
     *                     所以可以观察到dp[3] 就是在dp[1]的每种组合后面加了20这个数。 即dp[i] = dp[i - 2].
     *
     *      ②   否则直接返回 0 。 因为 00， 30 ，40 这种串使得整个串无法被解码
     *
     *
     *  当 0 < s[i - 1][i] <27 时
     *     ① dp[i] = dp[i - 1] + dp[i - 2];
     *   解释：
     *   字符串最后是0的情况分析完，就分析不是0的。 最后2个字符组成的数字范围是0到27,意味着这2个字符有2种解码组合。比如 26 可以是 2 6 和 26 两种。
     * 所以dp[i] = dp[i - 1] + dp[i - 2] 就是爬楼梯的思维。 i - 1 就是从 i - 1到 i的爬楼方法数加 i - 2到 i 的爬楼方法数。
     *
     *    ② 否则 dp[i] = dp[i - 1].  如果不满足 0 到 27的范围, 说明最后2个字符无法合在一起被解码。只能拆开解码，而拆开的解码数就等于dp[i -1].
     *    例如 23字符串的组合有 2 3 和 23 两种。  237字符串有2 3 7 和 23 7两种。 所以就是在i - 1组合后面加了 s[i]这个字符。
     */
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;
        int[] dp = new int[s.length()];
        dp[0] = 1; // 一个非0的数默认有1种解码

        for (int i = 1; i < s.length(); i++) {
            char si = s.charAt(i); //代数
            char si_1 = s.charAt(i - 1); //代数
            int dpi_2 = (i - 2) >= 0 ? dp[i - 2] : 1; //代数 表示 dp[i - 2]

            if(si == '0'){
                if(si_1 == '1' || si_1 == '2') dp[i] = dpi_2;
                else return 0;
            } else if(si_1 == '1' || si_1 == '2' && si > '0' && si < '7'){
                dp[i] = dp[i - 1] + dpi_2;
            } else dp[i] = dp[i - 1];
        }
        return dp[s.length() - 1];
    }
}
