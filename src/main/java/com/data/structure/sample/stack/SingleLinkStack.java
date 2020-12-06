package com.data.structure.sample.stack;

import com.data.structure.sample.link.LinkNode;

public class SingleLinkStack {


    /**
     * add node.
     */
    public static LinkNode addNode(LinkNode head){
        LinkNode newNode = new LinkNode(12);
        newNode.next = head;
        head = newNode;
        return head;
    }

    /**
     * del node.
     */
    public static LinkNode delNode(LinkNode head){
        LinkNode tempNode;
        tempNode = head.next;
        head.next = null;
        head = tempNode;
        return head;
    }


    public static void main(String[] args) {

        LinkNode head = new LinkNode(10);
        LinkNode node1 = new LinkNode(20);
        LinkNode node2 = new LinkNode(30);
        LinkNode node3 = new LinkNode(40);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;

//        LinkNode newHead = addNode(head);
        LinkNode newHead = delNode(head);

        while (newHead!=null){
            System.out.println(newHead.data);
            newHead = newHead.next;
        }

    }

}
