package Array;

import java.util.HashMap;


// 1 两数之和
public class TwoSum {

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

    //夹逼
    public int[] twoSum_2(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int otherNum = target - nums[i];
            if (hashMap.containsKey(otherNum)) {
                return new int[]{hashMap.get(otherNum), i};
            }else {
                hashMap.put(nums[i], i);
            }
        }
        return null;
    }
}
