package com.zuochengyun.book.chapterone;

import java.util.Stack;

/**
 * ʹ�õݹ�����һ��ջ
 * @author 
 *
 */
public class ZuoBookThree {
	private static Stack<Integer> stack1=new Stack<>();
	private static void init(int[] arr) {	
		for(int i=0;i<arr.length;i++) {
			stack1.add(arr[i]);
		}		
	}
	/**
	 * �������һ��Ԫ�������һ��Ԫ�ز���ջ������Ԫ����ջ��ջ��˳���֮ǰһ����
	 * @return
	 */
	private static int getLastValueAndRemove() {
		int value = stack1.pop();
		if(stack1.isEmpty()) {
			return value;
		}else {
			int last=getLastValueAndRemove();
			stack1.push(value);
			return last;
		}
		
	}
	private static void doReverse() {
		int last =getLastValueAndRemove();
		if(!stack1.isEmpty()) {
			doReverse();
		}
		stack1.push(last);
		
	}
	public static void main(String[] args) {
		int[] arr= {5,4,3,2,1};
		init(arr);
		doReverse();
		while(!stack1.isEmpty()) {
			System.out.println(stack1.pop());
		}
	}
}
