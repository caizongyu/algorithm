package com.writtenexamanation;


import java.time.LocalDateTime;

/**
 * 给定⼀个 ⽆向图 包含 N 个节点和 M 条边, 每条边 Mi 的代价为 Ci 。图中⼀条
 * 路径的惩罚是指对该路径上所有边的代价 Ci 执⾏位运算或（bitwise OR）操
 * 作得到的。假如⼀条路径上包含了边 M1，M2，M3 … … ，Mk，那么对应的惩
 * 罚就是 C1 OR C2 OR C3 OR ... OR Ck。（OR代表位运算或，即 “|” ）
 */
public class DaXiThree {
    private static boolean[] visit;
    private static void createVisit(int n){
        visit = new boolean[n];
    }
    private static void initVisit(){
        if(visit == null){
            return;
        }
        for(int i=0;i<visit.length;i++){
            visit[i] = false;
        }
    }
    private static int minPath(int n, int[][] edges, int start, int end){
        if(n<=0 || edges ==null || start <=0 || end<=0 || start> n || end >n){
            return -1;
        }
        int[][] map= new int[n+1][n+1];
        //build map
        for(int i=0;i<edges.length;i++){
            map[edges[i][0]][edges[i][1]] = edges[i][2];
            map[edges[i][1]][edges[i][0]] = edges[i][2];
        }
        createVisit(map.length);
        return deepSearch(map, start,end, start,Integer.MAX_VALUE);

    }
    private static int  deepSearch(int[][] map, int current ,int end,int start,int min){
        for(int i=1;i<map.length;i++){
            if(map[current][i] == 0 || visit[i]){
                continue;
            }
            visit[current] = true;
            visit[i] = true;
            if(i == end){
                initVisit();
                min = Math.min(min,map[current][end]);
                continue;
            }
            if(current == start){
                int next = map[current][i] | deepSearch(map, i, end,start, min);
                min = Math.min(min,  next);
                if(i == map.length-1){
                    initVisit();
                    return min;
                }
                continue;
            }
            initVisit();
            return map[current][i] | deepSearch(map, i, end,start, min);


        }
        return min;
    }

    public static void main(String[] args) {
        //int[][] edges = {{1,2,1},{2,3,3},{1,3,100}};
        //System.out.println(minPath(3, edges, 1,3));
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

    }
}
