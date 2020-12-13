import java.util.PriorityQueue;

public class NthUglyNumber {

    public static void main(String[] args) {
        System.out.println(new NthUglyNumber().nthUglyNumber(1407));
    }

    // 264 丑数 II
    public int nthUglyNumber(int n) {
        /**
         * 1. 根据入参 构造最小堆
         * 2. 弹出最小堆的堆顶元素 n 次， 注意去重。
         */
        PriorityQueue<Long> pq = new PriorityQueue<>();
        long res = 1;
        for (int i = 1; i < n; i++) {
            pq.add(res * 2);
            pq.add(res * 3);
            pq.add(res * 5);
            res = pq.poll();
            while (res == pq.peek()) pq.poll();
        }
        return (int) res;
    }


}
