package com.zuochengyun.book.arr;



import java.util.*;

/**
 * @ClassName : GetMaxLenthSequenOne
 * @Description : 最长的可整合数组的长度,方法:如果数组没有重复元素,那么max - min +1 = 个数 那么就是可整合数组 判断方法O（1）
 * @Author : caizongyu
 * @Date: 2020-09-03 17:06
 */
public class GetMaxLenthSequenOne {

    private int[] doJuede(int[] arr){
        if(arr == null){
            return null;
        }
        int[] result = new int[2];
        int min  =0;
        int max = 0;
        int len = 0;
        int rep = 0;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            min = arr[i];
            max = arr[i];
            set.add(arr[i]);
            for(int j = i + 1;j<arr.length;j++){
               min = Math.min(min, arr[j]);
               max = Math.max(max, arr[j]);
               if(set.contains(arr[j])){
                   rep++;
               }else {
                   set.add(arr[j]);
               }
               if(max - min +1 == j-i + 1-rep && max - min +1 > result[1]-result[0]+1){
                   result[0] = i;
                   result[1] = j;

               }
            }
            set.clear();
        }
        return result;
    }
    public static String decode(String data) {
        //把字符串转为字节数组
        byte[] b = data.getBytes();
        //遍历
        for (int i = 0; i < b.length; i++) {
            b[i] -= 1;//在原有的基础上-1
        }
        return new String(b);
    }
    public static String encode(String data) {
        byte[] b = data.getBytes();
        //遍历
        for(int i=0;i<b.length;i++) {
            b[i] += 1;//在原有的基础上+1
        }
        return new String(b);
    }
    public static void main(String[] args) {
        String pass = "caizongyu";
        char[] arr = pass.toCharArray();
        int key = 0xA;
        for(int i=0;i< pass.length();i++){
            arr[i] = (char)(arr[i] ^key);
        }
        System.out.println("safe: " + Arrays.toString(arr));
        for(int i=0;i< pass.length();i++){
            arr[i] = (char)(arr[i] ^key);
        }
        System.out.println("source: " + Arrays.toString(arr));



    }
}
