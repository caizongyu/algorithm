package com.zuochengyun.book.chapterfive.string;
/**
 * �ж������ַ����Ƿ���
 * 123 �Ļ�����  123  312 231   
 * @author caizongyu
 *
 */
public class JudgeTwoStringMutualRotation {
	//˼·   b+b �����a ��Ϊ���
	private static boolean doJudge(String a, String b) {
		if(a==null || b==null || a.length()!=b.length()) {
			return false;
		}
		return (b+b).contains(a);
	}
	public static void main(String[] args) {
		System.out.println(doJudge("123", "312"));
	}
}
