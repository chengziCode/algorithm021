package practice.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 18 四数之和 https://leetcode-cn.com/problems/4sum/

public class FourSum_2 {
    /**
     * 三数之和 的套路 - 双指针法
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums.length < 4) return new ArrayList<>();
        List<List<Integer>> resList = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 3; i++){ // nums.length - 3(-1 必减， 第二层循环 -1, tail指针 -1)
            if(i > 0 && nums[i] == nums[i - 1]) continue; //去除重复
            for(int j = i + 1; j < nums.length -2; j++){
                if(j > i + 1 && nums[j] == nums[j - 1]) continue; //去除重复

                int head = j + 1;
                int tail = nums.length - 1;

                while(head < tail) {
                    int fourSum = nums[i] + nums[j] + nums[head] + nums[tail];
                    if (fourSum == target) {
                        resList.add(Arrays.asList(nums[i], nums[j], nums[head++], nums[tail--]));

                        while(head < tail && nums[head] == nums[head - 1]) head++; //去除重复
                        while(head < tail && nums[tail] == nums[tail + 1]) tail--; //去除重复

                    }else if(fourSum > target) tail--; //大于目标数 tail中间靠
                    else head++;    //小于目标数 head中间靠
                }
            }
        }
        return resList;
    }
}
