package com.zuochengyun.book.chaptertwo.list;

import java.util.logging.Logger;

/**
 * ����������л���Ҳ����û�У��ж����������Ƿ��ཻ
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
		//һ���ǻ�һ������˵�����ཻ
		if(rang1!=rang2) {
			return null;
		}
		//�����ǻ�
		if(!rang1) {
			return allIsNotRang(head1, head2);
 		}
		//����rang
		
		
		return null;
	}
	/**
	 * �ж��Ƿ��ǻ�������
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
		//�ཻ�ڻ��� head1RangFrist  of head2RangFrist
		if(head1RangFrist != head2RangFrist) {
			return head1RangFrist;
		}
		int length1=1,length2=1;
		Node list1=head1;
		//�ж��ཻ�ڻ���
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
	 * �������л������ҵ���һ�����뻷�Ľڵ�
	 * ����ָ�� ��һ���������ָ��ص�ͷ��㣬Ȼ��һ���ƶ�һ��������ָ���ٴ�������ʱ�򣬾��ǽ��뻷�ĵ�һ���ڵ㡣
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
