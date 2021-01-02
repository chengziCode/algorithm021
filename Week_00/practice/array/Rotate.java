package practice.array;

//189 旋转数组  https://leetcode-cn.com/problems/rotate-array/
public class Rotate {

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7};
        new Rotate().rotate(a, 3);


    }

    public void rotate(int[] nums, int k) {


        // 3 反转数组  3次

        k = k % nums.length; // 优化k，除去重复的循环

        // 1 暴力解法  从第一个数开始逐渐循环替换后面的数 O(kn)
        /*
            for (int i = 0; i < k; i++) {
                int pre = nums[nums.length - 1];
                for (int j = 0; j < nums.length; j++) {
                    int tmp = nums[j];
                    nums[j] = pre;
                    pre = tmp;
                }
                Utils.displayArray(nums);
                System.out.println("");
            }
        */

        // 2 从第K个数开始循环替换后面的数。


        // 4 非原地算法: 引入额外的数据
        /*
            int[] res = new int[nums.length];
            System.arraycopy(nums, 0, res, k, nums.length - k);
            System.arraycopy(nums, nums.length - k, res, 0, k);
            System.arraycopy(res, 0, nums, 0, nums.length);
        */


    }
}
