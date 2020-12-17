import java.util.ArrayList;
import java.util.List;

// 46 全排列 https://leetcode-cn.com/problems/permutations/
public class Permute {

    public static void main(String[] args) {
        new Permute().permute(new int[]{1, 2, 3}).forEach(System.out::println);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        int[] visited = new int[nums.length]; //记录当前list中访问nums元素的情况，1表示curList中已经存在nums[0]元素
        dfs(nums, new ArrayList<Integer>(), resList, visited);
        return resList;
    }

    private void dfs(int[] nums, ArrayList<Integer> curList, List<List<Integer>> resList, int[] visited) {
        //recursion terminator
        if (curList.size() == nums.length) {
            resList.add(new ArrayList<>(curList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            //process
            if (visited[i] != 0) continue;
            curList.add(nums[i]);
            visited[i] = 1;

            //drill down
            dfs(nums, curList, resList, visited);
            
            // revert state
            curList.remove(curList.size() - 1);
            visited[i] = 0;
        }
    }
}
