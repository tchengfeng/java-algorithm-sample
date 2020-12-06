package com.algorithm.sample.search;

public class InsertSearch {

    /**
     * 插值查找
     */
    public int insertSearch1(int a[], int n, int key)
    {
        int low, high, mid;
        low = 0;
        high = n;
        while(low<=high)
        {
            mid = low+(high-low)*(key-a[low])/(a[high]-a[low]); // TODO：VI
            if(a[mid]<key) {
                low = mid+1;
            }else if(a[mid]>key) {
                high = mid-1;
            } else {
                return mid;
            }
        }
        return 0;
    }

    /**
     * 插值查找 递归版本
     */
    public int insertSearch2(int a[], int value, int low, int high) {
        int mid = low+(value-a[low])/(a[high]-a[low])*(high-low); // TODO：VI
        if(a[mid]==value){
            return mid;
        } else if(a[mid]>value) {
            return insertSearch2(a, value, low, mid-1);
        } else if(a[mid]<value) {
            return insertSearch2(a, value, mid+1, high);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {8,2,4,5,3,10,21,6,9};
        new InsertSearch().insertSearch1(arr, arr.length, 10);
        new InsertSearch().insertSearch2(arr,10, 0, arr.length-1);
    }

}
