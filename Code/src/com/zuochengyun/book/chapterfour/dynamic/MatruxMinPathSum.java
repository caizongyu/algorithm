package com.zuochengyun.book.chapterfour.dynamic;
/**
 * ������С·����
 * ����һ������m�������Ͻǿ�ʼÿ��ֻ�����һ��������ߣ���������·������С��·���͡�
 *����dp��
 * @author caizongyu
 *
 */
public class MatruxMinPathSum {
	/*
	 * ������İ취
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
	 * �Ż��㷨 ѹ���ռ�
	 * ֻ��һά����  ȡ������Сֵ����
	 * @return
	 */
	private static int getMinPathUpdate(int[][] arr) {
		if(arr == null) {
			return -1;
		}
		int more = Math.max(arr.length, arr[0].length);
		int less = Math.min(arr.length, arr[0].length);
		int[] tmp = new int[less];//��������
		boolean rowmore = (more == arr.length);
		tmp[0] = arr[0][0];
		for(int i = 1;i<less;i++) {
			tmp[i] = tmp[i-1] + (rowmore? arr[0][i]: arr[i][0]);//���к��� �ٵ�������
		}
		for(int i = 1;i<more;i++) {
			tmp[0] = tmp[0]+(rowmore?arr[0][i]:arr[i][0]);//�ı�tmp��һ��ֵ
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
