package com.algorithm.sample.test;

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

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
        ListNode n8 = new ListNode(8);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;

        new Solution().oddEvenList1(n1);

    }



}