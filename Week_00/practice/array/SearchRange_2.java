package practice.array;
// 34 在排序数组中查找元素的第一个和最后一个位置  https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
public class SearchRange_2 {


    public static void main(String[] args) {
        new SearchRange_2().searchRange(new int[]{5,7,7,8,8,10},8);
    }

    // 34
    public int[] searchRange(int[] nums, int target) {
        int tar_cnt = 0; // 记录目标数的个数
        int end_index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                tar_cnt++;
                end_index = i;
            }
        }

        if (tar_cnt > 0) {
            return new int[]{end_index - tar_cnt + 1, end_index};
        }

        return new int[]{-1, -1};
    }





}
