package com.zuochengyun.book.chaptertwo.list;
/**
 * ����һ��ֵ���������Ϊ3���֣���һ����С��ֵ���ڶ����ֵ���ֵ���������ֵ���ֵ
 * @author caizongyu
 *
 */
public class SpitThreePartOfList {
	/**
	 * 
	 * @param head
	 * @return
	 */
	private Node doGetList(Node head, int value) {
		if(head == null) {
			return null;
		}
		Node left = new Node(-1);
		Node currentLeft = left;
		Node middle = new Node(-1);
		Node currentMiddle = middle;
		Node right = new Node(-1);
		Node currentRight = right;
		while(head!=null) {
			if(head.value < value) {
				currentLeft.next = head;
				currentLeft = currentLeft.next;
				continue;
			}
			if(head.value == value) {
				currentMiddle.next= head;
				currentMiddle = currentMiddle.next;
				continue;
			}
			if(head.value > value) {
				currentRight.next = right;
				currentRight = currentRight.next;
			}
			
		}
		currentLeft.next = middle.next;
		currentMiddle.next = right.next;
		return left.next;
	}
	private void mian() {
		// TODO Auto-generated method stub

	}
}
