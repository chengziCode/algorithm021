/**
 * 33 搜索旋转排序数组 https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 */
public class Search {
    public static void main(String[] args) {
        System.out.println(new Search().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }




    /**
     *  中心思想： 判断target在 mid左边还是右边，就可以直接使用二分查找进行搜索。
     *  本体在if中列举了 所有可能在mid左边的情况
     */

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;

            else if ((nums[left] > nums[mid] && (target >= nums[left] || target < nums[mid])) || (target >= nums[left] && target < nums[mid])) {
                right = mid - 1;
            } else left = mid + 1;
        }
        return -1;
    }
}
