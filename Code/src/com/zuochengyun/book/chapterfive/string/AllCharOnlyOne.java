package com.zuochengyun.book.chapterfive.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 判断chas[] 中所有的字符都只出现一次
 * hashmap
 * 堆排序
 */
public class AllCharOnlyOne {
    private static boolean userHash(char[] chas){
       if(chas == null || chas.length<=1){
           return true;
       }
        Map<Character, Integer> map = new HashMap<>();
       for(int i=0;i<chas.length;i++) {
           if(map.get(chas[i]) == null){
               map.put(chas[i],0);
               continue;
           }
           return false;
       }
        return true;
    }
    private static boolean userHeadSort(char[] chas){
        if(chas == null || chas.length<=1){
            return true;
        }
        Arrays.sort(chas);
        for(int i=1;i<chas.length;i++){
            if(chas[i] == chas[i-1]){
                return false;
            }
        }
        return true;
    }

}
