package com.col.sample;

import java.util.*;

public class ArrayListS {


    public void arrayFunc(List arrayList){
        ListIterator listIterator = arrayList.listIterator();
        while (listIterator.hasNext()){
            Integer re = (Integer) listIterator.next();
            System.out.println(re);
        }
    }

    public static void main(String[] args) {
        List<Integer> arrList = new ArrayList<Integer>(Arrays.asList(1,2,3,5,6,7));
        new ArrayListS().arrayFunc(arrList);
    }

}
