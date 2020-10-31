package com.test;

import java.util.HashMap;
import java.util.Map;

public class UserPythonTest {
    public static void userPython(){
        String cmd = "python ";

    }
    public static String mapToString(){
        Map<String, String> map = new HashMap<>();
        map.put("mac","94:96:96");
        map.put("dns1","10.10.10.10");
        return map.toString();
    }
    public static void main(String[] args) {
        System.out.println(mapToString());
    }
}
