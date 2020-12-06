package com.algorithm.sample.sort;

/**
 *Shell排序可以理解为插入排序的变种，它充分利用了插入排序的两个特点：
 *1）当数据规模小的时候非常高效
 *2）当给定数据已经有序时的时间代价为O(N)
 *所以，Shell排序每次把数据分成若个小块，来使用插入排序，
 *而且之后在这若个小块排好序的情况下把它们合成大一点的小块，继续使用插入排序，不停的合并小块，
 *知道最后成一个块，并使用插入排序。
 *
 *这里每次分成若干小块是通过“增量” 来控制的，开始时增量交大，接近N/2,从而使得分割出来接近N/2个小块，
 *逐渐的减小“增量“最终到减小到1。
 *
 *一直较好的增量序列是2^k-1,2^(k-1)-1,.....7,3,1,这样可使Shell排序时间复杂度达到O(N^1.5)
 *所以我在实现Shell排序的时候采用该增量序列
 *
 */
public class ShellSort {

    /**
     * @author XXX
     */
    public static void shellSort1(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {

            // insert sort
            for (int i = gap; i < arr.length; i++) {
                int index = i;
                int temp = arr[i]; // current
//                if (arr[index] < arr[index - gap]) { // TODO:why
                    while (index - gap >= 0 && temp < arr[index - gap]) {
                        arr[index] = arr[index - gap];
                        index -= gap;
                    }
                    arr[index] = temp;
//                }
            }

        }
        System.out.println(arr);
    }

    /**
     * @author XXX
     */
    public static void shellSort(int[] arr) {

    }

    public static void main(String[] args) {
        int[] nums = { 48, 37, 64, 96, 75, 12, 26, 48, 54, 3};
//        shellSort1(nums);
        shellSort(nums);
    }
}
