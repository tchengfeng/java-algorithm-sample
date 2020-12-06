package com.data.structure.sample.hash;

import java.util.LinkedList;

public class MyHashSet {

    private int bucketSize;
    private BucketLink[] bucketLinks;

    /** Initialize your data structure here. */
    public MyHashSet() {
        this.bucketSize = 769;
        this.bucketLinks = new BucketLink[bucketSize];
        for(int i = 0; i < bucketSize; i++){
            this.bucketLinks[i] = new BucketLink();
        }
    }

    public int hashFunc(int key){
        int bucketIndex = key % bucketSize;
        return bucketIndex;
    }


    public void add(int key) {
        int bIndex = hashFunc(key);
        bucketLinks[bIndex].insert(key);
    }

    public void remove(int key) {
        int bIndex = hashFunc(key);
        bucketLinks[bIndex].del(key);
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bIndex = hashFunc(key);
        return bucketLinks[bIndex].exist(key);
    }

    class BucketLink{

        private LinkedList<Integer> bucketList;
        public BucketLink(){
            bucketList = new LinkedList<>();
        }

        public void insert(Integer key){
            boolean isExist = bucketList.contains(key);
            if(!isExist){
                bucketList.addFirst(key);
            }
        }

        public void del(Integer key){
            bucketList.remove(key);
        }

        public boolean exist(Integer key){
            return this.bucketList.contains(key);
        }

    }

    public static void main(String[] args) {

        MyHashSet myHashSet = new MyHashSet();

        myHashSet.add(1);
        myHashSet.add(2);
        boolean res1 = myHashSet.contains(1);
        boolean res2 = myHashSet.contains(3);
        myHashSet.add(2);
        boolean res3 = myHashSet.contains(2);
        myHashSet.remove(2);
        boolean res4 = myHashSet.contains(2);

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
        System.out.println(res4);

    }

}