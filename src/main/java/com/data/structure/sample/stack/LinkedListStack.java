package com.data.structure.sample.stack;

import java.util.LinkedList;

/**
 * LinkedList as Stack
 */
public class LinkedListStack<T> {

    private LinkedList<T> stack = new LinkedList<>();

    public void push(T v) {
        stack.addFirst(v);
    }

    public T peek(){
        return stack.getFirst();
    }

    public T pop(){
        return stack.removeFirst();
    }

    public int size() {
        return stack.size();
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public String toString(){
        return stack.toString();
    }

}
