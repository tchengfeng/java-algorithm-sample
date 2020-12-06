package com.algorithm.sample.leeCode;

import java.util.Arrays;

/**
 * 求出整数序列中连续元素相加的最大数值。如：2, -4, 8, 3, 5, -9, 4, 6, -2 。
 * <53.最大子序和>
 */
public class MaxSubArraySum {


    /**
     *  * <贪心算法>
     */
    public static int maxSubArray1(int[] nums) {

        int len = nums.length;

        int maxSum = nums[0];
        int beforeMaxSum = 0;
        int currentMaxSum = 0;

        for(int index = 0; index < len; index++){
            int currentValue = nums[index];

            if(beforeMaxSum < 0){
                currentMaxSum = currentValue;
            } else {
                currentMaxSum = beforeMaxSum + currentValue;
            }

            if(maxSum < currentMaxSum){
                maxSum = currentMaxSum;
            }

            beforeMaxSum = currentMaxSum;

        }

        return maxSum;

    }

    /**
     * <动态规划>
     */
    public static int maxSubArray2(int[] nums) {

        int maxSum = nums[0];
        int currentMaxSum = nums[0];
        for(int index = 1; index < nums.length; index++){
            int currentValue = nums[index];
            if(currentMaxSum < 0){
                currentMaxSum = currentValue;
            }else {
                currentMaxSum += currentValue;
            }

            if(maxSum < currentMaxSum){
                maxSum = currentMaxSum;
            }

        }

        return maxSum;
    }

    /**
     * @author tongchengfeng
     * <分治法-递归>
     */
    public static int maxSubArray31(int[] a, int left, int right) {

        if (left == right) {
            if (a[left] > 0) {
                return a[left];
            } else
                return 0;
        }

        int center = (left + right) / 2;
        int maxLeftSum = maxSubArray31(a, left, center);
        int maxRightSum = maxSubArray31(a, center + 1, right);

        int maxLeftBorderSum = 0;
        int leftBorderSum = 0;
        for (int i = center; i >= left; i--) {
            leftBorderSum += a[i];
            if (maxLeftBorderSum < leftBorderSum) {
                maxLeftBorderSum = leftBorderSum;
            }
        }

        int maxRightBorderSum = 0;
        int rightBorderSum = 0;
        for (int i = center + 1; i <= right; i++) {
            rightBorderSum += a[i];
            if (maxRightBorderSum < rightBorderSum) {
                maxRightBorderSum = rightBorderSum;
            }
        }

        return Math.max(Math.max(maxLeftSum, maxRightSum), maxLeftBorderSum
                + maxRightBorderSum);
    }

    /**
     * <分治法-递归>
     */
    public static int maxSubArray32(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        if (left == right) {
            if (nums[left] > 0) {
                return nums[left];
            } else
                return 0;
        }

        int center = (left + right) / 2;

        int[] leftSubArray = Arrays.copyOfRange(nums,left,center);
        int[] rightSubArray = Arrays.copyOfRange(nums,center,right+1);

        int maxLeftSum = maxSubArray32(leftSubArray);
        int maxRightSum = maxSubArray32(rightSubArray);

//        int maxLeftSum = maxSubArray(nums, left, center);
//        int maxRightSum = maxSubArray(nums, center + 1, right);



        int maxLeftBorderSum = 0;
        int leftBorderSum = 0;
        for (int i = center; i >= left; i--) {
            leftBorderSum += nums[i];
            if (maxLeftBorderSum < leftBorderSum) {
                maxLeftBorderSum = leftBorderSum;
            }
        }

        int maxRightBorderSum = 0;
        int rightBorderSum = 0;
        for (int i = center + 1; i <= right; i++) {
            rightBorderSum += nums[i];
            if (maxRightBorderSum < rightBorderSum) {
                maxRightBorderSum = rightBorderSum;
            }
        }

        return Math.max(Math.max(maxLeftSum, maxRightSum), maxLeftBorderSum
                + maxRightBorderSum);

    }

    public static void main(String[] args) {
        int nums[] = { 2, -4, 8, 3, 5, -9, 4, 6, -2 };
//        System.out.println(maxSubArray1(nums));
//        System.out.println(maxSubArray2(nums));
        System.out.println(maxSubArray31(nums, 0, nums.length - 1)); // TODO: tongchengfeng
//        System.out.println(maxSubArray32(nums));
    }
}