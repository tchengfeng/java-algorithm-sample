package com.algorithm.sample.leeCode;

import com.data.structure.sample.link.LinkNode;

/**
 * <206. 反转链表>
 */
public class ReverseList {

    /**
     * 迭代
     */
    public LinkNode reverseList1(LinkNode head) {
        LinkNode newHead = null;
        while (head != null) {
            LinkNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }

        return newHead;
    }

    /**
     * 递归
     */
    public LinkNode reverseList2(LinkNode head){

        if (head == null || head.next == null) {
            return head;
        }
        LinkNode p = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public static void main(String[] args) {

        LinkNode head = new LinkNode(10);
        LinkNode node1 = new LinkNode(20);
        LinkNode node2 = new LinkNode(30);
        LinkNode node3 = new LinkNode(40);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;

//        ListNode newHead = new ReverseList().reverseList1(head);
        LinkNode newHead = new ReverseList().reverseList2(head);

        while (newHead!=null){
            System.out.println(newHead.data);
            newHead = newHead.next;
        }

    }

}
