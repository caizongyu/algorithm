package com.zuochengyun.book.chaptertwo.list;

import java.util.HashSet;
import java.util.Set;

/**
 * 删除list中重复出现的节点
 * @author caizongyu
 *
 */
public class DeleteSingleListRepeatNode {
	/*
	 * time O(N)  space O(N)
	 */
	private static Node  userMap(Node head) {
		Set<Integer> set =new HashSet<>();
		Node pre = head;
		Node current = head;
		while(current!=null) {
			if(set.contains(current.value)) {
				pre.next = current.next;
			}else {
				set.add(current.value);	
				pre = current;
			}
			current = current.next;
		}
		return head;
	}
	/*
	 * time o(N^2)  space o(1)
	 */
	private static Node userSort(Node head) {
		Node begin = head;
		Node end = head;
		int temp = 0;
		Node pre = null;
		while(begin!=null) {
			pre = begin;
			end = begin.next;
			while(end!=null) {
				if(begin.value == end.value) {
					pre.next = end.next;
				}else {
					pre = pre.next;
				}
				end = end.next;
			}
			begin = begin.next;
			 
		}
		return head;
	}
	public static void main(String[] args) {
		Node head = MyListUtils.createNNodeList(2);
		Node node = new Node(8);
		node.next =head;
		Node node1 = new Node(2);
		node1.next = node;
		MyListUtils.printList(userSort(node1));
	}
}
