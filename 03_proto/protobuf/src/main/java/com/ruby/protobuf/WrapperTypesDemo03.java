package com.ruby.protobuf;

import com.google.protobuf.*;
import com.ruby.models.Student;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

public class WrapperTypesDemo03 {

    public static void main(String[] args) {

        LocalDateTime localDateTime = LocalDateTime.now();
        //Date date = new Date(2020, 06, 22);
        //final Instant instant = date.toInstant();
        //Timestamp t = Timestamp.newBuilder().setSeconds(instant.getEpochSecond()).build();

        Student st = Student.newBuilder()
                .setAge(Int32Value.newBuilder().setValue(25).build())
                .setName(StringValue.of("ZeRo"))
                .setIsMale(BoolValue.of(true))
                .setRating(DoubleValue.of(3.5))
                .setCreatedAt1(convertLocalDateTimeToGoogleTimestamp(localDateTime))
                .setCreatedAt2(convertLocalDateTimeToGoogleTimestampForDate(localDateTime))
                .setCreatedDate(convertLocalDateTimeToGoogleDate(localDateTime))
                .build();

         System.out.println(st.hasAge()  +"->"+ st.getAge());
         System.out.println(st.hasName()  +"->"+ st.getName());
         System.out.println(st.hasIsMale()  +"->"+ st.getIsMale());
         System.out.println(st.hasRating()  +"->"+ st.getRating());
         System.out.println(st.hasCreatedAt1()  +"->"+ st.getCreatedAt1());
         System.out.println(st.hasCreatedAt2()  +"->"+ st.getCreatedAt2());
         System.out.println(st.hasCreatedDate()  +"->"+ st.getCreatedDate());
    }

    public static Timestamp convertLocalDateTimeToGoogleTimestamp(LocalDateTime localDateTime) {
        Instant instant = localDateTime.toInstant(ZoneOffset.UTC);
        Timestamp result = Timestamp.newBuilder()
                .setSeconds(instant.getEpochSecond())
                .setNanos(instant.getNano())
                .build();
        return result;
    }

    public static Timestamp convertLocalDateTimeToGoogleTimestampForDate(LocalDateTime localDateTime) {
        Instant instant = Instant.from( localDateTime.toLocalDate().atStartOfDay().toInstant(ZoneOffset.UTC));
        Timestamp result = Timestamp.newBuilder()
                .setSeconds(instant.getEpochSecond())
                .setNanos(instant.getNano())
                .build();

        return result;
    }

    public static com.google.type.Date convertLocalDateTimeToGoogleDate(LocalDateTime localDateTime) {
        com.google.type.Date result = com.google.type.Date.newBuilder().setYear(localDateTime.getYear())
                .setMonth(localDateTime.getMonthValue())
                .setDay(localDateTime.getDayOfMonth())
                .build();
        return result;
    }
}
