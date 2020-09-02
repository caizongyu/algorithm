package com.zuochengyun.book.chapterfive.string;

import sun.text.normalizer.Trie;

import javax.swing.text.html.Option;
import java.util.HashMap;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @ClassName : BuildTrie
 * @Description : 前缀树的构建
 * @Author : caizongyu
 * @Date: 2020-08-03 11:11
 */
public class BuildTrie {
    private final static TrieNode root = new TrieNode();
    public static void insert(String word){
        if(word == null){
            return;
        }
        char[] arr = word.toCharArray();
        TrieNode current = root;
        for(Character one:arr){
            if(current.getMap().get(one) == null){
                current.getMap().put(one, new TrieNode());
            }
            current = current.getMap().get(one);
            current.path++;
        }
        current.end++;

    }
    public void delete(String word){
        if(word == null){
            return;
        }
        char[] arr = word.toCharArray();
        if(!search(word)){
            return;
        }
        TrieNode current = root;
        for(Character one:arr){
            if(current.getMap().get(one).path == 1){
                current.getMap().put(one,null);
                return;
            }
            current = current.getMap().get(one);
            current.path--;
        }
        current.end--;

    }
    public boolean search(String word){
        if(word == null){
            return false;
        }
        char[] arr = word.toCharArray();
        TrieNode current = root;
        for(Character one:arr){
            if(current.getMap().get(one)==null ||current.getMap().get(one).path <= 0){
                return false;
            }
            current = current.getMap().get(one);
        }
        return current.end > 0;
    }

    /**
     * 返回前缀开头的单词数量
     * @param pre
     * @return
     */
    public int prefixNumber(String pre){
        if(pre == null){
            return -1;
        }
        char[] arr =pre.toCharArray();
        TrieNode current = root;
        for(Character one: arr){
            if(current.getMap().get(one) == null){
                return 0;
            }
            current = current.getMap().get(one);
        }
        return current.end;
    }


    public static void main(String[] args) {
        insert(null);
    }


}
class TrieNode{
    //路过改节点的数据个数
    public int path;
    //以改节点为结尾的个数
    public int end;
    public HashMap<Character, TrieNode> map = new HashMap<>();

    public int getPath() {
        return path;
    }

    public void setPath(int path) {
        this.path = path;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public HashMap<Character, TrieNode> getMap() {
        return map;
    }

    public void setMap(HashMap<Character, TrieNode> map) {
        this.map = map;
    }
}
