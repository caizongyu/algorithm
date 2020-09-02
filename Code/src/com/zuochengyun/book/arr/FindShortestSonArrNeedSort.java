package com.zuochengyun.book.arr;

import java.util.Arrays;

/**
 * @ClassName : FindShortestSonArrNeedSort
 * @Description : 找出需要排序的最短子数组长度
 * @Author : caizongyu
 * @Date: 2020-08-27 11:22
 */
public class FindShortestSonArrNeedSort {
    public static int[] getRestul(int[] arr){
        if(arr == null){
            return null;
        }
        int[] indexs = doFind(arr);
        if(indexs == null){
            return arr;
        }
        return indexs;
    }
    public static int[] doFind(int[] arr){
        // indexs[0] = begin, indexs[1] = end
        int[] indexs = new int[2];
        int index = -1;
        int m = arr[0];
        for(int i=1;i<arr.length;i++){

            if(arr[i] < m){
                index = i;
            }
            m = Math.max(m, arr[i]);
        }
        if(index == -1){
            return null;
        }
        indexs[1] = index;
        index = -1;
        m=arr[arr.length-1];

        for(int i=arr.length-2;i>=0;i--){

            if(arr[i] > m){
                index = i;
            }
            m = Math.min(m, arr[i]);
        }
        indexs[0] = index;
        return indexs;
    }

    public static void main(String[] args) {
        int[] arr ={1,5,3,4,2,6,7};
        System.out.println(Arrays.toString(getRestul(arr)));
    }
}
