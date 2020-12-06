package com.algorithm.sample.leeCode;

import java.util.Arrays;

/**
 * 小扣在秋日市集选择了一家早餐摊位，一维整型数组staple中记录了每种主食的价格，一维整型数组drinks中记录了每种饮料的价格。
 * 小扣的计划选择一份主食和一款饮料，且花费不超过x元。请返回小扣共有多少种购买方案。
 * <LCP 18. 早餐组合>
 * 1. 暴力算法
 * 2. 排序 + 二分查找法
 */
public class BreakfastNumber {

    /**
     * @author tongchengfeng
     * <暴力算法>
     */
    public int breakfastNumber1(int[] staple, int[] drinks, int x) {

        int allKinds = 0;

        int stapleLen = staple.length;
        int drinksLen = drinks.length;
        for(int i = 0; i < stapleLen; i++){
            for(int j = 0; j < drinksLen; j ++){
                int sumValue = staple[i] + drinks[j];
                if(sumValue <= x){
                    allKinds++;
                }
            }
        }

        return allKinds % 1000000007;
    }

    public static int hepler(int[] drinks, int stapleValue){
        int begin = 0;
        int end = drinks.length;

        while(begin < end){
            int mid = begin + (end - begin) / 2;
            if(drinks[mid] <= stapleValue){
                begin = mid + 1;
            }else {
                end = mid;
            }
        }

        return begin;

    }

    /**
     * <排序 + 二分查找法>
     */
    public int breakfastNumber2(int[] staple, int[] drinks, int x) {

        long sumKinds = 0;

        Arrays.sort(staple);
        Arrays.sort(drinks);
        for(int i : staple){

            if(i > x){
                break;
            }else {
                int currentKind = hepler(drinks,x-i);
                sumKinds += currentKind;
            }

        }
        return (int) (sumKinds % 1000000007 );

    }


    public static void main(String[] args) {

        int[] staple = new int[]{2,1,1};
        int[] drinks = new int[]{8,9,5,1};
        int x = 9;
        System.out.println(new BreakfastNumber().breakfastNumber1(staple,drinks,x));
//        System.out.println(new BreakfastNumber().breakfastNumber2(staple,drinks,x));

    }

}
