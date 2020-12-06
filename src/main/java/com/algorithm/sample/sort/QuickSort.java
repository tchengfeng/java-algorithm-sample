package com.algorithm.sample.sort;

/**
 * 快速排序是目前使用可能最广泛的排序算法了。
 * 一般分如下步骤：
 *  1）选择一个枢纽元素（有很多选法，我的实现里采用去中间元素的简单方法）
 *  2）使用该枢纽元素分割数组，使得比该元素小的元素在它的左边，比它大的在右边。并把枢纽元素放在合适的位置。
 *  3）根据枢纽元素最后确定的位置，把数组分成三部分，左边的，右边的，枢纽元素自己，对左边的，右边的分别递归调用快速排序算法即可。
 * 快速排序的核心在于分割算法，也可以说是最有技巧的部分。
 *
 * <方法一：递归 + 分治法>
 *
 */
public class QuickSort {

    /**
     * @author XXX
     */
    public static void quickSort1(int[] arr, int left, int right){

        int base = arr[left];
        while (left < right){
            while (left < right && arr[right] >= base){
                right--;
            }
            arr[left] = arr[right];

            while (left < right && arr[left] < base){
                left++;
            }
            arr[right] = arr[left];
        }

        arr[left] = base;

        quickSort1(arr,0, left);
        quickSort1(arr,left + 1,right);

        System.out.println(arr);
    }

    /**
     * @author XXX
     */
    public static void quickSort2(int[] arr, int left, int right) {
        int low, high, pivotKey;

        if (left < right) {

            // 选取基准（枢纽元），并将数组中间元素与数组首个元素交换。
//			pivotKey = arr[(left+right)/2]; //选取数组中间元素
//
//			int temp=arr[(left+right)/2];
//            arr[(left+right)/2]=arr[left];
//            arr[left]=temp;

            // 选取基准（枢纽元）：选取数组首个元素
            pivotKey = arr[left];

            low = left;
            high = right;

            while (low < high) {
                while (low < high && arr[high] >= pivotKey) {
                    high--;
                }
                if (low < high) {
                    arr[low++] = arr[high];
                }

                while (low < high && arr[low] <= pivotKey) {
                    low++;
                }
                if (low < high) {
                    arr[high--] = arr[low];
                }
            }
            arr[low] = pivotKey;

            quickSort2(arr, left, low - 1);
            quickSort2(arr, low + 1, right);
        }
        System.out.println(arr);
    }

    public static void quickSort(int[] a, int left, int right) {

    }

    public static void main(String[] args) {
        int[] nums = { 48, 37, 64, 96, 75, 12, 26, 48, 54, 3 };

//        quickSort1(nums, 0, nums.length - 1);
//        quickSort2(nums, 0, nums.length - 1);
        quickSort(nums, 0, nums.length - 1);

    }

}
