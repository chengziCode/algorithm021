## 学习总结：

- 要时刻记录题干意思，有时候想着想着就忘了要干嘛。
- 五毒神掌要坚持，做一遍很快就忘，就前功尽弃了。
- 发现排序，哈希去重，双指针这些都是数组的常用解题套路。
- 课程中给的练习题要尽量抽时间多刷些题，套路攒多了，遇到题就思路了。 还有一些延伸的链接很棒，比如list的源码，LRU Cache解析，Redis的跳表使用.

### linkedList - 链表

    linkedList是通过双向链表实现的，而双向链表就是通过Node类来体现的，类中通过item变量保存了当前节点的值，通过next变量指向下一个节点，通过prev变量指向上一个节点。

### Stack - 栈

```java
public class Stack<T> extends Vector<T> {
    
    public synchronized T pop() {
        if (elementCount == 0)
            throw new EmptyStackException();

        modCount++;
        T obj = elementData[--elementCount];

        // Set topmost element to null to assist the gc in cleanup.
        elementData[elementCount] = null;
        return obj;
    }

    public E push(E item) {
        addElement(item);
        return item;
    }
    
    // Vector<T>父类的方法
    public synchronized void addElement(E obj) {
        modCount++;
        ensureCapacityHelper(elementCount + 1);
        elementData[elementCount++] = obj;
    }
    
}
```
    
    从以上源码可以看出，栈本质上是在维护一个数组，pop方法即把当前栈顶对应数组中的值设置为null, push方法则是在数组末尾添加新元素。

### queue - 队列 

```java

public interface Queue<E> extends Collection<E> {
}
```

    队列是一种特殊的线性表，它只允许在表的前端进行删除操作，而在表的后端进行插入操作。从源码中可以看出queue是一个接口，它有多种实现，比如LinkedList。
    那么就可以认为队列本质上就是一种先进先出，只允许操作 "前端元素"的链表。
    