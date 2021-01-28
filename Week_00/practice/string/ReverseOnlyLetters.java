package practice.string;

//917 仅仅翻转字母 https://leetcode-cn.com/problems/reverse-only-letters/
public class ReverseOnlyLetters {

    public static void main(String[] args) {
        System.out.println(new ReverseOnlyLetters().reverseOnlyLetters("7_28]"));

    }

    /**
     * 双指针夹逼
     */
    public String reverseOnlyLetters(String S) {
        int begin = 0, end = S.length() - 1;
        char[] charArray = S.toCharArray();

        while (begin < end) {
            while (!Character.isLetter(charArray[begin]) && begin < end) begin++;
            while (!Character.isLetter(charArray[end]) && begin < end) end--;
            char tmp = charArray[begin];
            charArray[begin++] = charArray[end];
            charArray[end--] = tmp;
        }
        return new String(charArray);
    }
}
