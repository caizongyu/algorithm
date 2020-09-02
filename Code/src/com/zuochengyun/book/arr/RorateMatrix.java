package com.zuochengyun.book.arr;

import com.utils.TwoDimensionalArraysUtils;

/**
 * @ClassName : RorateMatrix
 * @Description : 旋转90度矩阵
 * @Author : caizongyu
 * @Date: 2020-08-19 20:35
 */
public class RorateMatrix {
    public static int[][] doRorate(int[][] arr) {
        if (arr == null) {
            return null;
        }
        int topX = 0;
        int buttomX = arr.length - 1;
        int leftY = 0;
        int rightY = arr[0].length - 1;
        int count = 0;
        while (topX < buttomX && leftY < rightY) {
            swap(arr, topX++, leftY++, buttomX--, rightY--);
        }
        return arr;

    }

    public static void swap(int[][] arr, int topX, int leftY, int buttomX, int rightY) {
        int temp = 0;
        for (int i = 0; leftY + i < rightY; i++) {
            temp = arr[topX][leftY + i];
            arr[topX][leftY + i] = arr[buttomX - i][leftY];
            arr[buttomX - i][leftY] = arr[buttomX][rightY - i];
            arr[buttomX][rightY - i] = arr[topX + i][rightY];
            arr[topX + i][rightY] = temp;
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] arr1={{1,2,3},{4,5,6},{7,8,9}};
        TwoDimensionalArraysUtils.print(doRorate(arr1));
    }

}
