package com.zuochengyun.book.chapterfive.string;
/**
 * ��һ���ַ�����������֮��
 * 1.����С���� 1.3��Ϊ1 �� 3
 * 2.���ַ��ŵĴ���  -1 Ϊ-1��--1λ1
 * @author caizongyu
 *
 */
public class StringAllNumSum {
	private static int getSum(String s) {
		if(s==null || s.length()<=0) {
			return 0;
		}
		char[] arr = s.toCharArray();
		int sum=0;
		//-���ִ���
		int pre=0;
		String currentNum = "";
		for(int i=0;i<arr.length;i++) {
			if(arr[i] == '-') {
				sum += stringToInt(currentNum);
				currentNum = "";
				++pre;
				continue;
			}
			if(arr[i]>= '0' && arr[i]<='9') {
				if((pre&1) == 1) {
					currentNum = "-";
					pre =0;
				}
				currentNum = currentNum + arr[i];
				//���һ��Ϊ���ֵ�ʱ��currentNum����
				if(i==arr.length-1) {
					sum +=stringToInt(currentNum);
				}
				continue;
			}
			sum +=stringToInt(currentNum);
			currentNum = "";
			pre=0;
			
		}
		
		return sum;
		
	}
	private static int stringToInt(String s) {
		if(!s.equals("")) {
			return Integer.parseInt(s);
		}
		return 0;
	}
	public static void main(String[] args) {
		//String s ="A1CD2E33";
		String s ="A-01B--02C--D6E";
		System.out.println(getSum(s));
		
	}
}
