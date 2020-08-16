package com.bit;

import java.util.Arrays;

/**
 * 一个数组中其他数出现k次，只有一个出现1次，找到这个数
 * 解法：K个K进制数，无相位相加都为0
 */
public class FindKCountOne {
    private static int getAns(int[] arr, int k){
        if(arr == null || k<1){
            return -1;
        }
        int[] ans = new int[32];
        Arrays.stream(arr).forEach((one) ->{
             kNoAdd(tranToK(one, k), ans, k);
        });
        System.out.println(Arrays.toString(ans));
        return 0;
    }
    private static void kNoAdd(int[]  a, int[] ans, int k){
        for(int i=0;i<a.length;i++){
            ans[i] = (a[i]+ans[i])% k;
        }
    }

    /***
     * 将一个数字转换成k进制 可以使用系统行数Integer.toString来做进制装换
     * @param a
     * @param k
     * @return
     */
    private static int[] tranToK(int a, int k){
        int[] ans = new int[32];
        int index = 0;
        while(a!=0){
            ans[index++] = a % k;
            a= a/k;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr= {1,2,1,2,3};
        int k = 2;
        getAns(arr, 2);
    }

}
