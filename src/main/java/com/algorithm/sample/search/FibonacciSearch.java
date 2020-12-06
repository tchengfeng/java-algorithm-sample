package com.algorithm.sample.search;

import java.util.Arrays;

/**
 * 斐波那契思路（黄金比例）：
 * 首先斐波那契为 1 1 2 3 5 8 13 21 34 55. 第3个数开始，等于前面2个数的和。而且n/n+1无限接近与0.618
 * f[i] = f[i-1] + f[i-2]
 */
public class FibonacciSearch {

    public static int maxSize = 100;

    // 迭代-Fibonacci队列
    public static int[] fib(){

        int[] f = new int[maxSize];

        f[0] = 1;
        f[1] = 1;
        for(int k = 2; k < maxSize; k++){
            f[k] = f[k-1] + f[k-2];
        }

        return f;
    }

    // 递归-Fibonacci队列
    public int recurFib(int i){
        if(i == 0 || i == 1){ // TODO:退出递归条件。
            return 1;
        } else {
            return recurFib(i -1) + recurFib(i - 2);
        }
    }

    /**
     *  from network
     */
    public static int fibSearch(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;
        int mid = 0;

        int k = 0;
        int f[] = fib();
        while (high > f[k] - 1) {
            k++;
        }

        int[] temp = Arrays.copyOf(a, f[k]); //TODO:

        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = a[high];
        }

        while (low <= high) {
            mid = low + f[k - 1] - 1;
            if (key < temp[mid]) {
                high = mid - 1;
                k--;
            } else if (key > temp[mid]) {
                low = mid + 1;
                k -= 2;
            } else {
                if (mid <= high) {
                    return mid;
                } else {
                    return high;
                }
            }
        }

        return -1;
    }

    /**
     * @auther tongchengfeng
     */
    public static int fibonacciSearch(int[] arr, int searchValue){

        int len = arr.length;

        int low = 0;
        int mid = 0;
        int high = len - 1;

        int k = 0;
        int[] f = fib();
        while (len > f[k]){
            k++;
        }

        int[] temp = Arrays.copyOf(arr, f[k]);

        for(int index = high + 1; index < temp.length; index++){
            temp[index] = arr[high];
        }

        while (low < high){
            mid = low + f[k-1] - 1;
            if(searchValue < temp[mid]){
                high = mid - 1;
                k--;
            } else if(searchValue > temp[mid]){
                low = mid + 1;
                k-=2;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 5, 7, 9, 10, 12, 13,14,16,17,18,20,25};
//        FibonacciSearch.fibSearch(nums, 13);
//        System.out.println(FibonacciSearch.fibonacciSearch(nums, 5));

        // Fibonacci递归
        int result = new FibonacciSearch().recurFib(5);
        System.out.println(result);
    }

}
