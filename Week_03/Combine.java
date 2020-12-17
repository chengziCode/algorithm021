// 77 组合  https://leetcode-cn.com/problems/combinations/

import java.util.ArrayList;
import java.util.List;

public class Combine {

    public static void main(String[] args) {
        List<List<Integer>> combine = new Combine().combine(3, 2);
        combine.forEach(System.out::println);
    }

    public List<List<Integer>> combine(int n, int k) {
        /**
         * 像列举出所有组合的题，是经典的回溯算法题，可以根据dfs的思想来解题。
         */

        List<List<Integer>> resList = new ArrayList<>();
        dfs(1, n, k, new ArrayList<Integer>(), resList);
        return resList;
    }

    private void dfs(int begin, int n, int k, ArrayList<Integer> curList, List<List<Integer>> resList) {
        //recursion terminator
        if (curList.size() == k) {
            resList.add(new ArrayList<>(curList));
            return;
        }
        int loopTimes = n - (k - curList.size()) + 1; //剪枝优化: 本层最多可以从第几个数开始遍历（主要用于删去不必要的遍历操作，比如数不够就没必要再遍历了。）
        for (int i = begin; i <= loopTimes; i++) {
            // process
            curList.add(i);
            // drill down
            dfs(i + 1, n, k, curList, resList);
            // revert state
            curList.remove(curList.size() - 1);
        }
    }

}
