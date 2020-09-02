package com.zuochengyun.book.chapterfive.string;

import java.util.Arrays;

/**
 *  һ���������ַ�������0����߱���1 �����ֵ�������NΪλ��
 * ͨ���󣬿ɷ��� f��n�� = f��n-1�� + f��n-2��
 * @author caizongyu
 *
 */
public class ZeroLeftHashOne {
	/**
	 * O(N)ʱ�临�Ӷ�
	 *
	 * @param n
	 * @return
	 */
	private static int getResult(int n) {
		if(n<1) {
			return 0;
		}
		if(n == 1) {
			return 1;
		}
		if(n == 2) {
			return 2;
		}
		int first =1;
		int second =2;
		int tmp=0;
		for(int i=3;i<=n;i++) {
			tmp  = first + second;
			first = second;
			second = tmp;
		}
		return second;
	}
	//���þ���ʽ-----------------
	/**
	 * ���������
	 * @return
	 */
	private static int[][] multiplicationMatrix(int[][] first, int[][] second){
		int[][] result = new int[2][2];
		for(int i=0; i<first.length;i++) {
			for(int j =0;j<second[0].length;j++) {
				for(int k=0;k<second.length;k++) {
					result[i][j] += first[i][k]*second[k][j]; 
				}
			}
		}
		return result;
	}
	private static int[][] matrixPower(int[][] base, int n) {
		int[][] res = new int[base.length][base[0].length];
		//��ʼ��Ϊ��λ����
		for(int i=0;i<base.length;i++) {
			res[i][i] = 1;
		}
		int[][] tmp =base;
		//������
		for(;n!=0;n>>=1) {
			if((n&1)!=0) {
				res = multiplicationMatrix(tmp, res);
			}
			tmp = multiplicationMatrix(tmp, tmp);
		}
		return res;
	}
	private static int getResult(int[][] base, int n) {
		if(n<1) {
			return 0;
		}
		if(n == 1 || n == 2) {
			return n;
		}
		//
		int[][] res = matrixPower(base, n-2);
		return 2 * res[0][0] + res[1][0];
	}
	/**
	 * ������
	 * @param base
	 * @param n
	 * @return
	 */
	private static int fastPower(int base, int n) {
		
		int res = 1;
		while(n!=0) {
			if((n&1)!=0) {
				res = base * res;
			}
			base = base * base;
			n=n>>1;
		}
		
		return res;
	}
	public static void main(String[] args) {
		//System.out.println(getResult(4));
		//int[][] first= {{1,2,4},{2,0,3}};
		//int[][] second = {{1,2},{3,2},{0,5}};
		//int[][] result =multiplicationMatrix(first, second);
		//for(int i=0;i<result.length;i++) {
		//	System.out.println(Arrays.toString(result[i]));
		//}
		
		System.out.println(fastPower(2,3));
		
	}
}
