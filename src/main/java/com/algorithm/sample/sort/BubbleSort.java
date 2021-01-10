package com.algorithm.sample.sort;

/**
 * 最简单的排序算法。
 * 算法思想：每次从数组末端开始比较相邻两元素，把第i小的冒泡到数组的第i个位置。i从0一直到N-1从而完成排序。
 */

public class BubbleSort {

    /**
     * 算法思想：每次从数组末端开始比较相邻两元素，把第i小的冒泡到数组的第i个位置。i从0一直到N-1从而完成排序。
     * <end -> start => mix>
     * @author XXX
     */
    public static void bubbleSort1(int[] a) {

        int len = a.length;
        for (int i = 0; i < len-1; i++) {
            for (int j = len - 1; j > i; j--) {
                if (a[j - 1] > a[j]) {
                    int tmp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = tmp;
                }
            }
        }

        System.out.println(a);

    }

    /**
     * <end -> start => Max>
     *
     * @author XXX
     */
    public static void bubbleSort4(int[] arr) {

        int len = arr.length;
        for(int i = len-1; i > 0; i--){
            for(int j = i-1; j >=0; j--){
                if(arr[i] < arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        System.out.println(arr);
    }


    /**
     * 从数组开始端开始比较相邻两元素，把第i大的冒泡到数组的第N-i个位置。i从0一直到N-1,从而完成排序。
     * <start -> end => Max>
     * @author XXX
     */
    public static void bubbleSort2(int[] arr) {

        int len = arr.length;
        for (int i = 0; i < len-1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        System.out.println(arr);

    }

    /**
     * <start -> end => Mix>
     *
     * @author XXX
     */
    public static void bubbleSort3(int[] arr) {

        int len = arr.length;
        for(int i = 0; i < len -1; i++){
            for(int j = i+1; j< len; j++){
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        System.out.println(arr);
    }

    /**
     * @author XXX
     */
    public static void bubbleSort(int[] arr) {

        int len = arr.length;

        for(int i = 0; i < len-1; i++){
             int temp;
            for(int j = 0; j < len - i -1; j++){
                if(arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }

        }

        System.out.println(arr);

    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 2, 9, 5, 8, 35, 24 };
//        bubbleSort1(nums);
//        bubbleSort2(nums);
//        bubbleSort3(nums);
        bubbleSort4(nums);
//        bubbleSort(nums);

    }

}
