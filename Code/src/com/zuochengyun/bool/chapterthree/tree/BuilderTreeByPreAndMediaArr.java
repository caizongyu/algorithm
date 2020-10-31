package com.zuochengyun.bool.chapterthree.tree;

import com.zuochengyun.book.chaptertwo.list.Node;

import java.util.HashMap;

public class BuilderTreeByPreAndMediaArr {
    private static TreeNode build(int[] pre, int[] media){
        if(pre == null || media == null){
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<media.length;i++){
            map.put(media[i],i);
        }

        return preIn(pre, 0, pre.length-1, media, 0,media.length-1, map);
    }

    /**
     *
     * @param pre
     * @param pi
     * @param pj
     * @param media
     * @param ni
     * @param nj
     * @param map
     * @return
     */
    public static TreeNode preIn(int[] pre, int pi, int pj, int[] media, int ni, int nj, HashMap<Integer, Integer> map){
        if(pi>pj){
            return null;
        }
        //从前序数组中获取头节点
        TreeNode head  = new TreeNode(pre[pi]);
        //root 结点在中序数组中的位置
        int mediaHeadIndex  = map.get(head.value);
        head.left = preIn(pre, pi +1, pi+mediaHeadIndex-ni, media, ni, mediaHeadIndex-1, map);
        head.right = preIn(pre, pi+mediaHeadIndex-ni +1, nj, media, mediaHeadIndex+1, nj, map);
        return head;
    }

}
