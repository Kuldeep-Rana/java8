package com.codersdesks.samples.datetime;

import java.text.DateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
    Java 8 improved the Date time a lot with new java.time package
    In this example I will try to write plenty of operation we can do
    with LocalDate,LocalDateTime and LocalTime
 */

public class LocalDateExample {

    public static void main(String[] args) {
        System.out.println("Local Date "+getLocalDate());
        System.out.println("Local Time "+getLocalTime());
        System.out.println("Local DateTime "+getLocalDateTime());
        System.out.println("local date time with combining methods "+getLocalDateTimeByCombining());
        System.out.println("Zone Date Time "+getZoneDateTime());
        System.out.println(" time zone difference in hours "+ getZoneDateTimeDifferences());
        System.out.println("Epoch Date "+getEpochDate());
        System.out.println("Local Date by year and day of year "+ getLocalDateByYearAndDayOfYear());
        System.out.println("Last day of month " + getLastDayOfMonth());
        System.out.println("Last day of Year "+getLastDayOfYear());
        System.out.println("Period between two dates "+getPeriodBetweenTwoDates());
        System.out.println("Days between two dates "+getDaysBetweenTwoDates());
        System.out.println("Last day of each month for 2021 "+getLastOfEachMonthOfGivenYear(2021));
        System.out.println("Last day of each month for 2021 using Java 8 Stream "+getLastOfEachMonthOfGivenYearUsingJava8Stream(2021));
        System.out.println("LocalDate formatted to ISO date "+formatToISODate());
        System.out.println("LocalDate formatted to pattern "+formatToPattern());
        System.out.println("String date in MM/dd/yyyy format parsed to LocalDate "+parseDate(formatToPattern(),"MM/dd/yyyy"));
    }

    //Using of method to get a LocalDate
    public static LocalDate getLocalDate(){
        return  LocalDate.of(1989,11,27);
    }

    //Using of method to get LocalTime
    public static LocalTime getLocalTime(){
        return  LocalTime.of(15,30);
    }

    //Using LocalDateTime of method to get LocalDateTime till nano second
    public static LocalDateTime getLocalDateTime(){
        return LocalDateTime.of(1989,11,27,15,30,14,45);
    }

    public static LocalDateTime getLocalDateTimeByCombining(){
        return LocalDateTime.of(getLocalDate(),getLocalTime());
    }

    //Getting ZoneDateTime
    public static ZonedDateTime getZoneDateTime(){
        return ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
    }

    //Getting ZoneDateTime difference in hours
    public static int getZoneDateTimeDifferences(){
        ZonedDateTime kolkata =  ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        ZonedDateTime london =  ZonedDateTime.now(ZoneId.of("Europe/London"));
        return kolkata.getHour() - london.getHour();
    }

    //Get LocalDate of epochDate, epochDate as per Java epoch is 1970-01-01,
    // so this method will return LocalDate after adding 10 days to epoch date
    public static  LocalDate getEpochDate(){
        return LocalDate.ofEpochDay(10);
    }

    //Getting LocalDate by year and day of year, this will calculate month by day of year
    // in this case 91 is 1st of April 2001
    public static LocalDate getLocalDateByYearAndDayOfYear(){
        return LocalDate.ofYearDay(2001,91);
    }

    // Get Last Day of the month, it will return a enum of DayOfWeek
    public static DayOfWeek getLastDayOfMonth(){
        return LocalDate.now().with(TemporalAdjusters.lastDayOfMonth()).getDayOfWeek();
    }

    // Get Last Day of the year, it will return a enum of DayOfWeek
    public static DayOfWeek getLastDayOfYear(){
        return LocalDate.now().with(TemporalAdjusters.lastDayOfYear()).getDayOfWeek();
    }

    //Get Period between two dates using LocalDate and Period
    public static  Period getPeriodBetweenTwoDates(){
        LocalDate today = LocalDate.now();
        LocalDate myBirthDay = today.with(Month.NOVEMBER).withDayOfMonth(27);
        return Period.between(today,myBirthDay);
    }

    //Get Days between two dates using LocalDate and Period
    public static  long getDaysBetweenTwoDates(){
        LocalDate today = LocalDate.now();
        LocalDate myBirthDay = today.with(Month.NOVEMBER).withDayOfMonth(27);
        return ChronoUnit.DAYS.between(today,myBirthDay);
    }

    public static List<DayOfWeek> getLastOfEachMonthOfGivenYear(int year){
        List<DayOfWeek> days  = new ArrayList<>();
        for(Month month : Month.values()){
           DayOfWeek day = LocalDate.now().withYear(year).with(month)
                            .with(TemporalAdjusters.lastDayOfMonth()).getDayOfWeek();
           days.add(day);
        }
        return  days;
    }

    public static List<DayOfWeek> getLastOfEachMonthOfGivenYearUsingJava8Stream(int year){
        return Stream.of(Month.values())
                .map(month -> LocalDate.now()
                        .withYear(year)
                        .with(month)
                        .with(TemporalAdjusters.lastDayOfMonth())
                        .getDayOfWeek()
                ).collect(Collectors.toList());
    }

    //Format LocalDate to ISO format
    public static String formatToISODate(){
        return  LocalDate.now().format(DateTimeFormatter.ISO_DATE);
    }

    //Format LocalDate to MM/dd/yyyy
    public static String formatToPattern(){
        return  LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
    }

    //Parse a string date to LocalDate
    public static LocalDate parseDate(String date,String pattern){
        return  LocalDate.parse(date,DateTimeFormatter.ofPattern(pattern));
    }
}
