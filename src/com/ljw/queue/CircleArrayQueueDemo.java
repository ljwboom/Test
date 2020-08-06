package com.ljw.queue;

/**
 * @program: data-structure
 * @description: 环形队列
 * @author: linjw
 * @create: 2020-08-03 11:57
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {

    }
}


class CircleArray {
    private int maxSize;//表示数组最大容量

    private int front;
    //front指向队列的第一个元素
    //front的初始值为0

    private int rear;//队列尾
    //rear指向队列的最后一个元素的后一个位置，空出一个
    //rear的初始值为0

    private int[] arr;


    public CircleArray(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }


    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int n) {
        if (isFull()){
            throw new RuntimeException("队列已满");
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空");
        }
        return arr[front];
    }

    public void showQueue() {
        //队列为空
        if (isEmpty()) {
            throw new RuntimeException("队列里面没有数据");
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }


    //队列当中的有效个数
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    public int headShow() {
        return arr[front];
    }
}
