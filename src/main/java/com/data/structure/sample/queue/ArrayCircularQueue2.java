package com.data.structure.sample.queue;

/**
 * 当队列为空时，front == rear，当队列满时，保留一个元素的空间，也就是说队列满时，数组还有一个空闲单元。
 *
 *
 *  基于数组实现循环队列（假溢出）
 *
 *  1.队空条件：rear==front
 *  2.队满条件：(rear+1) %QueueSIze==front，其中QueueSize为循环队列的最大长度
 *  3.计算队列长度：（rear-front+QueueSize）%QueueSize
 *  4.入队：（rear+1）%QueueSize
 *  5.出队：（front+1）%QueueSize
 *
 */
public class ArrayCircularQueue2 {

    int[] array;
    int len;
    int front = 0;
    int rear = 0;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public ArrayCircularQueue2(int k) {
        array = new int[k];
        len = k;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {

        if(isFull()){
            return false;
        }
        array[rear] = value;
        rear = (rear + 1) % len;

        return true;

    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {

        if(isEmpty()){
            return false;
        }

//        int deQue = array[front];
        front = (front + 1) % len;

        return true;

    }

    /** Get the front item from the queue. */
    public int Front() {
        if(isEmpty()){
            return -1;
        }
        return array[front];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        return array[rear];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {

        if(this.front == this.rear){
            return true;
        }
        return false;

    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {

        if((rear + 1) % len == front){
            return true;
        }
        return false;

    }

    public static void main(String[] args) {
        ArrayCircularQueue2 circularQueueA = new ArrayCircularQueue2(10);

        circularQueueA.enQueue(1);
        circularQueueA.enQueue(2);
        circularQueueA.enQueue(3);
        circularQueueA.enQueue(4);
        circularQueueA.enQueue(5);
        circularQueueA.enQueue(6);
        circularQueueA.enQueue(7);
        circularQueueA.enQueue(8);
        circularQueueA.enQueue(9);
        circularQueueA.enQueue(10);
    }

}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */