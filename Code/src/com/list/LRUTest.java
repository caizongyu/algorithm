package com.list;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUTest {
    private static LinkedList<Integer> list = new LinkedList<>();
    private static HashMap<Integer, Integer> map = new HashMap<>();
    private static int size = 2;
    public static void add(Integer value){
        if(map.get(value) ==null){
            map.put(value,0);
            list.add(value);
            if(map.size()>= size){
                list.remove(0);
            }
        }else{
            map.put(value, 0);
        }
    }
    public static void main(String[] args) {
        LRUTest.add(1);
        LRUTest.add(2);
        LRUTest.add(3);
        System.out.println(LRUTest.list);
    }
}
