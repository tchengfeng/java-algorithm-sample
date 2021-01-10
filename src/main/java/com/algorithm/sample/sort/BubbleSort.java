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

    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 2, 9, 5, 8, 35, 24 };
        bubbleSort1(nums);
        bubbleSort2(nums);
    }

}
