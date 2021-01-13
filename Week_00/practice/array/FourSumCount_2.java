package practice.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 454 四数相加 https://leetcode-cn.com/problems/4sum-ii/
 *
 */
public class FourSumCount_2 {
    public static void main(String[] args) {
    }

    /**
     *  由于是满足的组合数， 所以通过hashMap对2个数组的和进行计数， 再用map中的数值与剩下的2个数组和的绝对值进行比对。
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer,Integer> map = new HashMap<>();
        int res = 0;

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                map.put(A[i] + B[j], map.getOrDefault(A[i] + B[j], 0) + 1);
            }
        }

        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                if (map.containsKey(-(C[i] + D[j]))) res += map.get(-(C[i] + D[j]));
            }
        }

        return res;
    }





}
