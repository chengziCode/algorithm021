package practice.array;

import utils.Utils;

// 66 加1  https://leetcode-cn.com/problems/plus-one/
public class PlusOne_2 {
    public static void main(String[] args) {
        Utils.displayArray(new PlusOne_2().plusOne(new int[]{1, 2, 3}));

    }





    public int[] plusOne(int[] digits) {
        // 换算出整数 + 1， 再写回一个新的数组
        // 个位 + 1，判断是否进位。
      /*  int index = digits.length - 1;
        digits[index] = digits[index] + 1;
        while (digits[index] > 9) {
            digits[index--] = 0;
            if (index != -1) digits[index] += 1;
            else {
                int[] res = new int[digits.length + 1];
                res[0] = 1;
                return res;
            }
        }
        return digits;*/

        for (int i  = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            if (digits[i] > 9) digits[i] = 0;
            else return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;


        //解法2
        /**
         * for (int i = digits.length - 1; i >= 0; i--) {
         *             digits[i]++;
         *             digits[i] = digits[i] % 10;
         *             if (digits[i] != 0) return digits;
         *         }
         *         digits = new int[digits.length + 1];
         *         digits[0] = 1;
         *         return digits;
         */

    }
}
