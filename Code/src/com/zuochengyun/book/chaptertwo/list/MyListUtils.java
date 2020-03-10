package com.zuochengyun.book.chaptertwo.list;

public class MyListUtils {
	public static Node cteateSigleList() {
		Node head1=new Node(1);
		Node node1=new Node(2);
		Node node2=new Node(3);
		head1.next=node1;
		node1.next=node2;
		node2.next=null;
		return head1;
	}
	/**
	 * 创建n个节点的环形链表
	 * @param n
	 * @return
	 */
	public static Node createRangList(int n) {
		if(n<1) {
			return null;
		}
		Node head=new Node(-1);
		Node node=null;
		Node currentNode=head;
		for(int i=1;i<=n;i++) {
			node = new Node(i);
			currentNode.next=node;
			currentNode=currentNode.next;
		}
		currentNode.next=head.next;
		return head.next;
	}
	public static void printList(Node head) {
		while(head!=null) {
			System.out.print(head.value + " ");
			head=head.next;
		}
	}
}
