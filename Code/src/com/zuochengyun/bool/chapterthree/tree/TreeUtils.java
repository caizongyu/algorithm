package com.zuochengyun.bool.chapterthree.tree;

public class TreeUtils {
	public static TreeNode creteTree() {
		TreeNode  root = new TreeNode(0);
		TreeNode left1 = new TreeNode(1);
		TreeNode right1= new TreeNode(2);
		root.left = left1;
		root.right = right1;
		return root;
	}
	
}
