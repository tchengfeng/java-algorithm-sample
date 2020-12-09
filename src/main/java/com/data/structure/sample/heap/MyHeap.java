package com.data.structure.sample.heap;

/**
 * 堆排序
 * 具体的流程是 数组---》大顶堆（或者是小顶堆）---》第一个个元素和最后一个元素调换位置---》重复元素下沉，以完成排序。
 *
 * arr[i].left = arr[2*i+1]
 * arr[i].right = arr[2*i+2]
 * arr[i].super = arr[i/2]
 */
public class MyHeap {

    public int[] originalArray;
    public int originalLen;

    public MyHeap(int[] arr, int length){
        this.originalArray = arr;
        this.originalLen = length - 1;
    }

    /**
     * 创建堆 percolate from each parent nodes to the last leaf node.
     * 根节点Index默认从(0 or 1)开始
     * 1. 升序大顶堆
     * 2. 降序小顶堆
     *
     * @param array 待排序列
     * @param heapT true for max heap, false for min heap
     */
    private void buildHeap(int[] array, boolean heapT) {
        int len = array.length;

        if(heapT){
            for (int i = len / 2 - 1 ; i >= 0; i--) { // TODO: i=(len-1)/2 or i = len/2-1
                buildMaxHeap(array, i, len);
            }
        } else {
            for (int i = len / 2 - 1 ; i >= 0; i--) { // TODO: i=(len-1)/2 or i = len/2-1
                buildMinHeap(array, i, len);
            }
        }

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

    /**
     * 扩展堆
     *
     * @param newSize
     */
    private int[] enlargeArray(int[] array, int newSize) {
        int[] old = array;
        array = new int[newSize];
        for(int i = 0; i < old.length; i++) {
            array[i] = old[i];
        }

        return array;
    }

    /**
     * 插入操作
     *
     * @param x
     */
    public void insertMaxHeap(int[] array, int x) {

        int len  = array.length -1;

        if(originalLen == len){
            array = enlargeArray(array, array.length * 2 + 1 );
        }

        // Percolate up
        int hole = len + 1;
        for(; x > array[hole/2]; hole /= 2) {
            array[hole] = array[hole/2];
        }
        array[hole] = x;

        System.out.println(array);
    }

    /**
     * 插入操作
     *
     * @param x
     */
    public void insertMinHeap(int[] array, int x) {

        int len = array.length - 1;

        if(len == originalLen){
            array = enlargeArray(array, array.length * 2 + 1 );
        }

        // Percolate up
        int hole = len + 1;
        for(; x < array[hole/2]; hole /= 2) {
            array[hole] = array[hole/2];
        }
        array[hole] = x;

        System.out.println(array);
    }

    /**
     * 删除最大元素
     *
     * @return
     * @throws Exception
     */
    public int deleteMaxHeap(int[] array) throws Exception {
        int len = array.length - 1;

        if(len == -1){
            throw new Exception();
        }

        int maxItem = array[0];
        array[0] = array[len];

        buildMaxHeap(array,0, --len);

        return maxItem;
    }

    /**
     * 删除最小元素
     *
     * @return
     * @throws Exception
     */
    public int deleteMinHeap(int[] array) throws Exception {

        int len = array.length - 1;

        if(len == -1){
            throw new Exception();
        }

        int minItem = array[0];
        array[0] = array[len];
        buildMinHeap(array,0, --len);

        return minItem;
    }

    public static void main(String[] args) throws Exception {

        int[] arr = {150,80,40,30,10,70,110,100,20,90,60,50,120,140,130};

        MyHeap myHeap = new MyHeap(arr,arr.length);

        // Max Heap
//        myHeap.buildHeap(arr,true);
//        myHeap.insertMaxHeap(arr, 135);
//        myHeap.deleteMaxHeap(arr);
//
//        System.out.println(arr);

        // Min Heap
        myHeap.buildHeap(arr,false);
        myHeap.insertMinHeap(arr,135);
        myHeap.deleteMinHeap(arr);

        System.out.println(arr);
    }

}
