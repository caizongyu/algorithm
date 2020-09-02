package com.zuochengyun.book.arr;

/**
 * @ClassName : PrintMatrix
 * @Description : 顺时针打印矩阵
 * @Author : caizongyu
 * @Date: 2020-08-17 11:50
 */
public class PrintMatrix {
    private static void doPrint(int[][] arr){
        int topX = 0;
        int leftY = 0;
        int buttonX=arr.length-1;
        int rightY = arr[0].length-1;
        int tempX =0;
        int tempY =0;
        int printCount = 0;
        int all =arr.length*arr[0].length;
        while(printCount < all) {
            tempY = leftY;
            while (tempY <= rightY) {
                System.out.print(arr[topX][tempY++] + " ");
                printCount++;
            }
            if(printCount == all){
                return;
            }
            System.out.println();
            topX++;
            tempX = topX;
            while (tempX  <= buttonX) {
                System.out.print(arr[tempX++][rightY] + " ");
                printCount++;
            }
            if(printCount == all){
                return;
            }
            System.out.println();
            rightY --;
            tempY = rightY;
            while (tempY >= leftY) {
                System.out.print(arr[buttonX][tempY--]);
                printCount++;
            }
            if(printCount == all){
                return;
            }
            System.out.println();
            buttonX --;
            tempX = buttonX;
            while (tempX > topX) {
                System.out.print(arr[tempX--][leftY]);
                printCount++;
            }
            if(printCount == all){
                return;
            }
            System.out.println();
            leftY++;

        }

    }

    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{1,2,3}};
        doPrint(arr);
        /*int a=10;
        int temp =10;
        while((temp = a) < 20){
            System.out.println(temp++);
        }*/
    }


}
