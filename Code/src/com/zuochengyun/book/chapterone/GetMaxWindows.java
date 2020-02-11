package com.zuochengyun.book.chapterone;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
/**
 * �õ��������ڵ����ֵ��ʱ�临�Ӷ�ΪO��N��
 * ����˼·������˫�˶��У�����ֵ�Ӷ�β��������У����������ֵ�ȶ�β��Ԫ�ش��򵯳���βԪ��
 * ֱ����βԪ�ر�Ҫ������ֵ����߶���Ϊ�գ�����ӣ����ʱ�����Ԫ�ؾ���������ڵ�ǰ�����ֵ
 * @author caizongyu
 *
 */
public class GetMaxWindows {
	private static  int[] arr= {4,3,5,4,3,3,6,7};
	private static int index=0;
	private static int[] ans;
	private static Deque<Integer> deque;
	private static int windowsSize;
	private static void init() {
		if(arr ==null ) {
			return;
		}
		deque =new LinkedList<>();
		windowsSize = 3;
		ans =new int[arr.length-windowsSize+1];
	}
	private static void doGetMaxArr() {
		if(arr ==null || windowsSize<=0  || arr.length < windowsSize) {
			return;
		}
		for(int i=0;i<arr.length;i++) {
			while(!deque.isEmpty() && arr[deque.getLast()] < arr[i]) {
				deque.pollLast();
			}
			deque.addLast(i);
			if(deque.getFirst() <= i-windowsSize) {
				deque.pollFirst();
			}
			if(i>=windowsSize-1) {
				ans[index++]=arr[deque.getFirst()];
			}
		}
	}
	public static void main(String[] args) {
		init();
		doGetMaxArr();
		System.out.println(Arrays.toString(ans));
	}
}
