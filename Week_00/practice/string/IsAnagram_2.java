package practice.string;

//242 有效的字母异位词 https://leetcode-cn.com/problems/valid-anagram/
public class IsAnagram_2 {

    public static void main(String[] args) {
        System.out.println('b' - 'a');
    }

    public boolean isAnagram(String s, String t) {
        /*int[] arrCnt = new int[26];
        for (char ch : s.toCharArray()) arrCnt[ch - 'a']++;
        for (char ch : t.toCharArray()) arrCnt[ch - 'a']--;
        for (int num : arrCnt) if (num != 0) return false;
        return true;*/


        int[] arr = new int[26];
        int index = 0;
        for (int i = 0; i < s.length(); i++)  arr[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++)  arr[t.charAt(i) - 'a']--;
        while (index < arr.length) if(arr[index++] != 0) return false;
        return true;
    }
}
