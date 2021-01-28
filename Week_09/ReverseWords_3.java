// 557. 反转字符串中的单词 III https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
public class ReverseWords_3 {

    public static void main(String[] args) {
        System.out.println(new ReverseWords_3().reverseWords("Let's take LeetCode contest"));
        System.out.println(new ReverseWords_3().reverseWords_2("Let's take LeetCode contest"));
    }

    /**
     * 系统api解法
     */
    public String reverseWords(String s) {
        String[] strArr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            if (!strArr[i].equals("")) sb.append(new StringBuilder(strArr[i]).reverse().toString());
            if (i < strArr.length - 1) sb.append(" ");
        }
        return sb.toString();
    }


    /**
     * 双指针解法
     */
    public String reverseWords_2(String s) {
        char[] chArr = s.toCharArray();
        int start = 0, end = 0, length = s.length();
        while (end < length) {
            while (end < length && chArr[end] != ' ') end++; //找到空格，然后翻转空格前的单词
            swapChar(chArr, start, end - 1);
            start = end++ + 1;
        }
        return new String(chArr);
    }

    private void swapChar(char[] chArr, int start, int end) {
        while (start < end) {
            char tmp = chArr[start];
            chArr[start++] = chArr[end];
            chArr[end--] = tmp;
        }
    }
}
