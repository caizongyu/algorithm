package com.zuochengyun.bool.chapterthree.tree;

import java.util.Stack;

public class IteratorTree {
	/*
	 * 	ǰ��ݹ�
	 */
	private static void PreorderErgodicRecursion(TreeNode root) {
		if(root == null) {
			return;
		}
		System.out.println(root.value);
		PreorderErgodicRecursion(root.left);
		PreorderErgodicRecursion(root.right);
	}
	/*
	 * ǰ��for
	 */
	private static void WhilePreorderErgodicRecursion(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		if(root == null) {
			return;
		}
		TreeNode tmp = null;
		while(!stack.isEmpty()) {
			tmp = stack.pop();
			System.out.print(tmp.value+ " ");
			if(tmp.right!=null) {
				stack.add(tmp.right);
			}
			if(tmp.left!=null) {
				stack.add(tmp.left);
			}
			
		}
	}
	/*
	 * ����ݹ�
	 */
	private static void MiddleErgodicRecurdsion(TreeNode root) {
		MiddleErgodicRecurdsion(root.left);
		System.out.println(root.value);
		MiddleErgodicRecurdsion(root.right);
	}
	/*
	 * ����ѭ��
	 */
	private static void WhileMiddleErgodicRecurdsion(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		if(root == null) {
			return;
		}
		while(!stack.isEmpty() || root !=null) {
			if(root != null) {
				stack.push(root);
				root = root.left;
			}else {
				root = stack.pop();
				System.out.print(root.value + " ");
				root = root.right;
			}
			
		}
		
	}
	/**
	 * ����ݹ�
	 * @param root
	 */
	private static  void PostorderErgodicRecurdsion(TreeNode root) {
		if(root == null) {
			return;
		}
		PostorderErgodicRecurdsion(root.left);
		PostorderErgodicRecurdsion(root.right);
		System.out.println(root.value);
	}
	/*
	 * ����ѭ��
	 * ʹ��������ջ��
	 */
	private static void WhilePostorderErgodicRecurdsion(TreeNode root) {
		if(root == null) {
			return;
		}
		
		Stack<TreeNode> stack1 = new Stack<>();
		Stack<TreeNode> stack2 =new Stack<>();
		stack1.add(root);
		TreeNode tmp = null;
		while(!stack1.isEmpty()) {
			tmp = stack1.pop();
			if(tmp.left!= null) {
				stack1.add(tmp.left);
			}
			if(tmp.right!=null) {
				stack1.add(tmp.right);
			}
			stack2.add(tmp);
		}
		while(!stack2.isEmpty()) {
			System.out.print(stack2.pop()+ " ");
		}
		
	}
	public static void main(String[] args) {
		TreeNode root = TreeUtils.creteTree();
		WhilePreorderErgodicRecursion(root);
	}
}
