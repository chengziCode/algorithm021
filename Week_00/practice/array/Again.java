package practice.array;

import utils.Utils;

public class Again {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        new Again().rotate(arr, 3);
        Utils.displayArray(arr);
    }

    public void rotate(int[] nums, int k) {
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
        }
    }
}
