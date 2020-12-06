package com.algorithm.sample.sort;

/**
 * 该算法在数据规模小的时候十分高效，该算法每次插入第K+1到前K个有序数组中一个合适置，*K从0开始到N-1,从而完成排序：
 * <插入排序-直接插入排序>
 */
public class InsertSort {

    /**
     * @authror tongchengfeng
     * <时间复杂度n2>
     */
    public static void insertSort1(int[] array) {

        for(int i = 1; i < array.length; i++){
            int temp;

            int j = i;
            while (array[j] < array[j-1] && j >=1){ // TODO:每次满足条件都交换，这就不是插入排序了，冒泡排序？
                temp = array[j];
                array[j] = array[j-1];
                array[j-1] = temp;
                j --;
            }
        }
        System.out.println(array);
    }

    /**
     * <时间复杂度nlog(n)>
     */
    public static int[] insertSort21(int[] arr) {
        int len = arr.length;
        int preIndex, current;
        for (int i = 1; i < len; i++) {
            preIndex = i - 1;
            current = arr[i];
            while (preIndex >= 0 && arr[preIndex] > current) { // TODO: index is different
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
        }
        return arr;
    }

    /**
     * <时间复杂度nlog(n)>
     */
    public static void insertSort22(int[] arr) {
        int len = arr.length;
        int preIndex, current;
        for (int i = 1; i < len; i++) {
            preIndex = i;
            current = arr[i];

            while (preIndex >= 1 && current < arr[preIndex - 1]){ // TODO: index is different
                arr[preIndex] = arr[preIndex - 1];
                preIndex--;
            }
            arr[preIndex] = current;
        }
        System.out.println(arr);
    }

    /**
     * <时间复杂度nlog(n)>
     */
    public static void insertSort(int[] arr) {

    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 2, 9, 5, 8, 35, 24 };
//        insertSort2(nums);
//        insertSort21(nums);
//        insertSort22(nums);
        insertSort(nums);
    }

}