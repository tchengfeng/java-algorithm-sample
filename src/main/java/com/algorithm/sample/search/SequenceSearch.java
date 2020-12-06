package com.algorithm.sample.search;

public class SequenceSearch {

    public static boolean SequenceSearch(int a[],int k,int value){

        for( int i = 0 ; i < k; i++){
            if( value == a[i]) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] a = {8,2,4,5,3,10,21,6,9};
        System.out.println(SequenceSearch(a,a.length,20));
    }

}
