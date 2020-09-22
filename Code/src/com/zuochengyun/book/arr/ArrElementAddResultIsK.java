package com.zuochengyun.book.arr;

import javax.lang.model.type.IntersectionType;
import java.util.*;

/**
 * @ClassName : ArrElementAddResultIsK
 * @Description : 不重复打印排序数组中相加和为给定值的所有二元组和三元组
 * @Author : caizongyu
 * @Date: 2020-09-12 14:51
 */
public class ArrElementAddResultIsK {
    /**
     * 方法1
     * @param arr
     * @param k
     * @return
     */
    public static Map<Integer, Integer> getTwoElementAddK(int[] arr, int k){
        if(arr == null){
            return null;
        }
        Set<Integer> set = new HashSet<>();
        Map<Integer,Integer> result = new HashMap<>();
        for(int i=0;i<arr.length;i++) {
            if(set.contains(k-arr[i])){
                result.put(arr[i],k-arr[i]);
            }
            set.add(arr[i]);
        }
        return result;
    }

    /**
     * 素组有序的情况下
     * @param arr
     * @param k
     * @return
     */
    public static Map<Integer, Integer> getTwoElementAddKMethod2(int[] arr, int k){
        if(k< arr[0]+ arr[1] || k>arr[arr.length-1] + arr[arr.length-2]){
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int right = arr.length-1;
        while(left<right){
            if(arr[left] + arr[right] < k){
                left++;
            }else if (arr[left] + arr[right] > k){
                right--;
            }else{
                map.put(arr[left++], arr[right]--);

            }
        }
        return map;

    }

    private static List<Integer> getThreeElementAddK(int[] arr, int k){
        if(k < arr[0] + arr[1] + arr[2] || arr[arr.length-2] + arr[arr.length-1] + arr[arr.length-2] < k){
            return null;
        }
        List<Integer> list = new LinkedList<>();
        int left = 0;
        int right = 0;
        for(int i=0;i<arr.length;i++){
            left = i+1;
            right = arr.length-1;
            while(left < right){
                if(arr[left] + arr[right] < k-arr[i]){
                    left++;
                }else if(k- arr[i]< arr[left] + arr[right]){
                    right--;
                }else{
                    list.add(arr[i]);
                    list.add(arr[left++]);
                    list.add(arr[right--]);
                }
            }
        }
        return list;
    }


    public static void main(String[] args) {
        int[] arr= {-8,-4,-3,0,1,2,4,5,8,9};
        getTwoElementAddKMethod2(arr, 10);
    }
}
