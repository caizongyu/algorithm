package com.zuochengyun.book.chapterfour.dynamic;

import java.util.Arrays;

/*
 * 换钱最少货币数
 * 数组arr值都为正数且不重复。每个值表示一种面值的货币，每种面值的货币可以使用任意张，在给定一个整数代表要找的钱数，求组成aim‘的最少货币数。
 */
public class ExchangeMoneyMinCount {
	private static int userTableGetCount(int[] arr, int value) {
		if(arr == null || value<1) {
			return -1;
		}
		int[][] table = new int[arr.length][value+1];
		//init first row 
		table[0][0] = 0;
		for(int i=1;i<=value;i++) {
			table[0][i] = Integer.MAX_VALUE;
			if(i-arr[0]>= 0 && table[0][i-arr[0]]!=Integer.MAX_VALUE) {
				table[0][i] = table[0][i-arr[0]]+1;
			}
		}
		int left = 0;
		for(int i=1;i<arr.length;i++) {
			for(int j=1;j<table[0].length;j++) {
				left = Integer.MAX_VALUE;
				if(j-arr[i]>=0 && table[i][j-arr[i]] != Integer.MAX_VALUE) {
					left = table[i][j-arr[i]]+1;
				}
				table[i][j] = Math.min(table[i-1][j], left);
			}
		}
		printTwoDimensionalArray(table);
		return table[arr.length-1][value]==Integer.MAX_VALUE?-1:table[arr.length-1][value];
	}
	/**
	 * 优化方法
	 * @param arr
	 * @param value
	 * @return
	 */
	private static int userOneRawArray(int[] arr, int value) {
		if(arr == null || value <1) {
			return -1;
		}
		int[] dp = new int[value+1];
		dp[0]=0;
		//init dp arr
		for(int i=1;i<dp.length;i++) {
			dp[i] = Integer.MAX_VALUE;
			if(i-arr[0]>=0 && dp[i-arr[0]]!=Integer.MAX_VALUE) {
				dp[i] = dp[i-arr[0]]+1;
			}
		}
		for(int i=1;i<arr.length;i++) {
			for(int j=1;j<=value;j++) {
				if(j-arr[i]>0) {
					dp[j] = Math.min(dp[j-arr[i]]<Integer.MAX_VALUE?dp[j-arr[i]]+1:Integer.MAX_VALUE, dp[j]);
				}
				
			}
		}
		System.out.println(dp[value]);
		System.out.println(Arrays.toString(dp));
		return 0;
	}
	private static void printTwoDimensionalArray(int[][] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {5,2,3};
		//int ans = userTableGetCount(arr, 20);
		//System.out.println(ans);
		userOneRawArray(arr, 20);
	}
}
