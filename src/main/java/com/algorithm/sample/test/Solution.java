package com.algorithm.sample.test;

import java.util.*;

public class Solution {

    public ListNode oddEvenList1(ListNode head) {

        ListNode pB = new ListNode(0,head);
        ListNode pA = head;
        ListNode pC = head.next;

        while(pB.next != null && pA.next != null){

//            if(pB.next.next != null){
                pB.next = pB.next.next;
                pB = pB.next;
//            }

//            if(pA.next.next != null){
                pA.next = pA.next.next;
                pA = pA.next;
//            }

        }
        pB.next = null;
        pA.next = pC;

        return head;
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> compareSet = new HashSet<Integer>();

        for(int i = 0; i < nums.length; i++){
            boolean success = compareSet.add(nums[i]);
            if(!success){
                return false;
            }
        }

        return true;
    }

    public int singleNumber(int[] nums) {

        HashMap<Integer, Integer> resultMap = new HashMap<Integer,Integer>();

        for(int i = 0; i < nums.length; i++){

            Integer number = resultMap.get(nums[i]);
            if(number != null){
                resultMap.put(nums[i], ++number);
            }else{
                resultMap.put(nums[i],1);
            }

        }

        for(Map.Entry<Integer, Integer> entry : resultMap.entrySet()){
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }

        return 1;
    }

    public int[] intersection(int[] nums1, int[] nums2) {

        List<Integer> resultList = new ArrayList<Integer>();

        Set<Integer> setX = new HashSet<Integer>();
        Set<Integer> setY = new HashSet<Integer>();

        for(int i = 0; i < nums1.length; i++){
            setX.add(nums1[i]);
        }

        for(int i : nums2){
            setY.add(i);
        }

        Iterator it = setX.iterator();

        while(it.hasNext()){
            Integer iValue = (Integer) it.next();
            boolean isSuccess = setY.add(iValue);
            if(!isSuccess){
                resultList.add(iValue);
            }
        }

        int[] resultArray = new int[resultList.size()];
        for(int i = 0; i < resultList.size(); i++){
            resultArray[i] = resultList.get(i);
        }

        return resultArray;
    }

    boolean resultB = false;
    public void helper(int number){

        int sum = 0;
        int i = number % 10;
        int j = number / 10;

        while(i != 0 || j != 0){
            sum += Math.pow(i,2);
            i = j % 10;
            j = j / 10;
        }

        if(sum == 1){
            resultB = true;
            return;
        } else {
            helper(sum);
        }

    }

    public boolean isHappy(int n) {

        if(n == 1){
            return true;
        }

        helper(n);

        return resultB;
    }

    public static void main(String[] args) {
//        ListNode n1 = new ListNode(1);
//        ListNode n2 = new ListNode(2);
//        ListNode n3 = new ListNode(3);
//        ListNode n4 = new ListNode(4);
//        ListNode n5 = new ListNode(5);
//        ListNode n6 = new ListNode(6);
//        ListNode n7 = new ListNode(7);
//        ListNode n8 = new ListNode(8);
//
//        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
//        n4.next = n5;
//        n5.next = n6;
//        n6.next = n7;
//        n7.next = n8;
//
//        new Solution().oddEvenList1(n1);

//        int[] arr1 = {1,2,2,1};
//        int[] arr2 = {2,2};
//        new Solution().intersection(arr1,arr2);

        new Solution().isHappy(19);

    }



}