package com.offer;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e",
 * "1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class JudgeNumber {
    public boolean isNumeric(char[] str) {
        if(str ==null || str.length ==0){
            return false;
        }
        int begin = 0;
        if(str[0] == '-' || str[0] == '+'){
            begin = 1;
        }
        int dian=0;
        for(int i=begin;i<str.length;i++){
            if(str[i]=='.'){
                dian++;
                if(dian ==2){
                    return false;
                }
            }
            if(str[i] == '-' || str[i] == '+'){
                if(str[i-1]!='e' && str[i-1]!='E'){
                    return false;
                }
                if(i == str.length-1 || str[i+1]<'0' ||str[i+1]>'9'){
                    return false;
                }
            }
            if(str[i]!= '.' && str[i]!='e' && str[i]!='E' && str[i]>='a' && str[i]<='z'){
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        char[] arr = {'1','2','e'};
        System.out.println(new JudgeNumber().isNumeric(arr));
        System.out.println(new JudgeNumber().getClass().getClassLoader());
        System.out.println(String.class.getClassLoader());


    }
}
