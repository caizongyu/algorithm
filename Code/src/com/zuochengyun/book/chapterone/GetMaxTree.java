package com.zuochengyun.book.chapterone;

import java.util.Arrays;
import java.util.Stack;

/**
 * ����MaxTree
 * maxtree   ����û���ظ�Ԫ�� ������������ͷ�����ӽڵ��
 * ����ؼ�������ջ�ҵ�һ������ߺ��ұ߱��������
 * @author caizongyu
 *
 */
public class GetMaxTree {
	private static Node[] nodes;
	private static Stack<Integer> stack;
	private static int[] parentIndexs;
	private static int headIndex;
	private static void init(int[] arr) {
		if(arr ==null) {
			return;
		}
		nodes=new Node[arr.length];
		stack = new Stack<>();
		headIndex = -1;
		parentIndexs = new int[arr.length];
		for(int i= 0;i<arr.length;i++) {
			parentIndexs[i] = -1;
			nodes[i]=new Node(arr[i]);
		}
		
	}
	private static void doBuildTree() {
		if(nodes == null || stack == null || parentIndexs == null) {
			return;
		}
		//�ҵ�һ��������ߵ�һ�����������
		for(int i=0;i<nodes.length;i++) {
			while(!stack.isEmpty() && nodes[stack.peek()].value < nodes[i].value) {
				stack.pop();
			}
			if(!stack.isEmpty()) {
				parentIndexs[i] = stack.peek();
			}	
			stack.push(i);
		}
		stack.clear();
		//�ҵ��ұ�
		for(int i=nodes.length-1;i>=0;i--) {
			while(!stack.isEmpty() && nodes[stack.peek()].value < nodes[i].value) {
				stack.pop();
			}
			if(!stack.isEmpty() && (parentIndexs[i] == -1|| nodes[stack.peek()].value < nodes[parentIndexs[i]].value)) {
				parentIndexs[i] = stack.peek();
			}	
			stack.push(i);
		}
	}
	private static int getHeadIndex() {
		if(parentIndexs ==null) {
			return -1;
		}
		for(int i=0;i<parentIndexs.length;i++) {
			if(parentIndexs[i]==-1) {
				return i;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		int[] arr= {3,4,5,1,2};
		init(arr);
		doBuildTree();
		getHeadIndex();
		System.out.println(Arrays.toString(parentIndexs));
	}
}
class Node{
	public int value;
	public Node left;
	public Node right;
	public Node(int value) {
		this.value = value;
	}
}