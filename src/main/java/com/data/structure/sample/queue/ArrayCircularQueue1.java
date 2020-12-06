package com.data.structure.sample.queue;


/**
 * from leetcode
 */
class ArrayCircularQueue1 {

    private int[] data;
    private int head;
    private int tail;
    private int size;
    private int tag;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public ArrayCircularQueue1(int k) {
        data = new int[k];
        head = 0;
        tail = 0;
        size = k;
        tag = 0;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull() == true) {
            return false;
        }
        if (isEmpty() == true) {
            head = 0;
        }
        tail = (tail + 1) % size;
        data[tail] = value;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty() == true) {
            return false;
        }
        if (head == tail) {
            head = -1;
            tail = -1;
            return true;
        }
        head = (head + 1) % size;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty() == true) {
            return -1;
        }
        return data[head];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (isEmpty() == true) {
            return -1;
        }
        return data[tail];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return head == -1;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return ((tail + 1) % size) == head;
    }


    public static void main(String[] args) {

        ArrayCircularQueue1 circularQueueB = new ArrayCircularQueue1(10);

        circularQueueB.enQueue(1);
        circularQueueB.enQueue(2);
        circularQueueB.enQueue(3);
        circularQueueB.enQueue(4);
        circularQueueB.enQueue(5);
        circularQueueB.enQueue(6);
        circularQueueB.enQueue(7);
        circularQueueB.enQueue(8);
        circularQueueB.enQueue(9);
        circularQueueB.enQueue(10);

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