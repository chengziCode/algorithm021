package practice.array;

//189 旋转数组  https://leetcode-cn.com/problems/rotate-array/
public class Rotate_3_need {

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7};
        new Rotate_3_need().rotate(a, 3);


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

        // 2 循环替换，让座位
        int count = 0; //换座位次数，每个人换一次就算是完成了。即 count = nums.length
        for(int i = 0; count < nums.length; i++) {
            int preValue = nums[i];
            int nextIndex = i;
            do {
                nextIndex = (nextIndex + k) % nums.length;
                int tmp = nums[nextIndex];
                nums[nextIndex] = preValue;
                preValue = tmp;
                count++;
            }while (nextIndex != i);
        }


        /*

        //用的 while， 而不是do while。  当nextIndex = i时，需要在跳出循环时给nums[i]赋值，count++
        k = k % nums.length;
        int count = 0;

        for (int i = 0; count < nums.length; i++) {
            int preValue = nums[i];
            int nextIndex = (i + k) % nums.length;

            while (i != nextIndex) {
                int tmp = nums[nextIndex];
                nums[nextIndex] = preValue;
                preValue = tmp;
                nextIndex = (nextIndex + k) % nums.length;
                count++;
            }
            nums[i] = preValue;
            count++;
        }*/


        // 4 非原地算法: 引入额外的数据
        /*
            int[] res = new int[nums.length];
            System.arraycopy(nums, 0, res, k, nums.length - k);
            System.arraycopy(nums, nums.length - k, res, 0, k);
            System.arraycopy(res, 0, nums, 0, nums.length);
        */
    }
}
