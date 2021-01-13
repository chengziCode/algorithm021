package practice.array;

import java.util.HashMap;
import java.util.Map;


// 1 两数之和  https://leetcode-cn.com/problems/two-sum/
public class TwoSum_2 {

    //哈希 取相反数
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int otherNum = target - nums[i];
            if (hashMap.containsKey(otherNum) && hashMap.get(otherNum) != i) {
                return new int[]{i, hashMap.get(otherNum)};
            }
        }
        return null;
    }


    public int[] twoSum_new(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i < nums.length; i++)
            if (map.containsKey(target - nums[i]))
                return new int[]{i, map.get(target - nums[i])};
            else
                map.put(nums[i],i);
        return nums;
    }

}
