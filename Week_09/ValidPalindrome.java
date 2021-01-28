// 680 验证回文字符串 https://leetcode-cn.com/problems/valid-palindrome-ii/
public class ValidPalindrome {

    public static void main(String[] args) {
        System.out.println(new ValidPalindrome().validPalindrome
                ("lcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupucul"));
    }

    /**
     * 双指针 + 递归
     * @param s
     * @return
     */
    public boolean validPalindrome(String s) {
        int begin = 0, end = s.length() - 1;
        int cnt = 0;
        return isvalidPalindrome(s, begin, end, cnt);
    }

    private boolean isvalidPalindrome(String s, int begin, int end, int cnt) {
        if(cnt > 1) return false;
        if(begin >= end) return true;
        if (s.charAt(begin) == s.charAt(end)) return isvalidPalindrome(s, begin + 1, end - 1, cnt);
        return isvalidPalindrome(s, begin + 1, end, cnt + 1) || isvalidPalindrome(s, begin, end - 1, cnt + 1);
    }

}
