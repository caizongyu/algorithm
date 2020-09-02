package com.zuochengyun.book.arr;

/**
 * @ClassName : PrintZMatrix
 * @Description : z 字形打印矩阵
 * @Author : caizongyu
 * @Date: 2020-08-20 15:48
 */
public class PrintZMatrix {
    private static void doPrintZ(int[][] arr){
        int beginX=0;
        int beginY =0;
        int endX= 0;
        int endY =0;
        boolean flag = true;
        while(endX ==0 || beginY!=endY){
            if(!flag){
                printOne(arr,beginX, beginY, flag);
            }else {
                printOne(arr, endX,endY, flag);
            }
            flag = !flag;

            beginX= beginY == arr[0].length-1? beginX+1:beginX;
            beginY=(beginY == arr[0].length-1)? beginY:beginY+1;
            endY = endX == arr.length-1? endY+1:endY;
            endX = endX == arr.length-1? endX:endX+1;
        }
        System.out.println(arr[arr.length-1][arr[0].length-1]);
    }
    private static  void printOne(int[][] arr, int beginX, int beginY, boolean flag){
        if(!flag){
            while(beginX>=0 && beginY>=0  && beginX<= arr.length-1 && beginY <= arr[0].length-1){
                System.out.print(arr[beginX++][beginY--] + " ");
            }

        }else{
            while(beginX>=0 && beginY>=0 && beginX<= arr.length-1 && beginY <= arr[0].length-1){
                System.out.print(arr[beginX--][beginY++] + " ");
            }
        }
    }

    public static void main(String[] args) {
        //int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        //doPrintZ(arr);
        try{

            throw new  InterruptedException();
        } catch (InterruptedException e) {
            System.out.println("interrupt is happen");
            Thread.currentThread().interrupt();
        }

    }

}
