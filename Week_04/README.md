## 学习笔记

### 深度、广度优先搜索
    代码模板有递归式和非递归式，非递归式需要把下一次遍历的节点放在一个专用的存储对象中（栈，队列）；
    递归式就和递归代码模板相同。
   
### 贪心
    贪心算法是一种在每一步选择中都采取在当前状态下最好或最优（即最有 利）的选择，从而希望导致结果是全局最好或最优的算法。
    贪心算法与动态规划的不同在于它对每个子问题的解决方案都做出选择，不能回退。动态规划则会保存以前的运算结果，并根据以前的结果对当前进行选择，有回退功能。
#### 适用场景
    问题能够分解成子问题来解决，子问题的最优解能递推到最终问题的最优解。这种子问题最优解称为最优子结构。

### 二分查找
####前提
• 目标函数单调性（单调递增或者递减）
• 存在上下界（bounded）
• 能够通过索引访问（index accessible)
