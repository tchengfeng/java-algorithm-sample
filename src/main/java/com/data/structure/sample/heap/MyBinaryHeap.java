package com.data.structure.sample.heap;

/**
 * 二叉堆构建与操作
 *
 * @author tongchengfeng
 */
public class MyBinaryHeap {

    private int currentSize;
    private int[] array;

    /**
     * 构造器
     *
     * @param items
     */
    public MyBinaryHeap(int[] items) {
        currentSize = items.length;
        array = new int[(currentSize + 2 ) * 11 / 10]; // TODO: ???

        for(int i = 1; i <= currentSize; i++) { // TODO: 堆节点从1开始
            array[i] = items[i-1];
        }

        buildHeap();
    }

    /**
     * 构建堆
     */
    private void buildHeap() {
        for( int i = currentSize / 2; i > 0; i-- ) { // TODO: pNode = (childNode/2)
            percolateDown(i);
        }
    }

    /**
     * 扩展堆
     *
     * @param newSize
     */
    private void enlargeArray(int newSize) {
        int[] old = array;
        array = new int[newSize];
        for(int i = 0; i < old.length; i++) {
            array[i] = old[i];
        }
    }

    /**
     * 插入操作
     *
     * @param x
     */
    public void insert(int x) {
        if(currentSize == array.length - 1){
            enlargeArray(array.length * 2 + 1 ); // TODO: ???
        }

        // Percolate up
        int hole = ++currentSize;
        for(array[0] = x; x < array[hole/2]; hole /= 2) {
            array[hole] = array[hole/2];
        }
        array[hole] = x;
    }

    /**
     * 删除最小元素
     *
     * @return
     * @throws Exception
     */
    public int deleteMin() throws Exception {
        if(currentSize == 0){
            throw new Exception();
        }

        int minItem = array[1]; // TODO: 小顶堆堆顶Min
        array[1] = array[currentSize--];
        percolateDown(1);

        return minItem;
    }

    /**
     * 构建堆
     *
     * @param hole
     */
    private void percolateDown(int hole) {
        int child;
        int tmp = array[hole];

        for(; hole * 2 <= currentSize; hole = child) {

            child = hole * 2;
            if(child != currentSize && array[child + 1] < array[child]) {
                child++;
            }

            if(array[child] < tmp){
                array[hole] = array[child];
            } else {
                break;
            }
        }
        array[hole] = tmp;
    }

    public static void main(String[] args) throws Exception {

        int[] arr = {150,80,40,30,10,70,110,100,20,90,60,50,120,140,130};

        MyBinaryHeap myBinaryHeap = new MyBinaryHeap(arr);
        System.out.println(myBinaryHeap.array.toString());

        myBinaryHeap.insert(9);
        System.out.println(myBinaryHeap.array.toString());

        myBinaryHeap.deleteMin();
        System.out.println(myBinaryHeap.array.toString());
    }

}
