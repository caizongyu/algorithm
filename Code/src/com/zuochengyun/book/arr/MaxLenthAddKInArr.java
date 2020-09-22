package com.zuochengyun.book.arr;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : MaxLenthAddKInArr
 * @Description : 未排序数组中累加和为给定值正数k的最长子数组
 *               s 数组为累加和 s[j] - s[i] = s[i~j]
 * @Author : caizongyu
 * @Date: 2020-09-17 11:42
 */
public class MaxLenthAddKInArr {
    public static int doGetMaxLenth(int[] arr, int k) {
        if (arr == null) {
            return -1;
        }
        int sum = 0;
        int len = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1); //[1,2,3,3] k=6
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if(map.containsKey(sum-k)) {
                len = Math.max(len, i-map.get(sum-k)+1);
            }
            //记录sum 出现的第一次位置
            if(!map.containsKey(sum)){
                map.put(sum, i);
            }

        }
        return len;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,3};
        System.out.println(doGetMaxLenth(arr, 3));
    }

}
