package com.zuochengyun.book.arr;

/**
 * @ClassName : FindNumInMatrix
 * @Description : 在行列都排好序的矩阵中找到数字
 * @Author : caizongyu
 * @Date: 2020-09-02 17:35
 */
public class FindNumInMatrix {
    private static boolean find(int[][] arr, int k){
        if(arr ==null || k< arr[0][0] || k>arr[arr.length-1][arr[0].length-1]){
            return false;
        }
        int beginX = 0;
        int beginY = arr[0].length-1;
        while(beginX >=0 && beginX< arr.length && beginY>=0 && beginY<arr[0].length){

            if(arr[beginX][beginY] < k){
                beginX++;

            }else if(arr[beginX][beginY] > k){
                beginY--;
            }else if(arr[beginX][beginY] == k){
                return true;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr ={{0,1,2,5},{2,3,4,7},{4,4,4,8},{5,7,7,9}};
        System.out.println(find(arr, 6));
        float num = 0.123456f;
        System.out.println((float)Math.round(num*100)/100);
    }
}
