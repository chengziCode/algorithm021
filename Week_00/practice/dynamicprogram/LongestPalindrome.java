package practice.dynamicprogram;

//5 最长回文子串  https://leetcode-cn.com/problems/longest-palindromic-substring/
public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().longestPalindrome(""));
    }


    /**
     * 动态规划
     *
     *
     */
    public String longestPalindromeByDp(String s) {
        

        return null;
    }



    /**
     * 遍历每个字符 ， 向两边扩散
     */
    public String longestPalindrome(String s) {
        String maxLenStr = s.substring(0,1);
        for (int i = 0; i < s.length(); i++) {
            String len1Str = "";
            if (i > 0) len1Str = getPalindrome(s, i - 1, i + 1);
            String len2Str = getPalindrome(s, i, i + 1);
            String resStr = len1Str.length() > len2Str.length() ? len1Str : len2Str;
            maxLenStr = maxLenStr.length() > resStr.length() ? maxLenStr : resStr;
        }
        return maxLenStr;
    }

    private String getPalindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--; r++;
        }
        return s.substring(l + 1, r);
    }

}
