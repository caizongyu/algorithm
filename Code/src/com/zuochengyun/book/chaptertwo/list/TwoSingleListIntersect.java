package com.zuochengyun.book.chaptertwo.list;

import java.util.logging.Logger;

/**
 * 单链表可能有环，也可能没有，判断两个链表是否相交
 * @author caizongyu
 *
 */
public class TwoSingleListIntersect {
	private static Node getAns(Node head1, Node head2) {
		if(head1 == null || head2 == null) {
			return null;
		}
		boolean rang1 = isRangList(head1);
		boolean rang2 = isRangList(head2);
		//一个是环一个不是说明不相交
		if(rang1!=rang2) {
			return null;
		}
		//都不是环
		if(!rang1) {
			return allIsNotRang(head1, head2);
 		}
		//都是rang
		
		
		return null;
	}
	/**
	 * 判断是否是环形链表
	 * @param head
	 * @return
	 */
	private static boolean isRangList(Node head) {
		Node pre = head;
		Node after = head;
		while(pre !=null && after != null) {
			pre = pre.next;
			after = after.next;
			if(after == null) {
				return false;
			}
			after =after.next;
			if(after == pre) {
				return true;
			}
		}
		return false;
	}
	private static Node allIsNotRang(Node head1, Node head2) {
		int length1 = MyListUtils.getListSize(head1);
		int length2 = MyListUtils.getListSize(head2);
		Node lengthNode = null;
		Node shortNode = null;
		int compare = Math.abs(length1-length2);
		lengthNode = length1>length2?head1:head2;
		shortNode = length1>length2?head2:head1;
		while(compare > 0) {
			lengthNode = lengthNode .next;
			--compare;
			
		}
		while(lengthNode!=null && shortNode!=null) {
			if(lengthNode == shortNode) {
				return lengthNode;
			}
			lengthNode = lengthNode.next;
			shortNode = shortNode.next;
		}
		return null;
	}
	private static Node allIsRang(Node head1, Node head2) {
		Node head1RangFrist = RangFirstNode(head1);
		Node head2RangFrist = RangFirstNode(head2);
		//相交在环上 head1RangFrist  of head2RangFrist
		if(head1RangFrist != head2RangFrist) {
			return head1RangFrist;
		}
		int length1=1,length2=1;
		Node list1=head1;
		//判断相交在环外
		while(list1!=head1RangFrist) {
			list1=list1.next;
			++length1;
			
		}
		++length1;
		Node list2 = head2;
		while(list2!=head2RangFrist) {
			list2 = list2.next;
			++length2;
		}
		++length2;
		Node longerList = length1 > length2?head1 : head2;
		Node shorterList = length1> length2?head2:head1;
		int compare = Math.abs(length1-length2);
		while(compare > 0) {
			longerList = longerList.next;
			--compare;
		}
		while(true) {
			if(longerList == shorterList) {
				return longerList;
			}
			longerList = longerList.next;
			shorterList = shorterList.next;
			
		}
	}
	/**
	 * 单链表有环链表找到第一个进入环的节点
	 * 快慢指针 第一次相遇后快指针回到头结点，然后一次移动一步，快慢指针再次相遇的时候，就是进入环的第一个节点。
	 * @param head
	 * @return
	 */
	private static Node RangFirstNode(Node head) {
		Node slow = head;
		Node fast = head;
		while(true) {
			slow = slow.next;
			fast=fast.next.next;
			if(slow == fast) {
				break;
			}
		}
		fast = head;
		while(true) {
			slow = slow.next;
			fast = fast.next;
			if(slow == fast) {
				return slow;
			}		
		}
	}
}
