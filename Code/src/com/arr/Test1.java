package com.arr;

import com.zuochengyun.book.chaptertwo.list.Node;

/**
 * 单链表，倒数k个元素  1 2 3
 */
public class Test1 {
    public static Node doDelete(Node head, int k){
        if(head == null || k<0){
            return head;
        }
        Node pre = head;
        //快指针先走k步
        while(k>0 && pre != null){
            pre = pre.next;
            k--;
        }
        //如果没有k个节点，提前退出
        if(k!=0){
            return head;
        }
        //slow 指针
        Node first = new Node(-1);
        first.next = head;
        Node after = first;
        while(pre!=null){
            pre = pre.next;
            after = after.next;
        }
        after.next=after.next.next;
        return head;

    }
}
