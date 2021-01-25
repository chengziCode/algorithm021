package practice.bit;

//231 2的幂 https://leetcode-cn.com/problems/power-of-two/
public class IsPowerOfTwo {


    public static void main(String[] args) {
        int a = 1 & 1;
        int b = 1 & 4;
        System.out.println(a);
    }

    // 二进制位中 只有一位是1 即是2的幂
    public boolean isPowerOfTwo(int n) {
        while (n > 0 && (n & 1) == 0) n >>= 1;
        return n == 1;
    }
}
