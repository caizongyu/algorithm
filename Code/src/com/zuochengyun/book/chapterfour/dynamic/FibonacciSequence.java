package com.zuochengyun.book.chapterfour.dynamic;
/**
 * 斐波拉契数列 F（n） = F（n-1）+F（n-2）
 * 这边通用公式是一个二阶递推数列，一定可以用矩阵乘法的形式表示，且状态矩阵为2x2的矩阵。

（F(n）,F(n-1)) =(F(n-1),F(n-2)) x 二阶矩阵 = （1，1） * 二阶矩阵的 n-2次方
这样求数列第N项的问题就变成了求一个矩阵的N次方问题，这是一个能在O（logN）时间内解决的问题。
 * @author caizongyu
 *
 */
public class FibonacciSequence {
	private static int fibonacciSequenceRecursion(int n) {
		if(n <= 0) {
			return 0;
		}
		if(n <= 2) {
			return 1;
		}
		return fibonacciSequenceRecursion(n-1) + fibonacciSequenceRecursion(n-2);
	}
	private static int whileFibonacciSequenceRecursion(int n) {
		if(n <= 0) {
			return 0;
		}
		if(n<=2) {
			return 1;
		}
		int pre =1;
		int after = 1;
		int current =1;
		for(int i=3;i<=n;i++) {
			current = pre + after;
			pre = after;
			after = current;
		}
		return current;
	}
	/*
	 * 求矩阵m的p次方
	 */
	private static int[][] matrixPower(int[][] m,int p){
		int[][] res = new int[m.length][m[0].length];
		for(int i = 0;i<res.length;i++) {
			for(int j=0;j<res[0].length;j++) {
				res[i][j] = 1;
			}
			
		}
		int[][] tmp = m;
		//做p次
		for(;p!=0;p>>= 1) {
			if((p&1) != 0) {
				res = muliMatrix(res,tmp);
			}
			tmp = muliMatrix(tmp,tmp);
		}
		return null;
	}
	/**
	 * 两矩阵相乘
	 * @param ml
	 * @param m2
	 * @return
	 */
	private static int[][] muliMatrix(int[][] m1,int[][] m2){
		//结果矩阵的行数等于m1的行数，列数的m2的列数
		int [][] res= new int[m1.length][m2[0].length];
		for(int i=0;i < m2[0].length;i++) {
			for(int j = 0;j< m1.length;j++) {
				for(int k=0;k<m2.length;k++) {
					res[i][j] += m1[i][k]*m2[k][j];
				}
			}
		}
		return res;
	
	}
	private static int userMatrixFibonacciSequenceRecursion(int n) {
		if(n<1) {
			return 0;
		}
		if(n ==1 || n ==2) {
			return 1;
		}
		int[][] base = {{1,1},{1,0}};
		int[][] res = matrixPower(base, n-2);
		return res[0][0]+res[1][0];
	}
	public static void main(String[] args) {
		System.out.println(whileFibonacciSequenceRecursion(4));
	}
}
