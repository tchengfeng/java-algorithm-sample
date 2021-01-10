package com.algorithm.sample.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * <基数排序>
 *
 * 基本思想：将所有待比较数值（正整数）统一为同样的数位长度，数位较短的数前面补零。
 * 然后，从最低位开始，依次进行一次排序。这样从最低位排序一直到最高位排序完成以后,数列就变成一个有序序列。
 *
 *  modify on 20210110
 */
public class RadixSort {

    public void radixSort(int[] array) {

        // 首先确定排序的趟数;
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        // 判断位数;
        int time = 0;
        while (max > 0) {
            max /= 10;
            time++;
        }

        // 建立10个队列;
        List<ArrayList> queue = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ArrayList<Integer> queue1 = new ArrayList<>();
            queue.add(queue1);
        }

        // 进行time次分配和收集;
        for (int i = 0; i < time; i++) {

            // 分配数组元素;
            for (int j = 0; j < array.length; j++) {
                // 计算数字的第time+1位数;
                int x = array[j] % (int) Math.pow(10, i + 1) / (int) Math.pow(10, i); // TODO: VI
                ArrayList<Integer> queue2 = queue.get(x);
                queue2.add(array[j]);
                queue.set(x, queue2);
            }

            // 元素计数器;
            int count = 0;

            // 收集队列元素;
            for (int k = 0; k < 10; k++) {
                while (queue.get(k).size() > 0) {
                    ArrayList<Integer> queue3 = queue.get(k);
                    array[count] = queue3.get(0);
                    queue3.remove(0);
                    count++;
                }
            }

        }

    }

    public static void main(String[] args) {
        int[] nums = { 48, 37, 64, 6, 75, 12, 26, 48, 54, 3 };
        new RadixSort().radixSort(nums);
    }

}
