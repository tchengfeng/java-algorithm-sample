package com.col.sample;

import java.util.*;

public class LinkedListS {

    public void arrayFunc(LinkedList<Integer> list){
        ListIterator listIterator = list.listIterator();

        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            Integer re = (Integer) iterator.next();
            System.out.println(re);
        }

    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(1,2,3,5,6,7));
        new LinkedListS().arrayFunc(linkedList);
    }

}