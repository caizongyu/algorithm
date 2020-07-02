package com.zuochengyun.book.chapterfive.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 判断两个字符串是否互为变形词
 * 变形词：每种字符出现的次数一样
 * @author caizongyu
 *
 */
public class JudgeTwoStringMorpheme {
	private static boolean judgeMorpheme(String s1,String s2) {
		if(s1 == null || s2 == null) {
			return false;
		}
		//长度不同
		if(s1.length()!=s2.length()) {
			return false;
		}
		char[] char1 = s1.toCharArray();
		char[] char2 = s2.toCharArray();
		Map<Character, Integer> map = new HashMap<>();
		for(int i=0;i<char1.length;i++) {
			if(map.get(char1[i]) == null) {
				map.put(char1[i], 1);
			}else {
				map.put(char1[i], map.get(char1[i])+1);
			}
		}
		for(int i=0;i<char1.length;i++) {
			if(map.get(char2[i]) == null || map.get(char2[i]) == 0) {
				
				return false;
			}
			map.put(char2[i], map.get(char2[i])-1);
		}
		for(Integer one:map.values()) {
			if(one.intValue()!=0) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		System.out.println(judgeMorpheme("", ""));
	}
}
