package practice.heap;


import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 剑指offer 40  最小的k个数  https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 */
public class GetLeastNumber {

    /**
     * 解法1 ： 数组排序， 取前k个
     * 解法2 :  构造最小堆， 弹出k次
     */

    public int[] getLeastNumbers(int[] arr, int k) {
        int[] res = new int[k];

        //解法1
        /*Arrays.sort(arr);
        for (int i = 0; i < k; i++) res[i] = arr[i];*/

        //解法2
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Integer num : arr) pq.add(num);
        for (int i = 0; i < k; i++) res[i] = pq.poll();

        return res;
    }
}
