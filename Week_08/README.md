### 位运算

#### 记住一些运算技巧

- 获取 x 的第 n 位值（0 或者 1）：  (x >> n) & 1
- 获取 x 的第 n 位的幂值：         x & (1 << n)
- 仅将第 n 位置为 1：             x | (1 << n)
- 仅将第 n 位置为 0：             x & (~ (1 << n))
-  清零最低位的 1：              x = x & (x - 1)
- 得到最低位的 1：               x & -x



### 布隆过滤器， LRU Cache

#### 布隆过滤器

- 布隆过滤器使用bitmap + 多组Hash function构建
- 应用在不需存放整个Key与Value，而只要快速判断key是否在talbe中的场景
- 因为hash碰撞的原因，可能会造成误报情况，就是判断在Table内但却不在，所以需要搭配后端存放完整Key的容器再次判断

#### LRU Cache

- 一种缓存替换策略，当缓存空间不足以存放新近元素时，淘汰最久没有使用到的元素



### 排序算法

**详情参见：** ` **https://www.cnblogs.com/onepixel/p/7674659.html**`

![image.png](https://cdn.nlark.com/yuque/0/2021/png/324862/1611555205953-83434aa5-bfbf-4647-a56b-de9862650e61.png)