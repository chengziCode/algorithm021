package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// 15 三数之和
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {

        if (nums.length < 3) {
            return new ArrayList<List<Integer>>();
        }

        Arrays.sort(nums);
        List<List<Integer>> resList = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int head = i + 1;
            int tail = nums.length - 1;

            while (head < tail) {
                int threeSum = nums[i] + nums[head] + nums[tail];
                if (threeSum == 0) {
                    resList.add(Arrays.asList(nums[i], nums[head++], nums[tail--]));
                    while (head < tail && nums[head] == nums[head - 1]) {head++;}
                    while (head < tail && nums[tail] == nums[tail + 1]) {tail--;}
                } else if (threeSum > 0)
                    tail--;
                else
                    head++;
            }
        }
        return resList;
    }

}
