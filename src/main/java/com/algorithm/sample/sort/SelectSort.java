package com.algorithm.sample.sort;

/**
 * 相对与插入排序来说，选择排序每次选出的都是全局第i小的，不会调整前i个元素了。
 * 选择排序相对于冒泡来说，它不是每次发现逆序都交换，而是在找到全局第i小的时候记下该元素位置，-
 * -最后跟第i个元素交换，从而保证数组最终的有序。
 */

public class SelectSort {

    /**
     * @ author XXX
     */
    public static void selectSort11(int[] arr){

        int temp;
        for (int i = 0; i < arr.length; i++) {

            int lowIndex = i;
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[lowIndex]) {
                    lowIndex = j;
                }
            }

            if (lowIndex != i) {
                temp = arr[i];
                arr[i] = arr[lowIndex];
                arr[lowIndex] = temp;
            }
        }

        System.out.println(arr);
    }

    /**
     * @ author tongchengfeng
     */
    public static void selectSort121(int[] arr){

        int len = arr.length;
        for(int i = 0; i < len; i++) {
            int minValue = arr[i];
            int minIndex = i;
            for(int j = i+1; j < len; j++){
                if(minValue > arr[j]){
                    minValue = arr[j];
                    minIndex = j;
                }
            }

            int temp = arr[i];
            arr[i] = minValue;
            arr[minIndex] = temp;
        }

        System.out.println(arr);
    }

    /**
     * @ author XXX
     */
    public static void selectSort122(int[] arr) {
        int len = arr.length;
        int minIndex, temp;
        for (int i = 0; i < len - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }

        System.out.println(arr);
    }

    /**
     * @ just for practice
     */
    public static void selectSort(int[] arr){

    }

    public static void main(String[] args) {
        int[] nums = { 48, 37, 64, 96, 75, 12, 26, 48, 54, 3 };

//        selectSort11(nums);
//        selectSort121(nums);
        selectSort122(nums);
//        selectSort(nums);

    }


}
