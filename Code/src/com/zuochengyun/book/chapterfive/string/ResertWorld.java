package com.zuochengyun.book.chapterfive.string;
/**
 * ÄæÖÃµ¥´Ê
 * dog is animal ±ä³É animal is dog
 * @author caizongyu
 *
 */
public class ResertWorld {
	private static String doReserrt(String s) {
		if(s == null || s.length()<=1) {
			return s;
		}
		char[] arr= s.toCharArray();
		//resert all
		resertPart(arr,0,arr.length-1);
		System.out.println(arr);
		int begin=-1;
		int end =-1;
		//resert each one
		for(int i=0;i<arr.length;i++) {
			if(arr[i]!=' ' && begin<0) {
				begin = i;
			}
			if(arr[i]==' ' && begin>=0) {
				resertPart(arr, begin, i-1);
				begin = -1;
			}
		}
		if(begin>0) {
			resertPart(arr, begin, arr.length-1);
		}
		return new String(arr);
		
	}
	private static void resertPart(char[] arr, int begin, int end) {
		while(end>begin) {
			swap(arr,begin++,end--);
		}
	}
	private static void swap(char[] arr,int a,int b) {
		char temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	public static void main(String[] args) {
		String s ="dog loves pig";
		System.out.println(doReserrt(s));
	}
}
