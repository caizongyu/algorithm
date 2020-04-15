package com.zuochengyun.book.chaptertwo.list;
/**
 * 给定一个值，将链表分为3部分，第一部分小于值，第二部分等于值，第三部分等于值
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
