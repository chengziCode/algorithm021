package practice.array;


// 26 删除排序数组中的重复项
public class RemoveDuplicates {


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
