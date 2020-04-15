package com.zuochengyun.book.chaptertwo.list;

import java.util.Calendar;
import java.util.Date;

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
	 * ������Ȧ����  ɾ�� ʱ�临�Ӷ�O(N*M)
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
	/**
	 * ��ʽ����  n ��ʾ�����ڵ�,�����Ҫ��1 ��Ϊ��0��ʼ���
	 * @param args
	 */
	private static int method2(int n,int m) {
		if(n == 1) {
			return 0;
		}else {
			return (method2(n-1,m)+m)%n;
		}
	}

	public static void main(String[] args) {
		//System.out.println(method1(MyListUtils.createRangList(1),1).value);
		;
		Date date=new Date();
		System.out.println(Calendar.getInstance().getTime());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Calendar.getInstance().getTime());
	}

}
