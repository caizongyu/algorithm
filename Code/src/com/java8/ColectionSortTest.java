package com.java8;

import com.zuochengyun.book.chaptertwo.list.MyListUtils;

import java.util.*;

public class ColectionSortTest {
    private static void lambdaStringListSort(){
        String[] arr = {"ab","ac","ca","ba"};
        List<String> list = Arrays.asList(arr);
        list.sort((a1,a2) -> a1.compareToIgnoreCase(a2));//lambda
        list.sort(String::compareToIgnoreCase);//方法引用
        list.sort(Comparator.comparing(String::length));
    }

    public static void main(String[] args) {
        LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();
        for(Map.Entry entry:map.entrySet()){
            System.out.println(entry.getValue());
        }
    }
}
