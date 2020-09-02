package com.zuochengyun.book.chapterfive.string;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 给定一个字符串str，如果符合日志书写的整数形式，不符合返回0
 * @author caizongyu
 *
 */
public class IntegeStringParseToInteger {
	private static int doJudge(String s) {
		if(s.length()==0 || s.length()>10) {
			return 0;
		}
		if(s.length()>1 && s.charAt(0)=='0') {
			return 0;
		}
		if(s.length()==10 && s.compareTo("2147483647")>1) {
			return 0;
		}
		if(s.length() == 1 && s.equals("-")) {
			return 0;
		}
		if(s.charAt(0)<'0' || s.charAt(0)>'9') {
			if(s.charAt(0) != '-') {
				return 0;
			}
		}
		for(int i=1;i<s.length();i++) {
			if(s.charAt(i) < '0' || s.charAt(i) > '9') {
				return 0;
			}
		}
		return Integer.parseInt(s);
	}
	public static void main(String[] args) {
		//String s="-2147483647";
		//System.out.println(doJudge(s));
		LinkedHashMap<String, String> map = new LinkedHashMap<>();
		map.put("123", "123");
		map.put("124", "g");
		map.put("129", "ggg");
		System.out.println(map.toString());
		map.get("123");
		System.out.println(map.toString());
	}
	
}
