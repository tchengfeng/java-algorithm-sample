package com.algorithm.sample.leeCode;

import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那个数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <1. 两数之和>
 */
public class TwoSum {

    /**
     * @author tongchengfeng
     * <方法一：暴力枚举>
     */

    /**
     * @author LeeCode
     * <方法二：哈希表>
     */
    public static int[] sumFunc(int[] nums, int target){
        int len = nums.length;
        HashMap<Integer, Integer> resultMap= new HashMap<>(len -1);
        resultMap.put(nums[0],0);
        for(int i = 1; i < len; i++){
            int value = target - nums[i];
            if(resultMap.containsKey(value)){
                return new int[]{resultMap.get(value), i};
            }
            resultMap.put(nums[i],i);
        }
        return null;
    }

    public static void main(String args[]){
        int[] paramArray = new int[]{3,2,4};
        int target = 6;
        int[] resultArr = TwoSum.sumFunc(paramArray,target);
        System.out.println(resultArr);
    }

}
