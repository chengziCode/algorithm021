package practice.Array;
//70 爬楼梯

public class ClimbStairs {


    public int climbStairs(int n) {
        int fir_cnt = 1;
        int sec_cnt = 2;

        if (n == 1) {
            return fir_cnt;
        }
        if (n == 2) {
            return sec_cnt;
        }

        for (int i = 3; i < n + 1; i++) {
            sec_cnt += fir_cnt;
            fir_cnt = sec_cnt - fir_cnt;
        }
        return sec_cnt;
    }
}
