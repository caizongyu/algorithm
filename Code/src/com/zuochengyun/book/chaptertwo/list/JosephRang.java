package com.zuochengyun.book.chaptertwo.list;
/**
 * Լɪ��
 * ����һ�����ε��������ͷ���   ��m
 * @author caizongyu
 *
 */
public class JosephRang {
	private static Node doGetAns(Node head, int m) {
		if(head == null || m<=0) {
			return null;
		}
		return method1(MyListUtils.createRangList(1),1);
	}
	/**
	 * ������Ȧ����  ɾ��
	 * @param head
	 * @param m
	 * @return
	 */
	private static Node method1(Node head, int m) {
		int index=1;
		Node oldHead=head;
		while(head!=head.next) {
			if(index == m-1) {
				head.next=head.next.next;
				index=1;
			}else {
				index++;
			}
			if(m == 1 && head.next==oldHead) {
				return head;
			}
			head = head.next;
			
		}
		return head;
	}
	private static Node method2(Node head, int n) {
		
		return null;
	}
	public static void main(String[] args) {
		System.out.println(method1(MyListUtils.createRangList(1),1).value);
	}

}
