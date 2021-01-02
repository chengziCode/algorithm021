## 学习笔记
### 哈希表

- 哈希表本质上是一个一维数组，存放数据的逻辑是把待插入的值，通过哈希函数映射到目标数组的下标，如果出现多个值得下标相同，
那么这些相同的数值会通过链表的方式连接以起来。
- 哈希表对单个key的增删改查的时间复杂度都是O(1).
- 源码: `http://developer.classpath.org/doc/java/util/HashMap-source.html` 

### 树
- 树，本质上是一个链条，与一般所说的单链表不同的是，它会存在多个分支，只有2个分支的树，成为二叉树。
- 如果二叉树的非叶子节点都存在子节点，那么就是完全二叉树。
- 二叉搜索树具备以下性质：
> 左子树上所有结点的值均小于它的根结点的值,右子树上所有结点的值均大于它的根结点的值；
> 它的增删改查的时间复杂度都是O(logN)
