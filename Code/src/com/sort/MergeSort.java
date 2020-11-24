package com.sort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {
    public void split(int[] arr,int left, int right){
        int mid = left + ((right - left)>>1);
        if(left >= right){
            return;
        }

        split(arr, left, mid);
        split(arr, mid+1,right);
        merge(arr, left, mid, right);

    }
    public void merge(int[] arr, int left, int mid, int right){
        int oldLeft = left;
        int leftEnd = mid;
        int rightBegin = mid+1;
        int len = right - left+1;
        int[] temp = new int[len];
        int k=0;
        while(left<= leftEnd && rightBegin<=right){
            temp[k++] = arr[left] < arr[rightBegin]? arr[left++]: arr[rightBegin++];
        }
        while(left<=leftEnd){
            temp[k++] = arr[left++];
        }
        while(rightBegin<=right){
            temp[k++] = arr[rightBegin++];
        }
        for(int i=0;i<temp.length;i++){
            arr[oldLeft+i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,2,4,6,5};
        new MergeSort().split(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
