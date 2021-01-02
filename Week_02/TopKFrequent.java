import java.util.*;

public class TopKFrequent {
    // 347. 前 K 个高频元素

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,4,4,4,3,1,2,5,6,7};
        new TopKFrequent().topKFrequent(nums,3);
    }

    public int[] topKFrequent(int[] nums, int k) {

        /**
         * 1. 放入map中计数
         * 2. 构造最大堆
         * 3. 弹出K个堆顶元素
         */
        int[] res = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num,0) + 1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            pq.add(entry);
        }

        int i = 0;
        while (i < k) res[i++] = pq.poll().getKey();
        return res;
    }
}
