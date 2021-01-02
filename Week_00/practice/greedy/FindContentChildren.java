package practice.greedy;

import java.util.Arrays;

/**
 * 455 分发饼干  https://leetcode-cn.com/problems/assign-cookies/description/
 */

public class FindContentChildren {
    public static void main(String[] args) {
        System.out.println(new FindContentChildren().findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1}));
    }


    /**
     * 贪心算法： 只要保证每次分配的饼干能满足孩子的需求，并且是所有饼干中尺寸最小的即可
     */
    public int findContentChildren(int[] g, int[] s) {
        int gindex = 0, sindex = 0, count = 0;
        Arrays.sort(g);
        Arrays.sort(s);

        while (gindex < g.length && sindex < s.length) {
            if (s[sindex++] >= g[gindex]) {
                count++;
                gindex++;
            }
        }
        return count;
    }
}
