
package com.algorithm.sample.search;

public class BinarySearch {

    /**
     * 二分查找（折半查找），版本1
     */
    public int binarySearch1(int a[], int n, int key)
    {
        int low, high, mid;
        low = 0;
        high = n;
        while(low<=high)
        {
            mid = (low+high)/2;
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
     * 二分查找 递归版本
     */
    public int binarySearch2(int a[], int value, int low, int high) {
        int mid = low+(high-low)/2;
        if(a[mid]==value){
            return mid;
        } else if(a[mid]>value) {
            return binarySearch2(a, value, low, mid-1);
        } else if(a[mid]<value) {
            return binarySearch2(a, value, mid+1, high);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {8,2,4,5,3,10,21,6,9};
        new BinarySearch().binarySearch1(arr,arr.length -1, 10);
        new BinarySearch().binarySearch2(arr,10, 0, arr.length-1);
    }

}
