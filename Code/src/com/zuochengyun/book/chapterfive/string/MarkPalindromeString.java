package com.zuochengyun.book.chapterfive.string;

import java.util.Arrays;

/**
 * 变成回文字符串
 * dp[][] 表示从i到j的字符串需要几个变成回文
 * 
 * @author caizongyu
 *
 */
public class MarkPalindromeString {
	/**
	 * 求dp矩阵
	 * @param s
	 * @return
	 */
	private static int[][] getDP(String s) {
		if(s == null) {
			return null;
		}
		int[][] dp = new int[s.length()][s.length()];
		char[] arr = s.toCharArray();
		
		for(int j=1;j<arr.length;j++) {
			dp[j-1][j] = arr[j-1]==arr[j]?0:1;
			for(int i=j-2;i>=0;i--) {
				if(arr[i]==arr[j]) {
					dp[i][j] = dp[i+1][j-1];
				}else {
					dp[i][j] = Math.min(dp[i+1][j],dp[i][j-1])+1;
				}
			}
		}
		return dp;
	}
	/**
	 * 通过dp信息求个回文字符串
	 * @param s
	 * @param dp
	 * @return
	 */
	private static String buildPalindromString(String s, int[][] dp) {
		char[] arr= s.toCharArray();
		int begin =0;
		int end = s.length()-1;
		
		char[] result = new char[s.length()+dp[0][s.length()-1]];
		int indexBegin=0;
		int indexEnd=result.length-1;
		while(begin<=end) {
			//copy
			if(arr[begin] == arr[end]) {
				result[indexBegin++]=arr[begin++];
				result[indexEnd--] =arr[end--];
			}else if(dp[begin][end-1]<dp[begin+1][end]){
				result[indexBegin++]=arr[end];
				result[indexEnd--] = arr[end--];
			}else if(dp[begin][end-1]>dp[begin+1][end]) {
				result[indexBegin++] = arr[begin];
				result[indexEnd--] = arr[begin++];
			}
		}
		return new String(result);
	}
	public static void main(String[] args) {
		String s ="ABACSD";
		int[][] arr=getDP("ABACSD");
		for(int i=0;i<arr.length;i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println(buildPalindromString(s, arr));
		
	}
}
