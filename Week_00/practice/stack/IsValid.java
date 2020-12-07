package practice.stack;


import java.util.Stack;

// 20 有效的括号
public class IsValid {

    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        stack.pop();

    }

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
