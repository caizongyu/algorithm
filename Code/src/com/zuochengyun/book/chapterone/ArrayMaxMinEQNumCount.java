package com.zuochengyun.book.chapterone;

import java.util.Deque;
import java.util.LinkedList;
/**本包 利用栈和队列
 * 求最大值和最小值差值在num内的子数组数量
 * 使用两个双端队列，求出最小值，和最大值
 * @author c
 *
 */
public class ArrayMaxMinEQNumCount {
	private static Deque<Integer> maxDeque;
	private static Deque<Integer> minDeque;
	private static void init() {
		maxDeque = new LinkedList<>();
		minDeque = new LinkedList<>();
	}
	private static int doCalculateCount(int[] arr, int num) {
		if(arr == null || arr.length <=1) {
			return -1;
		}
		int head=0;
		int end=0;
		int result=0;
		for(int i=0;i<arr.length;i++) {
			for(int j=i;j<arr.length;j++) {
				while(!maxDeque.isEmpty() && arr[j]>=arr[maxDeque.peekLast()]) {
					maxDeque.pollLast();
				}
				maxDeque.addLast(j);
				while(!minDeque.isEmpty() && arr[j]<=arr[minDeque.peekLast()]) {
					minDeque.pollLast();
				}
				minDeque.addLast(j);
				head = i;
				end =j;
				if(arr[maxDeque.peekFirst()]-arr[minDeque.peekFirst()]>num) {
					break;
				}
			}
			//下一次窗口里应该去除i
			if(minDeque.peekFirst() == i) {
				minDeque.pollFirst();
			}
			if(maxDeque.peekFirst() == i) {
				maxDeque.pollFirst();
			}
			result +=end-i;
			
		}
		return result;
	}
	public static void main(String[] args) {
		int[] arr= {4,1,2,3,6};
		init();
		int result = doCalculateCount(arr, 2);
		System.out.println(result);
	}
}
