
## 动态规划
Simplifying a complicated problem by breaking it down into simpler sub-problems
通过把一个问题简化成多个简单的子问题，即分治+最优子结构，所以本质上是递归的思想，只是在实现上大多通过DP方程构造1，2维数组来解题。
最优子结构意味着中途可以淘汰最优解。


感受：
    刷了7道题，动态规划这类题，最难的就是找最优子结构，特别是通过dp方程构造数组的时候还要考虑边界的问题，特别容易出错，且不容易发现。
找最优子结构来构造数组需要有比较多的经验，很多时候无从下手只能看题解。
    总结出的套路基本都是针对题目给的对象，比如字符串，数组，对每个字符 或是数组中的每个数找到其和其他数的运算关系。