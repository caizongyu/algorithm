package com.zuochengyun.book.chapterfive.string;
/**
 * 判断两个字符串是否互旋
 * 123 的互旋词  123  312 231   
 * @author caizongyu
 *
 */
public class JudgeTwoStringMutualRotation {
	//思路   b+b 会包含a 则为互璇
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
