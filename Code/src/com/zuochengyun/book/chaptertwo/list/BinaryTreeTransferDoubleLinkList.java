package com.zuochengyun.book.chaptertwo.list;

import java.util.LinkedList;
import java.util.Queue;

import com.utils.TreeNode;

/**
 * 将一个二叉树变成双向链表
 * @author caizongyu
 *
 */
public class BinaryTreeTransferDoubleLinkList {
	/**
	 *  time o(n)  space o(n)
	 *  利用队列来求解
	 * @param head
	 * @return
	 */
	private static TreeNode userQueue(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		if(root == null){
			return null;
		}
		treeIntoQueue(root, queue);
		TreeNode head = queue.peek();
		TreeNode pre = null;
		TreeNode current = null;
		while(!queue.isEmpty()) {
			current = queue.poll();
			current.left = pre;
			if(pre!=null) {
				pre.right = current;
			}
			pre = current;
		}
		current.right = null;
		return head;
	}
	private static void treeIntoQueue(TreeNode root, Queue queue) {
		if(root==null) {
			return;
		}
		treeIntoQueue(root.left, queue);
		queue.offer(root);
		treeIntoQueue(root.right, queue);
	}
	/**
	 * time o(n) space o(h) h为二叉树的高度
	 * @return
	 */
	private static TreeNode userRecursion(TreeNode head) {
		if(head == null) {
			return null;
		}
		TreeNode last = process(head);
		
		return null;
	}
	/**
	 * 将
	 * @param node
	 * @return
	 */
	private static TreeNode process(TreeNode root) {
		if(root == null) {
			return null;
		}
		TreeNode left =process(root.left);
		TreeNode right = process(root.right);
		TreeNode leftR = left == null? null:left.right;
		TreeNode rightR = right == null? null:right.right;
		if(right!=null && left != null) {
			left.right = root;
			root.left = left;
			
			//add
		

		}else if(right!=null) {
			right.right = root;
			root.right = right;
			right.left = root;
			return root;
			
		}else if(left != null) {
			left.right = root;
			root.left = left;
			root.right = leftR;
			return root;
			
		}else if(right == null && left == null) {
			root.right = root;
			return root;
		}
		return null;
	}
	
}
