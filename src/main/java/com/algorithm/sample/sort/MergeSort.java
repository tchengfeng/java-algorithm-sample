package com.algorithm.sample.sort;

/**
 * <归并排序>
 *
 *算法思想是每次把待排序列分成两部分，分别对这两部分递归地用归并排序，完成后把这两个子部分合并成一个序列。
 *归并排序借助一个全局性临时数组来方便对子序列的归并，该算法核心在于归并。
 */

public class MergeSort {

    /**
     * @author tongchengfeng
     *
     */
    public static void mergeSort(int[] a) {
        int[] tempArray = new int[a.length]; // 辅助数组
        mergeSort(a, tempArray, 0, a.length - 1);
    }

    private static void mergeSort(int[] a, int[] tempArray, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(a, tempArray, left, center);
            mergeSort(a, tempArray, center + 1, right);
            merge(a, tempArray, left, center, center + 1, right);
        }

    }

    private static void merge(int[] a, int[] tempArray, int leftPos, int leftEnd, int rightPos, int rightEnd) {

        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;

        // main loop
        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (a[leftPos] <= a[rightPos])
                tempArray[tmpPos++] = a[leftPos++];
            else
                tempArray[tmpPos++] = a[rightPos++];
        }

        // Copy rest of left half
        while (leftPos <= leftEnd) {
            tempArray[tmpPos++] = a[leftPos++];
        }

        // Copy rest of right half
        while (rightPos <= rightEnd) {
            tempArray[tmpPos++] = a[rightPos++];
        }

        // Copy temArray back
        for (int i = 0; i < numElements; i++, rightEnd--) {
            a[rightEnd] = tempArray[rightEnd];
        }

    }

    public static void main(String[] args) {
        int[] nums = { 8, 57, 9, 23, 41, 65, 19, 0, 1, 2, 4, 5 };
        mergeSort(nums);
        for (int i = 0, n = nums.length; i < n; i++) {
            System.out.print(nums[i] + ",");
        }
    }

}
