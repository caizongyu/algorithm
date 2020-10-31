package com.zuochengyun.bool.chapterthree.tree;

import apple.laf.JRSUIUtils;

import java.util.HashMap;
import java.util.Map;

public class BuilderTreeByAfterMediaArr {
    public static TreeNode build(int[] after, int[] media){
        if(after == null || media == null){
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i< media.length;i++){
            map.put(media[i], i);
        }
        return null;
    }
    private static TreeNode afterIn(int[] after, int ai, int aj, int[] media, int mi, int mj, Map<Integer, Integer> map){
        if(ai> aj){
            return null;
        }
        TreeNode head = new TreeNode(after[aj]);
        int headInMeadiIndex = map.get(after[aj]);
        head.right = afterIn(after, aj-1,aj - headInMeadiIndex + mj , media, headInMeadiIndex+1, mj, map);
        head.left =  afterIn(after, ai, ai+ headInMeadiIndex - mi-1,media, mi, headInMeadiIndex-1, map);
        return head;
    }

}
