package practice.recusion;

// 50 x的n次幂  https://leetcode-cn.com/problems/powx-n/
public class MyPow {

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }

    public double myPow(double x, int n) {
//        return recursion(1, x, n);  // 暴力递归

        return n > 0 ? _divide(x, n) : 1/_divide(x, -n);  //分治算法
    }

    /**
     * 分治
     */
    private double _divide(double x, int n) {
        //terminator
        if (n == 0) return 1.0;

        double res = _divide(x, n / 2); // x的n/2次幂的结果

        if (n % 2 == 0) return res * res; // n为偶数 即 res * res
        else return res * res * x; // n为奇数，需要再多乘一个
    }


    /**
     * 递归 n变大会超时
     */
    private double recursion(double res, double x, int n) {
        if (n-- == 0) return res;
        return recursion(res * x, x, n);
    }


}
