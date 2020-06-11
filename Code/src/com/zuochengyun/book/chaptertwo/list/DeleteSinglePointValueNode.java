package com.zuochengyun.book.chaptertwo.list;
/**
 * 删除单链表中指定值的节点
 * @author caizongyu
 *
 */
public class DeleteSinglePointValueNode {
	
	private static Node doDelete(int value, Node head) {
		Node free = new Node(-1);
		free.next = head;
		Node pre =free;
		while(head!= null) {
			if(head.value == value) {
				pre.next = head.next;
			}else {
				pre = pre.next;
			}
			head = head.next;
		}
		return free.next;
	}
	public static void main(String[] args) {
		int i = 1;
		i = i++;
		int j = i++;
		int k = i + ++i * i++;
		System.out.println("i = " + i);		
		System.out.println("j = " + j);		
		System.out.println("k = " + k);

	}
}
