package com.docker.postgresql.utilities.date;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.xml.datatype.XMLGregorianCalendar;

public final class DateUtil {
    public static final String DD_MM_YYYY_HH_MM = "dd/MM/yyyy HH:mm";
    public static final String DD_MM_YYYY = "dd/MM/yyyy";
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String HH_MM = "HH:mm";
    public static final ZoneId ZONE_ID_OF_CET = ZoneId.of("CET");

    /**
     * Empty constructor.
     */
    private DateUtil() {
        /* hide constructor */
    }

    public static LocalDateTime now() {
        return LocalDateTime.now(ZONE_ID_OF_CET);
    }
    public static LocalDate today() {
        return now().toLocalDate();
    }

    /**
     * to String methods
     */
    public static String toString(LocalDateTime localDateTime) {
        return toString(localDateTime, DD_MM_YYYY_HH_MM);
    }
    public static String toString(LocalDateTime localDateTime, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return localDateTime.format(formatter);
    }
    public static String toString(LocalDate localDate) {
        return toString(localDate, DD_MM_YYYY);
    }
    public static String toString(LocalDate localDate, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return localDate.format(formatter);
    }
    public static String toString(LocalTime localTime) {
        return toString(localTime, HH_MM);
    }
    public static String toString(LocalTime localTime, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return localTime.format(formatter);
    }
    public static String toString(Date date) {
        return toString(date, DD_MM_YYYY_HH_MM);
    }
    public static String toString(Date date, String pattern) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZONE_ID_OF_CET);
        return toString(localDateTime, pattern);
    }

    /**
     * from String methods
     */
    public static LocalDateTime toLocalDateTime(String string) {
        return toLocalDateTime(string, DD_MM_YYYY_HH_MM);
    }
    public static LocalDateTime toLocalDateTime(String string, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDateTime.parse(string, formatter);
    }
    public static LocalDate toLocalDate(String string) {
        return toLocalDate(string, DD_MM_YYYY);
    }
    public static LocalDate toLocalDate(String string, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDate.parse(string, formatter);
    }
    public static LocalTime toLocalTime(String string) {
        return toLocalTime(string, HH_MM);
    }
    public static LocalTime toLocalTime(String string, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalTime.parse(string, formatter);
    }
    public static Date toDate(String string) {
        return toDate(string, DD_MM_YYYY_HH_MM);
    }
    public static Date toDate(String string, String pattern) {
        return fromLocalDateTimeToDate(toLocalDateTime(string,pattern));
    }

    /**
     * advanced methods
     */
    public static LocalDateTime fromLocalDateToLocalDateTime(LocalDate date) {
        return date.atStartOfDay();
    }
    public static LocalDateTime fromDateToLocalDateTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZONE_ID_OF_CET);
    }
    public static LocalDate fromDateToLocalDate(Date date) {
        return fromDateToLocalDateTime(date).toLocalDate();
    }
    public static Date fromLocalDateTimeToDate(LocalDateTime localDateTime) {
        ZonedDateTime zdt = localDateTime.atZone(ZONE_ID_OF_CET);
        return Date.from(zdt.toInstant());
    }
    public static Date fromLocalDateToDate(LocalDate localDate) {
        ZonedDateTime zdt = localDate.atStartOfDay(ZONE_ID_OF_CET);
        return Date.from(zdt.toInstant());
    }

    public static LocalDate toLocalDate(XMLGregorianCalendar calendar) {
        return LocalDate.of(calendar.getYear(), calendar.getMonth(), calendar.getDay());
    }

}
