package com.zuochengyun.book.chaptertwo.list;
/**
 * 两链表相加
 *链表每一个节点都在0~9 之间，链表整体就代表一个数字
 *没定两个链表的head，生成结果链表
 *主要是防止数据过大溢出
 * @author caizongyu
 *
 */
public class TwoListAdd {
	public static Node method(Node head1, Node head2) {
		if(head1 == null || head2 == null) {
			return null;
		}
		head1=revertList(head1);
		head2=revertList(head2);
		int one=0;
		Node head3=new Node(-1);
		Node current = head3;
		Node newNode = null;
		while(head1!=null && head2!=null) {
			newNode =new Node((head1==null?0:head1.value)+(head2==null?0:head2.value)%10+one);
			one = (head1==null?0:head1.value)+(head2==null?0:head2.value)/10;
			current.next = newNode;
			current = current.next;
		}
		return revertList(head3.next);
	}
	/**
	 * 逆转链表
	 * @param head
	 * @return
	 */
	public static Node revertList(Node head) {
		Node pre= null;
		Node current = head;
		Node next = null;
		while(head!= null) {
			next=current.next;
			current.next = pre;
			pre = current;
			current  = current.next;
		}
		return pre;
	}
}
