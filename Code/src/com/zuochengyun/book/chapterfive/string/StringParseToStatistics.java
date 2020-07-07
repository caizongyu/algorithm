package com.zuochengyun.book.chapterfive.string;

/**
 * 字符串的统计字符串
 * aaabbaddd    编程  a3b2a1d3
 */
public class StringParseToStatistics {
    private static String getResuolt(String s){
        if(s == null || s.length()<1){
            return null;
        }
        char currentChar=s.charAt(0);
        int count=1;
        String result = s.charAt(0) + "";
        for(int i=1;i<s.length();i++){
           if(s.charAt(i) == currentChar){
               ++count;

           }else{
               result += count+""+(s.charAt(i));
               count =1;
                currentChar = s.charAt(i);
           }
        }
        //add last count
        result += count;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getResuolt("aaabbadddc"));
    }
}
