package practice.array;


import java.util.Arrays;

//88 合并2个有序数组  https://leetcode-cn.com/problems/merge-sorted-array/
public class MergeTwoArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 1. nums2 复制到 nums1 再排序

        /*System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
*/
        // 2. 从前往后，双指针， 需要开辟额外空间

        // 3. 从后往前， 双指针， 原地操作
        int p1 = m - 1;
        int p2 = n - 1;
        int cur = m + n -1;
        while (p1 >= 0 && p2 >= 0) nums1[cur--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
        while (p2 >=0 ) nums1[cur--] = nums2[p2--];






    }
}
