package com.redpackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.zuochengyun.book.chaptertwo.list.MyListUtils;

/**
 * ������Ķ�����ֵ��    ��ǰǮ��/��ǰ����*2
 * @author caizongyu
 *
 */
public class DoubleAvgMethod {
	/**
	 * 
	 * @param num ����
	 * @param money Ǯ��
	 * @return
	 */
	private static List<Integer> doRedPackage(int num, int money){
		List<Integer> result = new ArrayList<>();
		if(num <1 && money <0) {
			return null;
		}
		int currentNum = num;
		int currentMoney = money;
		int currentRedPackage=-1;
		Random random = new Random();
		while(currentNum > 1) {
			currentRedPackage = random.nextInt(currentMoney/currentNum*2+1);
			--currentNum;
			currentMoney =currentMoney-currentRedPackage;
			result.add(currentRedPackage);
		}
		result.add(currentMoney);
		return result;
	}
	public static void main(String[] args) {
		System.out.println(doRedPackage(5, 10).toString());
		String s="abc";
		System.out.println(s.hashCode());
		System.out.println("abc".hashCode());
				
	}
}
