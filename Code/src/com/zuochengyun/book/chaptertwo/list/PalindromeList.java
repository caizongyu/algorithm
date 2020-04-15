package com.zuochengyun.book.chaptertwo.list;

import java.lang.instrument.Instrumentation;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

/**
 * 回文列表
 * @author caizongyu
 *
 */
public class PalindromeList {
	/**
	 * 方法1 使用栈
	 * @return
	 */
	
	private static boolean userStack(Node head) {
		if(head == null) {
			return false;
		}
		Stack<Integer> stack = new Stack<>();
		int length=MyListUtils.getListSize(head);
		Node currentNode=head;
		for(int i=0;i<length/2;i++) {
			stack.push(currentNode.value);
			currentNode=currentNode.next;
		}
		if((length&1) == 1) {
			currentNode = currentNode.next;
		}
		while(stack!=null && stack.size()>0) {
			if(stack.pop() != currentNode.value) {
				return false;
			}
			currentNode = currentNode.next;
		}
		return true;
	}
	/**
	 * 方法2 使用逆转list方法
	 * @return
	 */
	private static boolean userRevertList(Node head) {
		int length=MyListUtils.getListSize(head);
		Node currentNode = head;
		for(int i=0;i<length/2;i++){
			currentNode =currentNode.next;
		}
		if((length&1)==1) {
			currentNode = currentNode.next;
		}
		Node reserveHead = revertList(currentNode);
		while(reserveHead!=null && head!=null) {
			if(reserveHead.value != head.value) {
				return false;
			}
			reserveHead = reserveHead.next;
			head = head.next;
		}
		return true;
	}
	private static Node revertList(Node begin) {
		Node pre=null;
		Node currentNode = begin;
		Node next = null;
		while(currentNode != null) {
			next = currentNode.next;
			currentNode.next = pre;
			pre=currentNode;
			currentNode = next;
		}
		return pre;
	}
	public static void main(String[] args) {
		//System.out.println(userStack(MyListUtils.createPalindromeList(4)));
		//System.out.println(userStack(MyListUtils.createNNodeList(5)));
		System.out.println(userRevertList(MyListUtils.createPalindromeList(4)));
		System.out.println(userRevertList(MyListUtils.createPalindromeList(5)));
		System.out.println(userRevertList(MyListUtils.createNNodeList(4)));
		
		
	}
}
