package com.zuochengyun.book.chaptertwo.list;
/**
 * 将链表之间的每K个节点逆序
 * @author caizongyu
 *
 */
public class ListRevertEachK {
	private static Node doRevertEachK(int k, Node  head) {
		if(k <= 1 || head == null) {
			return head;
		}
		Node freeNode =new Node(-1);
		freeNode.next = head;
		Node begin = head;
		Node end = null;
		Node current = freeNode;
		int i=0;
		Node pre = freeNode;
		while(begin!= null) {
			current = current.next;
			++i;
			if(i == k || current.next == null) {
				end = current;
				pre.next = revertEachK(begin, end);
				pre = begin;
				i=0;
				//current 变化成逆置后的最后一个节点
				current = begin;
				begin = current.next;
			}
			
			
		}
		return freeNode.next;
	}
	private static Node revertEachK(Node begin, Node end) {
		if(begin == end) {
			return begin;
		}
		Node pre= end.next;
		Node current = begin;
		Node next = null;
		while(pre != end) {
			next = current.next;
			current.next = pre;
			pre =current;
			current= next;
		}
		return pre;
	}
	public static void main(String[] args) {
		Node head = MyListUtils.createNNodeList(5);
		head= doRevertEachK(2, head);
		MyListUtils.printList(head);
	}
	
}
