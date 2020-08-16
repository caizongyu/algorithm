package com.writtenexamanation;


import java.util.Arrays;


/**
 * 给定⼀个按开始时间从⼩到⼤排序的时间区间集合，请将重叠的区间合并。时
 * 间区间集合⽤⼀个⼆维数组表示，⼆维数组的每⼀⾏表示⼀个时间区间（闭区
 * 间），其中 0 位置元素表示时间区间开始，1 位置元素表示时间区间结束。
 * 例 1：输⼊：[ [1, 3], [2, 6], [8, 10], [15, 18] ]
 *  返回： [ [1, 6], [8, 10], [15, 18]]
 *  解释：时间区间 [1, 3] 和 [2, 6] 有部分重叠，合并之后为 [1, 6]
 * 例 2：输⼊：[[1, 4], [4, 5]]
 *  返回：[[1, 5]]
 *  解释：时间区间[1，4] 和 [4，5]重叠了⼀个时间点，合并之后为 [1，5]
 */
public class DaXiFirst {
    private static int[][] merge(int[][] intervals){
        if(intervals == null){
            return null;
        }
        int begin = intervals[0][0];
        int end =intervals[0][1];
        int index=0;
        for(int i=1; i<intervals.length; i++){
            if(end >= intervals[i][0]){
                end = Math.max(end, intervals[i][1]);
            }else{
                intervals[index][0] = begin;
                intervals[index++][1] = end;
                begin = intervals[i][0];
                end = intervals[i][1];
            }
        }
        intervals[index][0] = begin;
        intervals[index++][1]= end;
        int[][] ans = new int[index][2];
        for(int i=0;i<index;i++){
            ans[i] = intervals[i];
        }
        return ans;
    }
    public static void main(String[] args) {
        int[][] arr={{1,18},{4,6},{8,10},{15,18}};
        int[][] ans = merge(arr);
        for(int i=0;i<ans.length;i++){
            System.out.println(Arrays.toString(ans[i]));
        }

    }
}
