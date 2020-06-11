package com.zuochengyun.book.chapterfour.dynamic;
/**
 * ��������arr��arr�����е�ֵ��Ϊ�����Ҳ��ظ���ÿ��ֻ����һ����ֵ�Ļ��ң�ÿ����ֵ���ҿ���������ţ�����һ������aim����Ҫ�ҵ�Ǯ����
 * ���ж����з�����
 * @author caizongyu
 *
 */
public class ExchangeMoneyMethodCount {
	private static int doGetMethodCount(int[] arr, int aim) {
		if(arr ==null || aim<1) {
			return 0;
		}
		int ans =violentRecursion(arr, 0, aim);
		return ans;
	}
	private static int violentRecursion(int[] arr,int len, int aim) {
		//��������
		int ans =0;
		if(len == arr.length) {
			ans = aim == 0? 1:0;
		}else {
			for(int i=0;arr[len]*i<=aim;i++) {
				ans += violentRecursion(arr, len+1, aim-arr[len]*i);
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		int[] arr = {5,10,25,1};
		
		System.out.println(doGetMethodCount(arr, 100));
	}
}
