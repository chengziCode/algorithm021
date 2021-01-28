package practice.string;


// 151. 翻转字符串里的单词 https://leetcode-cn.com/problems/reverse-words-in-a-string/
public class ReverseWords {

    public static void main(String[] args) {
        System.out.println(new ReverseWords().reverseWords("a good   example"));
    }
    public String reverseWords(String s) {
        String[] str = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = str.length - 1; i >= 0; i--) {
            if (!str[i].equals("")) {
                sb.append(str[i]);
                if(i > 0) sb.append(" ");
            }
        }
        return sb.toString();
    }
}
