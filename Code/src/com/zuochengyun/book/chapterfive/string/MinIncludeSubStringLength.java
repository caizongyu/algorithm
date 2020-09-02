package com.zuochengyun.book.chapterfive.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 最小包含子串所有字符的长度 s1="abcdf" s2 = "ac" length = 3
 * 
 * @author caizongyu
 *
 */
public class MinIncludeSubStringLength {
	private static int getResult(String s1, String s2) {
		if (s1 == null || s2 == null || s1.length() <= 0 || s2.length() <= 0 || s2.length() > s1.length()) {
			return -1;
		}
		char[] arr1 = s1.toCharArray();
		char[] arr2 = s2.toCharArray();
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < arr2.length; i++) {
			map.put(arr2[i], map.get(arr2[i]) == null ? 1 : map.get(arr2[i]) + 1);
		}
		int match = arr2.length;
		int left = 0, right = 0;
		int result = Integer.MAX_VALUE;
		while (right < arr1.length) {

			if (map.get(arr1[right]) == null || map.get(arr1[right]) <= 0) {
				map.put(arr1[right], map.get(arr1[right]) == null ? -1 : map.get(arr1[right]) - 1);
				right++;
				continue;
			}
			map.put(arr1[right], map.get(arr1[right]) - 1);
			match--;
			right++;
			if (match == 0) {
				while (map.get(arr1[left]) < 0 && left < right) {
					left++;
					
				}
				result = Math.min(result, right - left);
			}
		}
		// add left

		return result == Integer.MAX_VALUE ? 0 : result;
	}

	public static void main(String[] args) {
		String s1 = "122345";
		String s2 = "223";
		System.out.println(getResult(s1, s2));
	}
}
