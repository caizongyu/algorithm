package com.zuochengyun.book.arr;

import java.util.Arrays;

/**
 * @ClassName : ArrSmallSum
 * @Description : 计算数组的小和
 * @Author : caizongyu
 * @Date: 2020-09-17 17:32
 */
public class ArrSmallSum {
    private static void doJump(int[] arr){
        if(arr == null || arr.length == 0){
            return;
        }
        int temp = 0;
        for(int i= 0;i!=arr.length;i++){
            temp = arr[i];
            while(arr[i]!= i+1){
                arr[i] = arr[arr[i]-1];
                arr[temp-1] = temp;
                temp = arr[i];
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = {1,2,5,3,4};
        doJump(arr);
    }

}
