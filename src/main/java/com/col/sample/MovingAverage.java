package com.col.sample;

import java.util.LinkedList;
import java.util.List;

public class MovingAverage {

    int capacity;
    LinkedList<Integer> queue;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        capacity = size;
        queue = new LinkedList<Integer>();
    }

    public double next(int val) {

        int size = queue.size();
        if(0 == size){
            queue.addFirst(val);
            return (float)val;
        }

        if(queue.size() == capacity){
            queue.removeFirst();
            queue.addLast(val);
        } else {
            queue.addLast(val);
            size++;
        }

        int sum = 0;
        for(Integer i : queue){
            sum += i;
        }
        return (sum * 1.0)/size;

    }

    public static void main(String[] args) {
        MovingAverage movingAverage = new MovingAverage(3);
        System.out.println(movingAverage.next(1));

        System.out.println(movingAverage.next(10));
        System.out.println(movingAverage.next(3));
        System.out.println(movingAverage.next(5));

    }

}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */