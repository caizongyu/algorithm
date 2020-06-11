package com.zuochengyun.book.chapterfour.dynamic;
/**
 * 쳲��������� F��n�� = F��n-1��+F��n-2��
 * ���ͨ�ù�ʽ��һ�����׵������У�һ�������þ���˷�����ʽ��ʾ����״̬����Ϊ2x2�ľ���

��F(n��,F(n-1)) =(F(n-1),F(n-2)) x ���׾��� = ��1��1�� * ���׾���� n-2�η�
���������е�N�������ͱ������һ�������N�η����⣬����һ������O��logN��ʱ���ڽ�������⡣
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
	 * �����m��p�η�
	 */
	private static int[][] matrixPower(int[][] m,int p){
		int[][] res = new int[m.length][m[0].length];
		for(int i = 0;i<res.length;i++) {
			for(int j=0;j<res[0].length;j++) {
				res[i][j] = 1;
			}
			
		}
		int[][] tmp = m;
		//��p��
		for(;p!=0;p>>= 1) {
			if((p&1) != 0) {
				res = muliMatrix(res,tmp);
			}
			tmp = muliMatrix(tmp,tmp);
		}
		return null;
	}
	/**
	 * ���������
	 * @param ml
	 * @param m2
	 * @return
	 */
	private static int[][] muliMatrix(int[][] m1,int[][] m2){
		//����������������m1��������������m2������
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
