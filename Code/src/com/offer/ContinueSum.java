package com.offer;

import java.util.ArrayList;

public class ContinueSum {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if(sum<=1){
            return ans;
        }
        ArrayList<Integer> one = null;
        int begin = 1;
        int temp = 0;
        for(int i=1;i<sum;i++){
            temp  = begin*(i-begin+1) + (i-begin+1)*(i-begin)/2;
            while(temp>sum && begin<=i){
                temp =temp-begin;
                begin++;
            }
            if(temp == sum){
                one = new ArrayList<>();
                for(int j=begin;j<=i;j++){
                    one.add(j);
                }
                ans.add(one);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new ContinueSum().FindContinuousSequence(9));
    }
}
