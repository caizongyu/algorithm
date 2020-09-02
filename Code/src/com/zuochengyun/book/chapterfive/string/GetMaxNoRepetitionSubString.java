package com.zuochengyun.book.chapterfive.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 求字符串最大的连续不重复子串
 * @author caizongyu
 *
 */
public class GetMaxNoRepetitionSubString {
	private static int getResult(String s) {
		if(s == null) {
			return -1;
		}
		char[] arr= s.toCharArray();
		Map<Character,Integer> map = new HashMap<>(s.length());
		int result =0;
		int begin=0;
		for(int i=0;i<arr.length;i++) {
			if(map.get(arr[i])!=null && begin<=map.get(arr[i])) {
				begin = map.get(arr[i])+1;
			}
			map.put(arr[i], i);
			result = Math.max(result, i-begin+1);
		}
		return result;
	}
	public static void main(String[] args) {
		System.out.println(getResult("abacd"));
		System.out.println(getResult("aabb"));
	}
}
