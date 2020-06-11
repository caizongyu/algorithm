package com.utils;

public class TreeUtil {
	public static TreeNode getFiveNodeTree() {
		TreeNode[] nodes = new TreeNode[5];
		for(int i=0;i<5;i++) {
			nodes[i] = new TreeNode(i);
		}
		nodes[0].left = nodes[1];
		nodes[0].right = nodes[2];
		nodes[1].left = nodes[3];
		nodes[2].right = nodes[4];
		return nodes[0];
	}
}
