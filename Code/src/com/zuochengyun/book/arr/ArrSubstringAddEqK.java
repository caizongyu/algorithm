package com.zuochengyun.book.arr;

/**
 * @ClassName : ArrSubstringAddEqK
 * @Description : 未排序正整数数组中累加和为给定值的最长子组数长度
 * @Author : caizongyu
 * @Date: 2020-09-12 16:52
 */
public class ArrSubstringAddEqK {
    public static int getResult(int[] arr, int k){
        if(arr == null){
            return -1;
        }
        int sum = 0;
        int left = 0, right = 0;
        int result = 0;
        for(int i = 0;i<arr.length;i++){
            sum += arr[i];
            while(sum>k){
                sum = sum - arr[left++];
            }
            if(sum == k){
                result = Math.max(result, i-left+1);
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2,1,1,1};
        System.out.println(getResult(arr, 3));
    }
}
