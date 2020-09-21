package com.arr;

/**
 * 最数组的最大累加和
 */
public class SonArrMaxAdd {
    public static Integer getResult(int[] arr){
        if(arr == null || arr.length<1){
            return null;
        }
        int sum = 0;
        int result = Integer.MIN_VALUE;
        for(int i = 0;i<arr.length;i++){
            sum += arr[i];
            result = Math.max(arr[i], result);
            result = Math.max(result, sum);
            if(sum < 0){
                sum =0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,-2,3,5,-2,6,-1};
        System.out.println(getResult(arr));
    }
}
