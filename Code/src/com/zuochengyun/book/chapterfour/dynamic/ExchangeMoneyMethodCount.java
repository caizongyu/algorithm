package com.zuochengyun.book.chapterfour.dynamic;
/**
 * 给定数组arr，arr中所有的值都为整数且不重复，每个只代表一种面值的货币，每种面值货币可以任意多张，给定一个整数aim代表要找的钱数，
 * 求有多少中方法。
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
		//方法数字
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
