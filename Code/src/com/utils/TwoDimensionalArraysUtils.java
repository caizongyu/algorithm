package com.utils;

import java.util.Arrays;

public class TwoDimensionalArraysUtils {
	public static void print(int[][] arr) {
		if(arr == null) {
			return;
		}
		for(int i=0;i<arr.length;i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
	}
}
