package com.algorithm.sample.leeCode;

import java.util.Arrays;


/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * 说明：
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 * <88. 合并两个有序数组>
 */
public class MergeArray {

    /**
     * 方法一 : 合并后排序
     * @author tongchengfeng
     */
    public void merge0(int[] nums1, int m, int[] nums2, int n) {
        int[] sArray = new int[m+n];

        int index = 0;
        for(int i =0; i < nums1.length && i < m; i++){
            sArray[i] = nums1[i];
            index++;
        }

        for(int j = 0, k = index; j < nums2.length && j < n && k < m + n; j++, k++){
            sArray[k] = nums2[j];
        }

        Arrays.sort(sArray);

    }

    /**
     * 方法一 : 合并后排序
     * @author tongchengfeng
     */
    public void merge11(int[] nums1, int m, int[] nums2, int n) {
        for(int i =0; i < nums2.length && i < n; i++){
            nums1[m + i] = nums2[i];
        }

        Arrays.sort(nums1);

    }

    /**
     * 方法一 : 合并后排序
     * @author LeeCode
     *
     */
    public void merge12(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    /**
     * 方法二 : 双指针 / 从前往后
     * @author LeeCode
     *
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        // Make a copy of nums1.
        int [] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);

        // Two get pointers for nums1_copy and nums2.
        int p1 = 0;
        int p2 = 0;

        // Set pointer for nums1
        int p = 0;

        // Compare elements from nums1_copy and nums2
        // and add the smallest one into nums1.
        while ((p1 < m) && (p2 < n))
            nums1[p++] = (nums1_copy[p1] < nums2[p2]) ? nums1_copy[p1++] : nums2[p2++];

        // if there are still elements to add
        if (p1 < m)
            System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
        if (p2 < n)
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
    }

    /**
     * 方法三 : 双指针 / 从后往前
     * @author LeeCode
     *
     */
    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        // two get pointers for nums1 and nums2
        int p1 = m - 1;
        int p2 = n - 1;
        // set pointer for nums1
        int p = m + n - 1;

        // while there are still elements to compare
        while ((p1 >= 0) && (p2 >= 0))
            // compare two elements from nums1 and nums2
            // and add the largest one in nums1
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];

        // add missing elements from nums2
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }

    public static void main(String[] args) {
        int[] aArray = new int[]{1,2,3,0,0,0};
        int[] bArray = new int[]{2,5,6};
        int m = 3,n=3;
//        new MergeArray().merge0(aArray,m,bArray,n);
//        new MergeArray().merge11(aArray,m,bArray,n);
//        new MergeArray().merge12(aArray,m,bArray,n);
//        new MergeArray().merge2(aArray,m,bArray,n);
        new MergeArray().merge3(aArray,m,bArray,n);
    }

}
