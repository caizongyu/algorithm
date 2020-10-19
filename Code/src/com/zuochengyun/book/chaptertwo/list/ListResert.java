package com.zuochengyun.book.chaptertwo.list;

public class ListResert {
    public static Node getResult(Node head){
        if(head == null){
            return null;
        }
        Node begin = head;
        Node next = null;
        while(head.next!=null){
            next = head.next;
            head.next = next.next;
            next.next = begin;
            begin = next;
        }
        return begin;
    }

    public static void main(String[] args) {
        Node head = MyListUtils.createNNodeList(5);
        MyListUtils.printList(head);
        MyListUtils.printList(getResult(head));
    }
}
