package com.data.structure.sample.hash;

import java.util.HashMap;

public class MyHashMap {

    private HashMap<Integer,Integer> hashMap;

    /** Initialize your data structure here. */
    public MyHashMap() {
        this.hashMap = new HashMap<>();
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        this.hashMap.put(key,value);
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {

        Integer integer = this.hashMap.get(key);

        if(integer == null){
            return -1;
        } else {
            return integer;
        }

    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        this.hashMap.remove(key);
    }


//    ["MyHashMap","put","put","get","get","put","get", "remove", "get"]
//            [[],[1,1],[2,2],[1],[3],[2,1],[2],[2],[2]]

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1,1);
        myHashMap.put(2,2);
        int res1 = myHashMap.get(1);
        int res2 = myHashMap.get(3);
        myHashMap.put(2,1);
        int res3 = myHashMap.get(2);
        myHashMap.remove(2);
        int res4 = myHashMap.get(2);

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
        System.out.println(res4);
    }

}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
