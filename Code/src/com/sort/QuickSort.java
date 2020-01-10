package com.sort;

import java.util.Arrays;

/*
 * ¿ìËÙÅÅĞò
 */
public class QuickSort {
	void doSort(int begin, int end, int[] arr){
		int base = arr[begin];
		int oldBegin = begin;
		int oldEnd = end;
		while(begin < end) {
			while(begin < end && base <= arr[end]) {
				--end;
			}
			swap(begin, end , arr);
		
			while(begin < end && base >= arr[begin]) {
				++begin;
			}
		
			swap(begin, end ,arr);
		
		}
		if(oldBegin < begin -1) {
			doSort(oldBegin, begin - 1, arr);
		}
		if(begin + 1 < oldEnd) {
			doSort(begin+1, oldEnd, arr);
		}
	 
	}
	void swap(int indexa, int indexb, int[] arr) {
		int temp = arr[indexa];
		arr[indexa] = arr[indexb];
		arr[indexb] = temp;
	}
	
	public static void main(String[] args) {
		int[] arr= {4};
		new QuickSort().doSort(0, arr.length-1, arr);
		System.out.println( Arrays.toString(arr));
		
	}
}
