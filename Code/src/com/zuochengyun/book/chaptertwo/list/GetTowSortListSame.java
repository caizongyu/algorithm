package com.zuochengyun.book.chaptertwo.list;
/**
 * 打印两个有序链表的公共部分
 * @author caizongyu
 *
 */
public class GetTowSortListSame {
	
	private static void getSamePart(Node head1, Node head2) {
		if(head1 == null || head2 ==null) {
			return;
		}
		while(head1!=null && head2!=null) {
			if(head1.value>head2.value) {
				head2=head2.next;
			}
			if(head1.value < head2.value) {
				head1=head1.next;
			}
			if(head1.value==head2.value) {
				System.out.print(head1.value+" ");
				head1=head1.next;
				head2=head2.next;
			}
		}
	}
	public static void main(String[] args) {
		getSamePart(initList1(), initList2());
	}
	private static Node initList1() {
		Node head1=new Node(2);
		Node node1=new Node(3);
		Node node2=new Node(4);
		head1.next=node1;
		node1.next=node2;
		node2.next=null;
		return head1;
	}
	private static Node initList2() {
		Node head2=new Node(1);
		Node node1=new Node(3);
		Node node2=new Node(4);
		head2.next=node1;
		node1.next=node2;
		node2.next=null;
		return head2;
	}
}
