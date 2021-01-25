//242 有效的字母异位词 https://leetcode-cn.com/problems/valid-anagram/
public class IsAnagram {

    public static void main(String[] args) {
        System.out.println('b' - 'a');
    }

    public boolean isAnagram(String s, String t) {
        int[] arrCnt = new int[26];
        for (char ch : s.toCharArray()) arrCnt[ch - 'a']++;
        for (char ch : t.toCharArray()) arrCnt[ch - 'a']--;
        for (int num : arrCnt) if (num != 0) return false;
        return true;
    }
}
