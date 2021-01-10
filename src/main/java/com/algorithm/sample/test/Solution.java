package com.algorithm.sample.test;

public class Solution {

    public int findNthDigit(int n) {

        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i <= n; i++){
            stringBuilder.append(String.valueOf(i));
        }

        char charV = stringBuilder.toString().charAt(n);
        return Integer.parseInt(String.valueOf(charV));
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,3,3,3,4,5,5,5};
        System.out.println(new Solution().findNthDigit(3));
    }

}