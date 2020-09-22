package com.zuochengyun.book.arr;

/**
 * @ClassName : ArrOddNumAndEvenNum
 * @Description : 奇数下标都是奇数或者偶数下标都是偶数
 * @Author : caizongyu
 * @Date: 2020-09-18 17:52
 */
public class ArrOddNumAndEvenNum {
    public static void getResult(int[] arr){
        if(arr == null || arr.length<2){
            return;
        }
        int odd = 1;
        int event = 0;


    }

    private static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
