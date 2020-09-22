package com.arr;

import java.util.Arrays;

/**
 * 数组的partition调整
 * 给定一个有序数组，调整arr是的这个数组的左半部分没有重复元素且升序
 */
public class ArrPartition {
    private static int[] getResult(int[] arr){
        if(arr == null || arr.length == 0){
            return null;
        }
        int after = -1;
        for(int i=1;i<arr.length/2;i++){
            if(arr[i] <= arr[i-1]){
                if(after == -1){
                    after = i + 1;
                }
                while(arr[after]<= arr[i-1]){
                    after++;
                }
                swap(arr, i, after);
            }

        }
        return arr;
    }
    private static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b]= temp;
    }

    public static void main(String[] args) {
        int[] arr ={1,2,2,2,3,3,4,5,6,6,7,7,8,8,8,9};
        System.out.println(Arrays.toString(getResult(arr)));
    }
}
