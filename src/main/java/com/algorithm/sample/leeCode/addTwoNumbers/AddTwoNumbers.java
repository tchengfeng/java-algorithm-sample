package com.algorithm.sample.leeCode.addTwoNumbers;


import com.algorithm.sample.leeCode.ReverseList;

public class AddTwoNumbers {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        ListNode tempNode = head;

        int i = 0;
        long iValue = 0;
        while(l1 != null){
            iValue += l1.val * Math.pow(10,i);
            i++;
            l1 = l1.next;
        }

        int j = 0;
        long jValue = 0;
        while(l2 != null){
            jValue += l2.val * Math.pow(10,j);
            j++;
            l2 = l2.next;
        }

        long value = iValue + jValue;

        long value2 = value;
        while(value2 > 0){
            int value1 = (int)(value2 % 10);
            value2 = value2 / 10;

            tempNode.next = new ListNode(value1);
            tempNode = tempNode.next;
        }

        if(head.next != null){
            head = head.next;
        }

        return head;
    }

    public static void main(String[] args) {

//        [1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1]
//        [5,6,4]

        ListNode head1 = new ListNode(5);

        ListNode head11 = new ListNode(6);
        ListNode head12 = new ListNode(4);

        head1.next = head11;
        head11.next = head12;


        ListNode head2 = new ListNode(1);

        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(0);
        ListNode node5 = new ListNode(0);
        ListNode node6 = new ListNode(0);
        ListNode node7 = new ListNode(0);
        ListNode node8 = new ListNode(0);
        ListNode node9 = new ListNode(0);
        ListNode node10 = new ListNode(0);
        ListNode node11 = new ListNode(0);
        ListNode node12 = new ListNode(0);
        ListNode node13 = new ListNode(0);
        ListNode node14 = new ListNode(0);
        ListNode node15 = new ListNode(0);

        ListNode node16 = new ListNode(1);

        head2.next = node1;

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;
        node10.next = node11;
        node11.next = node12;
        node12.next = node13;
        node13.next = node14;
        node14.next = node15;

        node15.next = node16;

//        ListNode newHead = new ReverseList().reverseList1(head);
        ListNode newHead = new AddTwoNumbers().addTwoNumbers(head2,head1);

        while (newHead!=null){
            System.out.println(newHead.val);
            newHead = newHead.next;
        }

    }
}
