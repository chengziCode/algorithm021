package practice.array;

// 11 盛最多水的容器 https://leetcode-cn.com/problems/container-with-most-water/
public class MaxArea_2 {


    /**
     * 这套题用双指针夹逼法来做， 前后指针向中间靠近，指针移动的条件是 left < right &&
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        while (left < right) {
            int leftHeight = height[left];
            int rightHeight = height[right];
            res = leftHeight > rightHeight ?
                    Math.max(res, (right-- - left) * rightHeight) :
                    Math.max(res, (right - left++) * leftHeight);
        }
        return res;
    }
}
