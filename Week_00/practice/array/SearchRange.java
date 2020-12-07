package practice.array;

public class SearchRange {
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
