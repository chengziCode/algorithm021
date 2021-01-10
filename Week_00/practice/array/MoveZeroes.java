package practice.array;

// 283. 移动零     https://leetcode-cn.com/problems/move-zeroes/

public class MoveZeroes {


    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 0, 2};

//        moveZeroes_loop2(nums);
        moveZeroes_twoPoints(nums);
        printNums(nums);

    }

    /**
     * two points O(n)
     *
     * @param nums
     */
    public static void moveZeroes_twoPoints(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                swapNums(nums, i++, j);
            }
        }
    }

    private static void swapNums(int[] nums, int i, int j) {
        int swap = nums[i];
        nums[i] = nums[j];
        nums[j] = swap;
    }


    /**
     * O(n^2)
     *
     * @param nums
     */
    public static void moveZeroes_loop2(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1; j++) {
                if (nums[j] == 0) {
                    nums[j] = nums[j + 1];
                    nums[j + 1] = 0;
                }
            }
        }

    }


    private static void printNums(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
