package com.offer;

/**
 * @ClassName : StringReplaceSpace
 * @Description : 将一个字符串空格替换成%20
 * @Author : caizongyu
 * @Date: 2020-10-20 15:28
 */
public class StringReplaceSpace {
    public static String replaceSpace(StringBuffer str) {
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ' '){
                str.replace(i,i+1,"%20");
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        StringBuffer a = new StringBuffer("We Are Happy.");
        System.out.println(replaceSpace(a));

    }
}
