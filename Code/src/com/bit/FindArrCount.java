package com.bit;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 一个数组中，找到出现奇数次的数
 */
public class FindArrCount {

    private static int getOnly(int[] arr){
        int[] ans = new int[1];
        IntStream stream = Arrays.stream(arr);
        stream.forEach((one) ->  ans[0]^= one);
        return ans[0];
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3};
        System.out.println(getOnly(arr));
    }
}
