package com.zuochengyun.book.chaptertwo.list;
/**
 * 删除链表的倒数第k个节点
 * @author caizongyu
 *
 */
public class DeleteListNumberK {
	private Node initList() {
		Node head =new Node(1);
		Node node1 = new Node(2);
		Node node2 = new Node(3);
		Node node3 = new Node(4);
		head.next=node1;
		node1.next=node2;
		node2.next=node3;
		node3.next=null;
		return head;
	}
	public static void main(String[] args) {
		Node head=new Node(1);
	}
}
