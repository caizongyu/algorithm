package com.zuochengyun.book.chaptertwo.list;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 反转一个链表的一段       
 * @author caizongyu
 *
 */
public class ListRevertNToN {
	
	private static Node doRevertListNFromN(Node head,int from, int to) {
		if(head==null || from < 0 || to < from) {
			return null;
		}
		if(to==from) {
			return head;
		}
		//新建一个head 方便操作
		Node myHead=new Node(0);
		myHead.next=head;
		Node currentNode=myHead;
		int index=0;
		Node firstEnd=null;
		Node secondHead=null;
		//要逆置list其中的一段，可以把链表看成三段
		while(currentNode !=null) {
			//记录第一段最后一个结点
			if(index==from-1) {
				firstEnd=currentNode;
			}
			//获取最后一段的开头
			if(index == to+1) {
				secondHead=currentNode;
				break;
			}
			index++;
			currentNode=currentNode.next;
		}
		if(to >= index) {
			return null;
		}
		//第一段和第二段开头连接好
		firstEnd.next=doPartRevert(firstEnd.next, secondHead);
		return myHead.next;
	}
	/*
	 * 逆置第二段链表，并且和第三段链表连接好
	 */
	private static Node doPartRevert(Node begin,Node end) {
		Node pre=end;
		Node next=begin;
		while(next!=null && next!=end) {
			next=begin.next;
			begin.next=pre;
			pre=begin;
			begin=next;
		}
		return pre;
	}
	private static Node doRevert(Node head) {
		Node pre = null;
		Node next = head;
		while(next != null) {
			next = head.next;
			head.next= pre;
			pre = head;
			head=next;
		}
		return pre;
	}
	public static void main(String[] args) {
		Node head=doRevertListNFromN(MyListUtils.cteateSigleList(), 2, 3);
		//输出链表
		MyListUtils.printList(head);
	}
}
