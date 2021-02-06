package practice.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//56 合并区间 https://leetcode-cn.com/problems/merge-intervals/
public class MergeRange_2 {
    public static void main(String[] args) {
    }

    /**
     * intervals是 n行2列 ex: [(1, 2)], [(2, 4)]
     * 把intervals按照 元组的第一个元素升序排序
     * 把第一个元组放入list, 遍历所有元组，与list的最后一个元组比较边界
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length  < 2) return intervals;

        ArrayList<int[]> resList = new ArrayList<>();
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        resList.add(intervals[0]);

        for(int i = 1; i < intervals.length; i++) {
            int[] curRange = intervals[i];
            int[] lastRange = resList.get(resList.size() - 1);

            if(lastRange[1] < curRange[0]) resList.add(curRange);
            else lastRange[1] = Math.max(lastRange[1], curRange[1]);
        }
        return resList.toArray(new int[resList.size()][1]);
    }
}
