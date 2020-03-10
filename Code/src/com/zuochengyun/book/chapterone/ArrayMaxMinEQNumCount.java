package com.zuochengyun.book.chapterone;

import java.util.Deque;
import java.util.LinkedList;
/**���� ����ջ�Ͷ���
 * �����ֵ����Сֵ��ֵ��num�ڵ�����������
 * ʹ������˫�˶��У������Сֵ�������ֵ
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
			//��һ�δ�����Ӧ��ȥ��i
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
