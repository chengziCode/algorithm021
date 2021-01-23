package practice.recusion;

import java.util.*;

//22 括号生成 https://leetcode-cn.com/problems/generate-parentheses/

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */


public class GenerateParenthesis {

    public static void main(String[] args) {

//        System.out.println(new GenerateParenthesis().generateParenthesis(3));
        System.out.println(new GenerateParenthesis().generateParenthesis_dp(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String> resList = new ArrayList<>();
        dfs(resList, "", 0, 0, n);
        return resList;
    }

    /**
     * dfs
     */
    private void dfs(List<String> resList, String s, int leftCnt, int rightCnt, int target) {
        // recursion terminator
        if (rightCnt == target && leftCnt == target) {
            resList.add(s);
            return;
        }

        // process 剪枝
        if (leftCnt < rightCnt) return;

        // drill down
        if (leftCnt < target) dfs(resList, s + "(", leftCnt + 1, rightCnt, target);
        if (rightCnt < target) dfs(resList, s + ")", leftCnt, rightCnt + 1, target);
    }


    /**
     * 动态规划
     */

    public List<String> generateParenthesis_dp(int n) {
        LinkedList<LinkedList<String>> result = new LinkedList<LinkedList<String>>();
        if (n == 0)
            return result.get(0);
        LinkedList<String> list0 = new LinkedList<String>();
        list0.add("");
        result.add(list0);
        LinkedList<String> list1 = new LinkedList<String>();
        list1.add("()");
        result.add(list1);
        for (int i = 2; i <= n; i++) {
            LinkedList<String> temp = new LinkedList<String>();
            for (int j = 0; j < i; j++) {
                List<String> str1 = result.get(j);
                List<String> str2 = result.get(i - 1 - j);
                for (String s1 : str1) {
                    for (String s2 : str2) {
                        String el = "(" + s1 + ")" + s2;
                        System.out.println("s1 :"+ s1 + "\n s2: " + s2 + "\n el: " + el);
                        System.out.println("");
                        temp.add(el);
                    }
                }
            }
            result.add(temp);
        }
        return result.get(n);
    }

}

