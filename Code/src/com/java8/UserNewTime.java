package com.java8;

import java.time.*;

public class UserNewTime {
    private static void userTime(){
        //localDate
        LocalDate localDate = LocalDate.of(2020,8,2);
        System.out.println(localDate.getMonth());
        //LocalTime
        LocalTime localTime = LocalTime.of(21, 48, 0);

        //LocalDateTime
        LocalDateTime localDateTime = LocalDateTime.of(2020, 8, 2,21,50,0);
        LocalDateTime localDateTime1 = LocalDateTime.of(localDate, localTime);
        LocalDateTime localDateTime2 = LocalDateTime.now();

        Instant instant2 = localDateTime2.atZone(ZoneId.systemDefault()).toInstant();
        System.out.println("milli:"+ instant2.toEpochMilli());
        //Instant
        Instant instant = Instant.now();
        System.out.println(instant);
    }

    public static void main(String[] args) {
        userTime();
    }
}
