package com.list;

import com.zuochengyun.book.chaptertwo.list.MyListUtils;
import com.zuochengyun.book.chaptertwo.list.Node;

/**
 * 逆置链表
 */
public class ReserveList {
    public static Node getResult(){
        Node head = MyListUtils.createNNodeList(5);
        if(head == null){
            return null;
        }
        Node begin = head;
        Node temp = null;
        while(head.next != null) {
            temp = head.next;
            head.next = head.next.next;
            temp.next = begin;
            begin = temp;
        }
        return begin;
    }

    public static void main(String[] args) {
        Node  head = getResult();
        MyListUtils.printList(head);
    }
}
