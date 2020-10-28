package com.zuochengyun.bool.chapterthree.tree;

/**
 * @ClassName : TreeDeepth
 * @Description : 树的高度
 * @Author : caizongyu
 * @Date: 2020-10-28 15:59
 */
public class TreeDeepth {
    /**
     * 使用了递归方法，
     * @param treeNode
     * @return
     */
    public static int methodReturn(TreeNode treeNode){
        if(treeNode == null){
            return  0;
        }
        return Math.max(methodReturn(treeNode.left), methodReturn(treeNode.right));
    }

    /**
     * 使用回溯的方法
     * @return
     */
    private static int cur = 0;
    private static int max = 0;
    public static int methodRevert(TreeNode root){
        if(root == null){
            return max;
        }
        cur++;
        max = Math.max(max, cur);
        methodRevert(root.left);
        methodRevert(root.right);
        cur--;
        return max;
    }
}
