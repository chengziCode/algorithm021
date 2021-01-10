package practice.recusion;

import java.util.*;

//22 括号生成 https://leetcode-cn.com/problems/generate-parentheses/

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */


public class GenerateParenthesis {

    public static void main(String[] args) {
        System.out.println(new GenerateParenthesis().generateParenthesis(3));
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

}

