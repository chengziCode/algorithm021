package practice.array;


// 26 删除排序数组中的重复项   https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
public class RemoveDuplicates_2 {


    public int removeDuplicates(int[] nums) {
        // 双指针 cur , pos.
        int cur = 0, pos = 1;
        while(pos < nums.length) {
            if (nums[cur] != nums[pos]) nums[++cur] = nums[pos++];
            else pos++;
        }
        return cur + 1;
    }
}
