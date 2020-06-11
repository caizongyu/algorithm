package com.zuochengyun.book.chapterfour.dynamic;
/**
 * 矩阵最小路径和
 * 给定一个矩阵m，从左上角开始每次只能向右或者向下走，返回所有路径中最小的路劲和。
 *经典dp题
 * @author caizongyu
 *
 */
public class MatruxMinPathSum {
	/*
	 * 常规打表的办法
	 */
	private static int getMinPath(int[][] arr) {
		if(arr == null) {
			return -1;
		}
		int[][] tmp = new int[arr.length][arr[0].length];
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				if(i ==0 && j==0) {
					tmp[i][j] = arr[i][j];
					continue;
				}
				if(i==0) {
					tmp[i][j] = tmp[i][j-1]+arr[i][j];
					continue;
				}
				if(j ==0) {
					tmp[i][j] = tmp[i-1][j] + arr[i][j];
					continue;
				}
				tmp[i][j] = (tmp[i-1][j]<tmp[i][j-1]?tmp[i-1][j]:tmp[i][j-1])+ arr[i][j];
			}
		}
		return tmp[arr.length-1][arr[0].length-1];
	}
	/**
	 * 优化算法 压缩空间
	 * 只用一维数组  取行列最小值长度
	 * @return
	 */
	private static int getMinPathUpdate(int[][] arr) {
		if(arr == null) {
			return -1;
		}
		int more = Math.max(arr.length, arr[0].length);
		int less = Math.min(arr.length, arr[0].length);
		int[] tmp = new int[less];//辅助数组
		boolean rowmore = (more == arr.length);
		tmp[0] = arr[0][0];
		for(int i = 1;i<less;i++) {
			tmp[i] = tmp[i-1] + (rowmore? arr[0][i]: arr[i][0]);//对行和列 少的做操作
		}
		for(int i = 1;i<more;i++) {
			tmp[0] = tmp[0]+(rowmore?arr[0][i]:arr[i][0]);//改变tmp第一个值
			for(int j=1;j<less;j++) {
				tmp[j] = Math.min(tmp[j], tmp[j-1]) + (rowmore?arr[i][j]:arr[j][i]);
			}
		}
		return tmp[less-1];
	}
	public static void main(String[] args) {
		int[][] arr = {{1,3,5,9},{8,1,3,4},{5,0,6,1},{8,8,4,0}};
		System.out.println(getMinPathUpdate(arr));
	}
}
