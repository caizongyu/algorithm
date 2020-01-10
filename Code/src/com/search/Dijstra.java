package com.search;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 
 * @author caizongyu
 * Dijstra 算法
 */
public class Dijstra {
	//邻接矩阵
	private static final int[][] GMAP = {
			{-1,5,-1,7,15},
			{-1,-1,5,-1,-1},
			{-1,-1,-1,-1,1},
			{-1,-1,2,-1,-1},
			{-1,-1,-1,-1,-1}
			};
	//记录起点到某个节点的临时的最短距离
	private static final int distance[] =new int[GMAP.length];
	
	private static int pre[] =new int[GMAP.length];
	static int beginIndex = 0;
	static int endIndex = 4;
	public static void main(String[] args) {
		init();
		
	}
	//初始化 distance[] 和 pre[] 
	private static void init() {
		//init distace
		for (int i = 0;i<GMAP.length;i++) {
			if(i == beginIndex) {
				distance[i] = 0;
				continue;
			}
			distance[i] = Integer.MAX_VALUE;
		}
		
		//init pre[]
		for(int i=0;i<GMAP.length;i++) {
			pre[i] = -1;
		}
	}
	static void doDijsktra(){
		//用来保存尚待搜索的节点
		Queue<Integer> queue =new ArrayDeque<>();
		//放入起点
		queue.add(beginIndex);
		
		while(queue.size() != 0) {
			Integer currentIndex =queue.poll();
			//获取邻居节点
			List<Integer> neigberList = getNeighberIndex(currentIndex);
			for(int i=0;i<neigberList.size();i++) {
				//经过当前节点到相邻节点的距离  和 直接到相邻节点的距离比较
				if(distance[currentIndex] + getDistance(currentIndex, neigberList.get(i)) < distance[neigberList.get(i)]) {
					
				}
			}
		}
		
	}
	private static int getDistance(Integer currentIndex, Integer targetIndex) {
		
		return GMAP[currentIndex][targetIndex];
	}
	private static List<Integer> getNeighberIndex(Integer currentIndex){
		List<Integer> list =new ArrayList<>();
		for(int i =0;i<GMAP[currentIndex].length;i++) {
			if(GMAP[currentIndex][i]!= -1) {
				list.add(i);
			}
		}
		return list;
	} 
}
