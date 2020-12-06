package com.algorithm.sample.leeCode;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意：你不能在买入股票前卖出股票。
 *
 * <121. 买卖股票的最佳时机>
 */
public class MaxProfit {

    /**
     * @author LeeCode and tongchengfeng
     * 方法一：暴力法
     */
    public int maxProfit1(int prices[]) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }

    /**
     * @author LeeCode
     * 方法二：一次遍历
     */
    public int maxProfit2(int prices[]) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {

//        int[] nums = new int[]{7,1,5,3,6,4};
        int[] nums = new int[]{3,9,1,2};

//        new MaxProfit().maxProfit1(nums);
        new MaxProfit().maxProfit2(nums);

    }
}
