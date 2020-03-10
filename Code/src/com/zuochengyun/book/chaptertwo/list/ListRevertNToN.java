package com.zuochengyun.book.chaptertwo.list;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * ��תһ�������һ��       
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
		//�½�һ��head �������
		Node myHead=new Node(0);
		myHead.next=head;
		Node currentNode=myHead;
		int index=0;
		Node firstEnd=null;
		Node secondHead=null;
		//Ҫ����list���е�һ�Σ����԰�����������
		while(currentNode !=null) {
			//��¼��һ�����һ�����
			if(index==from-1) {
				firstEnd=currentNode;
			}
			//��ȡ���һ�εĿ�ͷ
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
		//��һ�κ͵ڶ��ο�ͷ���Ӻ�
		firstEnd.next=doPartRevert(firstEnd.next, secondHead);
		return myHead.next;
	}
	/*
	 * ���õڶ����������Һ͵������������Ӻ�
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
		//�������
		MyListUtils.printList(head);
	}
}
