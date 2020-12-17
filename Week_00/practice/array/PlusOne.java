package practice.array;

// 66 加1
public class PlusOne {
    public static void main(String[] args) {

    }

    public int[] plusOne(int[] digits) {
        // 换算出整数 + 1， 再写回一个新的数组
        // 个位 + 1，判断是否进位。
        int index = digits.length - 1;
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
