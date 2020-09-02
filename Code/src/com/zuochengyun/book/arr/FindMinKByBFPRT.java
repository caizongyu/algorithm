package com.zuochengyun.book.arr;

import java.util.Arrays;

/**
 * @ClassName : FindMinKByBFPRT
 * @Description : 找到最小k个数  o（n）解法 BFPRT算法
 * @Author : caizongyu
 * @Date: 2020-08-24 20:39
 */
public class FindMinKByBFPRT {
    public void getRestul(int[] arr, int k){
        if(arr == null || k<1 || k>arr.length){
            return;
        }

    }
    private static int selection(int[] arr, int begin, int end, int k){
        int median = medianInArr(arr,begin, end);
        int[] range = partition(arr, begin,end,median);
        if(k>= range[0] && k<= range[0]+range[1]-1){
            return range[0];
        }
        if(k< range[0]){
            return selection(arr, begin, range[0]-1, k);
        }
        if(k> range[0] + range[1] - 1){
            return selection(arr, range[0]+range[1], end, k);
        }
        return -1;
    }
    /**
     * 得到数组的中位数
     * @param arr
     * @param begin
     * @param end
     * @return
     */
    private static int medianInArr(int[] arr, int begin, int end){
        int count = end-begin+1;
        int[] medians = new int[count/5 + count%5==0?0:1];
        int left = begin;
        for(int i=0;i<medians.length;i++){
            if(i == medians.length-1){
                    Arrays.sort(arr, left, end+1);
                    medians[i] = arr[left +(end + 1- left)>>1];
            }
            Arrays.sort(arr, left, left + 5);
            medians[i] = arr[left + 2];
            left = left +5;
        }
        return medians[medians.length >> 1];
    }
    /**
     * 将小于数组的数字放在左边，大于放在右边，并记录value的个数
     * @param arr
     * @param begin
     * @param end
     * @param value
     * @return
     */
    private static int[] partition(int[] arr, int begin, int end, int value){
        int left = begin;
        int right = end;
        int cur = begin;
        int valueCount = 0;

        while(left <= right){
            if(arr[left] < value){
                arr[cur++] = arr[left++];
                continue;
            }
            if(arr[left] == value){
                left++;
                valueCount++;
                continue;
            }
            if(arr[left] > value){
                swap(arr, left, right--);
            }
        }
        int[] sameRange = new int[2];
        sameRange[0] = cur;
        sameRange[1] = cur + valueCount;
        return sameRange;
    }
    private static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a]= arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int[] arr ={1,5,6,3,2,4,8,7,9,10};
        //partition(arr, 0,arr.length-1, 4);
        System.out.println(Arrays.toString(arr));
        System.out.println(medianInArr(arr, 0, arr.length-1));

    }
}
