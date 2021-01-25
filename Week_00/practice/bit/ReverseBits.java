package practice.bit;

//190 颠倒二进制位 https://leetcode-cn.com/problems/reverse-bits/
public class ReverseBits {
    public static void main(String[] args) {
        System.out.println(new ReverseBits().reverseBits(1));
        System.out.println(Integer.MAX_VALUE);
    }

    /**
     * 位置替换 ， 比如 高32位换低1位， 高31位换低2位
     */
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32 ; i++) {
            res =  res | ((n >> i) & 1) << (31 - i);
        }
        return res;
    }


    /**
     * res 向左移空出一个位 + 加上n的最右边的位，  n右移，最右的一位下一次res相加。
     */
    public int reverseBits_1(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = (res <<= 1) + (n & 1);
            n >>= 1;
        }
        return res;
    }

}
