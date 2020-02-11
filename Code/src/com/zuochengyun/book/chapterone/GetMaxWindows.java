package com.zuochengyun.book.chapterone;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
/**
 * 得到滑动窗口的最大值，时间复杂度为O（N）
 * 解题思路：利用双端队列，将数值从队尾放入队列中，如果放入数值比队尾的元素大，则弹出队尾元素
 * 直到队尾元素比要放入数值大或者队列为空，则入队，这个时候队首元素就是这个窗口当前的最大值
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
