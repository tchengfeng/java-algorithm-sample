package com.algorithm.sample.sort;

import java.util.Arrays;

/**
 * 堆排序
 * 具体的流程是 数组---》大顶堆（或者是小顶堆）---》第一个个元素和最后一个元素调换位置---》重复元素下沉，以完成排序。
 *
 * arr[i].left = arr[2*i+1]
 * arr[i].right = arr[2*i+2]
 * arr[i].super = arr[i/2]
 */
public class HeapSort {

    /**
     * 创建堆
     * 根节点Index默认从(0 or 1)开始
     * 1. 升序大顶堆
     * 2. 降序小顶堆
     *
     * @param arr 待排序列
     */
    private void heapSort(int[] arr) {

        //创建堆。TODO：percolate from each parent nodes to the last leaf node.
        int len = arr.length;
        for (int i = len / 2 - 1 ; i >= 0; i--) { // TODO: i=(len-1)/2 or i = len/2-1
            //从第一个非叶子结点从下至上，从右至左调整结构
            buildMaxHeap(arr, i, len);
//            buildMinHeap(arr, i, len);
        }

        //调整堆结构+交换堆顶元素与末尾元素。TODO：percolate from 0 to the last leaf node.
        for (int i = len - 1; i > 0; i--) {

            //将堆顶元素与末尾元素进行交换
            swap(arr,0,i);

            //重新对堆进行调整
//            buildMaxHeap(arr, 0, i);
            buildMinHeap(arr, 0, i);
        }
    }

    /**
     * 交换元素位置
     *
     * @param arr
     * @param i
     * @param j
     */
    public void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 构建大顶堆 and 调整堆。
     *
     * @param arr 待排序列
     * @param parent 父节点
     * @param length 待排序列尾元素索引
     */
    private static void buildMaxHeap(int[] arr, int parent, int length) {

        //将temp作为父节点
        int temp = arr[parent];

        //左孩子
        int lChild = 2 * parent + 1;

        while (lChild < length) { // 'for'

            //右孩子
            int rChild = lChild + 1;

            // 如果有右孩子结点，并且右孩子结点的值大于左孩子结点，则选取右孩子结点
            if (rChild < length && arr[lChild] < arr[rChild]) {
                lChild++;
            }

            // 如果父结点的值已经大于孩子结点的值，则直接结束
            if (temp >= arr[lChild]) {
                break;
            }

            // 把孩子结点的值赋给父结点
            arr[parent] = arr[lChild];

            //选取孩子结点的左孩子结点,继续向下筛选
            parent = lChild;
            lChild = 2 * lChild + 1; // for while
        }
        arr[parent] = temp;
    }

    /**
     * 构建小顶堆 and 调整堆。
     *
     * @param arr: 数组
     * @param parent：与左右子节点判断大小的根节点
     * @param length : 数组的总长度
     */
    public void buildMinHeap(int[] arr, int parent, int length){
        int temp = arr[parent];

        for(int lChild = 2 * parent + 1; lChild < length; lChild = lChild * 2 + 1){
            int rChild = lChild + 1;
            if(rChild < length && arr[lChild] > arr[rChild]){
                lChild++;
            }

            if(arr[lChild] < temp){
                arr[parent] = arr[lChild];
                parent = lChild;
            }

        }
        arr[parent] = temp;
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] arr = {150,80,40,30,10,70,110,100,20,90,60,50,120,140,130};
        heapSort.heapSort(arr);
        System.out.println(arr.toString());
        Arrays.sort(arr);
    }

}
