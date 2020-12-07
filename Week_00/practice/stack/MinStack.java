package practice.stack;

import java.util.Stack;
//155  最小栈
public class MinStack {
    Stack<Integer> stack;
    int minValue;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.size() > 0 && x <= minValue) {
            stack.push(minValue);
            minValue = x;
        } else if (stack.size() == 0) {
            minValue = x;
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.pop() == minValue && stack.size() > 0) minValue = stack.pop();
    }


    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minValue;
    }
}
