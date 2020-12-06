package com.data.structure.sample.queue;

import java.util.*;

/**
 * LinkedList as Queue
 */
public class LinkedListQueue<T> {

    private LinkedList<T> queue = new LinkedList<>();

    public void offer(T v){
        queue.addLast(v);
    }

    public T peek(){
        return queue.getFirst();
    }

    public T poll(){
        return queue.removeFirst();
    }

    public int size() {
        return queue.size();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

}
