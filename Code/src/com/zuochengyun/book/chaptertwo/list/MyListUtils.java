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
	/**
	 * list's length is n 
	 * @param n
	 * @return
	 */
	public static Node createNNodeList(int n) {
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
		return head.next;
	}
	/**
	 * 创建n个节点的回文链表。
	 * @param n
	 * @return
	 */
	public static Node createPalindromeList(int n) {
		if(n<1) {
			return null;
		}
		int half =(n&1) == 0? n/2:n/2+1;
		Node node=null;
		Node head=new Node(-1);
		Node currentNode=head;
		for(int i=0;i<half;i++) {
			node=new Node(i+1);
			currentNode.next = node;
			currentNode=currentNode.next;
		}
		for(int i=n/2;i>0;i--) {
			node = new Node(i);
			currentNode.next=node;
			currentNode=currentNode.next;
		}
		return head.next;
		
	}
	/**
	 * 
	 * @param head
	 */
	public static void printList(Node head) {
		while(head!=null) {
			System.out.print(head.value + " ");
			head=head.next;
		}
	}
	public static int getListSize(Node head) {
		if(head == null) {
			return 0;
		}
		int length=0;
		while(head!=null) {
			head=head.next;
			length++;
		}
		return length;
	}
	public static void main(String[] args) {
		Node head = createPalindromeList(5);
		printList(head);
	}
	
}
