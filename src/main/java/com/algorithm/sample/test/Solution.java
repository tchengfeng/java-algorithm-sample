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

    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        HashMap<Integer, Integer> resultMap= new HashMap<>(len -1);
        resultMap.put(nums[0],0);
        for(int i = 1; i < len; i++){
            int value = target - nums[i];
            if(resultMap.containsKey(value)){
                return new int[]{resultMap.get(value), i};
            }
            resultMap.put(nums[i],i);
        }
        return null;
    }


    public boolean isIsomorphic(String s, String t) {
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        int[] preIndexOfs = new int[256];
        int[] preIndexOft = new int[256];
        for (int i = 0; i < chars.length; i++) {
            if (preIndexOfs[chars[i]] != preIndexOft[chart[i]]) {
                return false;
            }
            preIndexOfs[chars[i]] = i + 1;
            preIndexOft[chart[i]] = i + 1;
        }
        return true;
    }

    public String[] findRestaurant(String[] list1, String[] list2) {

        if(list1 == null || list1.length == 0){
            return list2;
        }

        if(list2 == null || list2.length == 0){
            return list1;
        }

        int minIndex = 60;
        int iLen = list1.length;
        int jLen = list2.length;

        ArrayList<String> resultStr = new ArrayList<String>();
        for(int i = 0; i < iLen; i++){
            String str = list1[i];
            for(int j = 0; j < jLen; j++){
                if(str.equals(list2[j])){

                    if(minIndex > (i + j)){
                        resultStr.clear();
                        resultStr.add(str);
                        minIndex = i + j;
                    } else if(minIndex == (i + j)){
                        resultStr.add(str);
                    }

                }
            }
        }

        return resultStr.toArray(new String[0]);

    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        HashMap<Integer, Integer> tempMap = new HashMap<Integer, Integer>();

        int len = nums.length;
        for(int i = 0; i < len; i++){

            if(tempMap.containsKey(nums[i])){
                int index = tempMap.get(nums[i]);
                int absValue = Math.abs(index - i);
                if(absValue <= k){
                    return true;
                }
            }

            tempMap.put(nums[i], i);
        }

        return false;
    }

    public int characterReplacement(String s, int k) {
        int len = s.length();

        int maxLen = k + 1;

        int i = 0;
        int j = i +1;


        while(i < len && j < len){
            if(s.charAt(i) == s.charAt(j)){
                j++;
            } else if(k > 0){
                k--;
                j++;
            } else{
                int newLen = j - i + 1;
                maxLen = (maxLen > newLen) ? maxLen : newLen;
                i++;
                j = i+1;
            }
        }

        return maxLen;
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

//        int[] arr1 = {3,15,2,7};
//        new Solution().twoSum(arr1,9);


        new Solution().characterReplacement("ABAB",2);

    }

}