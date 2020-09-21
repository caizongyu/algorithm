package com.arr;

import java.util.Arrays;

/**
 * 找到数组中的前K小的数
 */
public class FindMinKInArr {
    private static void insertHeap(int[] heap, int insertValue, int index){
        heap[index] = insertValue;
        int parent = (index-1) >>1;
        while(index != 0){
            if(heap[index] > heap[parent]){
                swap(heap, index,parent);
            }
            index = parent;
            parent = (index -1) >>1;
        }

    }

    /**
     * 方法1 使用堆排序 构建最大堆，选出最小前k个数
     * @param arr
     * @param k
     * @return
     */
    private static int[] userHeap(int[] arr, int k){
        if(arr == null || k<1 || k>arr.length) {
            return null;
        }
        int[] heap = new int[k];
        //init heap
        for(int i=0;i<k;i++){
            insertHeap(heap, arr[i], i);
        }
        for(int i=k;i<arr.length;i++){
            if(arr[i] < heap[0]){
                heap[0] = arr[i];
                adjustHeap(heap);
            }
        }
        return heap;
    }
    private static void adjustHeap(int[] heap){
        int parent =0;
        int left = (parent >>1) + 1;
        int right = left +1;
        int morenIndex = parent;
        while(left< heap.length){
            if(heap[parent] < heap[left]){
                morenIndex = left;
            }
            if(right<heap.length && heap[right] > heap[morenIndex]){
                morenIndex = right;
            }
            if(morenIndex!=parent){
                swap(heap, morenIndex, parent);
            }else{
                break;
            }
            parent = morenIndex;
            left = (parent>>1)+1;
            right = left + 1;

        }
    }
    private static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /**
     * 线性查找算法
     */
    private static void userBFPRT(){

    }
    private static int getMidian(int[] arr, int k){
        int step = 5;
        int mediansLen  = arr.length/5 + arr.length%5 ==0? 0:1;
        int[] medians = new int[mediansLen];
        int index = 0;
        for(int i=0;i<arr.length;i=i+5){
            medians[index++] = findMedian(arr, i, i+5);
        }
        return findMedian(medians, 0, medians.length);

    }
    private static int select(int[] arr, int begin, int end){
        if(begin == end){
            return arr[begin];
        }


        return -1;
    }
    private static int findMedian(int[] arr, int begin, int end){
        Arrays.sort(arr, begin,end);
        int index = ((end -begin) >>1) + begin;
        if(((end-begin) & 1) == 0){
            return arr[index-1];
        }
        return arr[index];

    }
    private static int partition(int[] arr, int begin, int end, int value){
        int left = begin;
        int right = end;
        int userIndex = begin;
        int valueCount=0;
        while(left <= right){
            if(arr[left] < value){
                arr[userIndex++]= arr[left++];
                continue;
            }
            if(arr[left] == value){
                left++;
                valueCount++;
                continue;
            }
            if(arr[left] > value){
                swap(arr, left, right--);
            }

        }
        return userIndex;
    }
    public static void main(String[] args) {
        int[] arr = {1,5,2,3,4};
        //System.out.println(Arrays.toString(userHeap(arr, 4)));
        //Arrays.sort(arr,0,3);
        System.out.println(partition(arr, 0,arr.length-1,3));
        System.out.println(Arrays.toString(arr));

    }
}
