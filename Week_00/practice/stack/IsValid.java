package practice.stack;


import java.util.Stack;

// 20 有效的括号 https://leetcode-cn.com/problems/valid-parentheses/
public class IsValid {

    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        stack.pop();

    }

    public static boolean isValidByReplace(String s) {
        while (s.contains("()") || s.contains("{}") || s.contains("[]")) {
            if (s.contains("()")) s = s.replaceAll("\\(\\)","");
            if (s.contains("{}")) s = s.replaceAll("\\{\\}","");
            if (s.contains("[]")) s = s.replaceAll("\\[\\]","");
        }
        return s.length() == 0;
    }





    /**
     * 入栈 出栈法
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        if (chars.length % 2 != 0) {return false;}
        for (char c : chars) {
            if (c == '(') stack.push('(');
            else if (c == '{') stack.push('{');
            else if (c == '[') stack.push('[');
            else if (stack.size() > 0 && c == ')' && stack.pop() == '(') continue;
            else if (stack.size() > 0 && c == '}' && stack.pop() == '{') continue;
            else if (stack.size() > 0 && c == ']' && stack.pop() == '[') continue;
            else return false;
        }
        return stack.empty();
    }
}
