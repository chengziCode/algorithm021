package practice.array;

//641 设计循环双端队列      https://leetcode-cn.com/problems/design-circular-deque/
public class MyCircularDeque_2 {

    int capacity = 0;
    int front = 0;
    int rear = 0;
    int arr[];


    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque_2(int k) {
        capacity = k + 1; //多一个位置用于rear指针放着。
        arr = new int[capacity];
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) return false;
        front = (front - 1 + capacity) % capacity;  //先移动再赋值。
        arr[front] = value;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) { //先赋值 再移动。 每次都指向下一个被放入的位置。
        if (isFull()) return false;
        arr[rear] = value;
        rear = (rear + 1) % capacity;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) return false;
        front = (front + 1) % capacity;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) return false;
        rear = (rear - 1 + capacity) % capacity;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty()) return -1;
        return arr[front];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (isEmpty()) return -1;
        return arr[(rear - 1 + capacity) % capacity];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return front == rear;
    }//为空表示在同一个位置。

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return  front == (rear + 1) % capacity;
    }
}
