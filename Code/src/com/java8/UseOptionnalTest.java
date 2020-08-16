package com.java8;

import java.util.Optional;

public class UseOptionnalTest {
    private static void userOptional(){
        //创建一个为空的optional
        Optional<Object> emptyOp = Optional.empty();
        //创建一 个非空的op
        Optional<Object> intergeOp = Optional.of(new Integer(5));
        //创建一个允许null值的Op
        Optional<Integer> canNullOp = Optional.ofNullable(null);
        canNullOp.get();
        //使用map
        Optional<String> opString = intergeOp.map(Object::toString);
        System.out.println(emptyOp.isPresent());

    }

    public static void main(String[] args) {
        userOptional();
    }

}
