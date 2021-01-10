package practice.array;
//70 爬楼梯 https://leetcode-cn.com/problems/climbing-stairs/

public class ClimbStairs_4 {

    public int climbStairs(int n) {
        //双指针
        if (n <= 2) return n;
        int fir = 0, sec = 1;
        for (int i = 0; i < n; i++) {
            sec = fir + sec;
            fir = sec - fir;
        }
        return sec;
    }


    /**
     * 递归加记忆算法
     *
     * 转化为斐波那契数列的递归式的时间复杂度为2^n， 引入记忆缓存为使得时间复杂度为O(n)
     */
    public int climbStairsByMemory(int n) {
        int[] mem = new int[n];
        int res = recursion(mem, n);
        return res;
    }

    private int recursion(int[] mem, int n) {
        if (n <= 2) return n;
        if (mem[n] == 0) mem[n] = recursion(mem, n - 2) + recursion(mem, n - 1); //记忆数组中没有值，就计算赋值
        return mem[n]; //直接取记忆数组中的值
    }
}
