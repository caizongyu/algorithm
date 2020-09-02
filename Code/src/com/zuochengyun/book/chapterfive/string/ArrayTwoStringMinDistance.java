package com.zuochengyun.book.chapterfive.string;
/**
 * 求数组中两个字符串的最小距离
 * @author caizongyu
 *
 */
public class ArrayTwoStringMinDistance {
	private static int getResult(String[] s, String s1,String s2) {
		if(s == null || s1==null || s2==null) {
			return -1;
		}
		if(s1.equals(s2)) {
			return 0;
		}
		int lastS1=-1;
		int lastS2 =-1;
		int min=Integer.MAX_VALUE;
		for(int i=0;i<s.length;i++) {
			if(s[i].equals(s1)) {
				min =Math.min(lastS2 == -1?min:i-lastS2, min);
				lastS1=i;
				
			}
			if(s[i].equals(s2)){
				min = Math.min(lastS1 == -1?min:i-lastS1, min);
				lastS2 = i;
			}
		}
		
		return min == Integer.MAX_VALUE?-1:min;
	}
	public static void main(String[] args) {
		String s="1 3 3 3 2 3 1";
		String[] arr=s.split(" ");
		System.out.println(getResult(arr, "1", "2"));
	}
}
