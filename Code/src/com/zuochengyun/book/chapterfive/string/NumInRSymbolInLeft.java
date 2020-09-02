package com.zuochengyun.book.chapterfive.string;

public class NumInRSymbolInLeft {
	private static String doExchange(String s) {
		if(s == null || s.length()<1) {
			return null;
		}
		
		int countSymbol =0;
		char[] arr=s.toCharArray();
		int index =0;
		int numIndex = arr.length-1;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]=='*') {
				countSymbol++;
			}
		}
		for(int i=arr.length-1;i>=0;i--) {
			if(arr[i]!='*') {
				arr[numIndex--]=arr[i];
			}
		}
		for(int i=0;i<countSymbol;i++) {
			arr[i]='*';
		}
	
		return new String(arr);
	}
	private static void swap(char[] arr, int a,int b) {
		char temp = arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}
	public static void main(String[] args) {
		System.out.println(doExchange("12**345"));
	}
}
