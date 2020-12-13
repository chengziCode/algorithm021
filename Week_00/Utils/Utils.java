package Utils;

public class Utils {
    public static void displayArray(int[] nums) {

        int i = 0;
        while (i < nums.length) {
            System.out.print(nums[i++] + (i < nums.length ? ", " : ""));
        }
    }
}
