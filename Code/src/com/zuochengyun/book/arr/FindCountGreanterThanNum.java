package com.zuochengyun.book.arr;

import java.util.*;

/**
 * @ClassName : FindCountGreanterThanNum
 * @Description : 找到出现次数大于K次的数
 * @Author : caizongyu
 * @Date: 2020-08-28 18:11
 */
public class FindCountGreanterThanNum {
    /**
     * 简单题:找到数组中出现次数大于一半的数字
     * 思路：一个数组中出现次数大于一半的数字要么只有一个，要么没有
     * @param arr
     * @return
     */
    private static Integer findGTHalfNum(int[] arr){
        if(arr == null){
            System.out.println("bad request");
            return null;
        }
        int count =1;
        int current = arr[0];
        for (int i=1;i<arr.length;i++){
            if(arr[i] == current){
                count++;
                continue;
            }
            if(--count ==0){
                current = arr[i];
                count=1;
            }

        }
        count = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == current){
                count++;
            }
        }
        return count>arr.length/2 ? current:null;

    }

    /**
     * 找到出现次数大于N/k的数
     */
    public static void findKNum(int[] arr, int k){
        if(arr == null){
            return;
        }
        if(k<2){
            System.out.println("valid param ");
            return;
        }
        int limit = k-1;
        //num -> count
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }else{
                if(map.size() < limit){
                    map.put(arr[i],1);
                }else{
                    deleteK(map);
                }
            }
        }

    }
    private static void deleteK(Map<Integer, Integer> map){
        Integer key = null;
        Integer value = null;
        List<Integer> list = new LinkedList<>();
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            key = entry.getKey();
            value = entry.getValue();
            if(value.intValue() == 1){
                list.add(key);
            }else{
                map.put(key, value.intValue()-1);
            }
        }
        for(Integer one: list){
            map.remove(one);
        }

    }
    private static Set<Integer> getRealResult(int[] arr, Map<Integer, Integer> map){
        Set<Integer> result = new HashSet<>();
        int count =0;
        for(Integer key: map.keySet()){
            map.put(key,0);
        }
        for(int i= 0; i<arr.length; i++){
            if(map.containsKey(arr[i])){
                count = map.get(arr[i])+1;
                map.put(arr[i], count);
                //............
            }

        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr={1,2,4,4,4};
        System.out.println(findGTHalfNum(arr));
    }
}
