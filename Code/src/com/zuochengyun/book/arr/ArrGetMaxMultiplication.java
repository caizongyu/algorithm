package com.zuochengyun.book.arr;

/**
 * @ClassName : ArrGetMaxMultiplication
 * @Description : 数组中子数组的最大乘积
 * @Author : caizongyu
 * @Date: 2020-09-22 10:49
 */
public class ArrGetMaxMultiplication {
    private static Double getResult(double[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        double min = arr[0];
        double max = arr[0];
        double ans = arr[0];
        double maxEnd = arr[0];
        double minEnd = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxEnd = max * arr[i];
            minEnd = min * arr[i];
            max = Math.max(max, Math.max(arr[i], maxEnd));
            min = Math.min(min, Math.min(arr[i], minEnd));
            ans = Math.max(ans, max);
        }
        return ans;

    }

    public static void main(String[] args) {
        double[] arr = {-2.5,4,0,3,0.5,8,-1};
        System.out.println(getResult(arr));
    }
}
