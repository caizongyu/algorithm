package com.sort;

import java.util.Arrays;

/**
 * 希尔排序
 * 分组+插入排序
 * 直接插入排序的问题就在此：如果在后面来了一个特别小的元素，需要全部移动，那么排序的效率特别低
 */
public class ShellSort {
    public  static void doShellSort(int[] arr){
        if(arr == null || arr.length == 0){
            return;
        }
        for(int grap = arr.length/2;grap>=1;grap = grap/2){
            int i = grap;
            while(i-grap>=0 && i<arr.length){
                int j = i;
                while(j-grap>=0 && arr[j] < arr[j-grap]){
                    swap(arr, j, j-grap);
                    j=j-grap;
                }
                i++;
            }
        }
    }
    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3,12,3,5,0,1};
        doShellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
