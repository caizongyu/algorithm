package com.arr;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 矩阵的最短通路
 */
public class MatrixShortest {
    private static int getResult(int[][] arr){
        if(arr== null){
            return -1;
        }
        int[][] map = new int[arr.length][arr[0].length];
        Queue<Integer> firstQueue = new LinkedList<>();
        Queue<Integer> secondQueue = new LinkedList<>();
        firstQueue.offer(0);
        secondQueue.offer(0);
        int first = 0;
        int second = 0;
        int ans =0;
        map[0][0]=1;
        while(!firstQueue.isEmpty()){
            first = firstQueue.poll();
            second = secondQueue.poll();
            if(first == arr.length-1 && second == arr[0].length-1){
                return map[first][second];
            }
            addNext(arr, map, first, second, firstQueue, secondQueue);
        }
        return  -1;

    }
    private static void addNext(int[][] arr,int[][] map, int first, int second, Queue<Integer> firstQueue, Queue<Integer> secondQueue){
        if(first-1 >= 0 && arr[first-1][second] == 1 && map[first-1][second] == 0){
            firstQueue.add(first-1);
            secondQueue.add(second);
            map[first-1][second] = map[first][second]+1;
        }
        if(second+1 <= arr[0].length - 1 && arr[first][second+1] ==1 && map[first][second+1] == 0){
            firstQueue.add(first);
            secondQueue.add(second+1);
            map[first][second+1] = map[first][second]+1;
        }
        if(first+1 <= arr.length-1 && arr[first+1][second] == 1 && map[first+1][second] == 0){
            firstQueue.add(first+1);
            secondQueue.add(second);
            map[first+1][second] = map[first+1][second];
        }
        if(second-1 >=0 && arr[first][second-1] ==1 && map[first][second-1] == 0){
            firstQueue.add(first);
            secondQueue.add(second-1);
            map[first][second-1] = map[first][second]+1;
        }
    }

    public static void main(String[] args) {
       
    }
}
