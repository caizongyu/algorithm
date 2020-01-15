package com.dynamic;

import java.util.Arrays;

/**
 * 
 * @author caizongyu
 * 音箱 笔记本和吉他     4k背包最大价值   
 */
public class BookSimpleDynamic {
	private static String[] name = {"yinxiang","mac book air","guitar"};
	private static int[] value= {3000,2000,1500};
	private static int[] weight = {4,3,1};
	private static int[][] array;
	private static int bag=4;
	private static void init(){
		array = new int[name.length][bag];
		for(int i=0;i<array[0].length;i++) {
			if(i+1>=weight[0]) {
				array[0][i] = value[0];
			}
		}
	}
	/*
	 * 输出数组
	 */
	private static void showArray() {
		for(int i=0;i<array.length;i++){
			System.out.println(Arrays.toString(array[i]));
		}
		
	}
	private static void doSimpleDynamic() {
		int spaceValue=0;
		for(int i =1;i<array.length;i++) {
			for(int j=0;j<array[0].length;j++) {
				//计算剩余空间的价值
				spaceValue = weight[i]<=j?array[i-1][j-weight[i]]:0;
				//计算当前价值  = Max(未加入当前物件的最优解,当前价值+剩余空间价值) 
				array[i][j] = array[i-1][j] > value[i]+spaceValue ? array[i-1][j]:value[i]+spaceValue;
			}
		}
	}
	public static void main(String[] args) {
		init();
		doSimpleDynamic();
		showArray();
	}
}
