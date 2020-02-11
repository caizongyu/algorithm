package com.zuochengyun.book.chapterone;

import java.util.Stack;

/**
 * 用一个栈实现另外一个栈的排序,从大到小
 * @author caizongyu
 *
 */
public class TwoStackSort {
	private static Stack<Integer> stack1;
	private static Stack<Integer> stack2;
	private static int[] arr = {1,5,8,4,3};
	private static void init() {
		if(arr == null) {
			return;
		}
		stack1 = new Stack<>();
		stack2 = new Stack<>();
		stack2.add(arr[0]);
		for(int i=1;i<arr.length;i++) {
			stack1.add(arr[i]);
		}
	}
	private static void doTwoStackSort() {
		while(!stack1.isEmpty()) {
			int stack1Top = stack1.pop();
			if(stack1Top >= stack2.peek()) {
				stack2.add(stack1Top);
			}else {
				while(!stack2.isEmpty() && stack2.peek() > stack1Top) {
					stack1.add(stack2.pop());
				}
				stack2.add(stack1Top);
			}
		}
	}
	public static void main(String[] args) {
		init();
		doTwoStackSort();
		while(!stack2.isEmpty()) {
			System.out.print(stack2.pop()+" ");
		}
	}
}
