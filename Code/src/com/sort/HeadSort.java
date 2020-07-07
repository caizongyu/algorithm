package com.sort;

import java.util.Arrays;

/**
 * 堆排序
 */
public class HeadSort {
    /**
     * 对一个点的调整
     * @param arr
     */
    private static void buildIndexHead(int[] arr,int i){
        if(arr == null){
            return;
        }
        int parent=0;
        while(i!=0){
            parent=(i-1)>>1;
            if(arr[parent] < arr[i]){
                swap(arr,parent,i);
                i=parent;
            }else{
                break;
            }
        }
    }

    /**
     * 构建大顶堆
     * @param arr
     * @param length
     */
    private static void buildAllHead(int[] arr, int length){
        for(int i=0;i<length;i++){
            buildIndexHead(arr,i);
        }
    }
    private static void doSort(int[] arr){
        if(arr == null){
            return;
        }
        for (int i=0;i<arr.length;i++){
            buildAllHead(arr,arr.length-i);
            swap(arr,0,arr.length-1-i);
        }
    }
    private static void swap(int[] arr,int a, int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }

    public static void main(String[] args) {
        int[] arr={2,1,2,0,5,3};
        doSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
