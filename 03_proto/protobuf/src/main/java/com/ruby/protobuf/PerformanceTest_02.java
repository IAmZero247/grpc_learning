package com.ruby.protobuf;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.InvalidProtocolBufferException;
import com.ruby.json.JPerson;
import com.ruby.models.Person;

public class PerformanceTest_02 {

    public static void main(String[] args) {

        // json
        JPerson person = new JPerson();
        person.setName("sam");
        person.setAge(10);
        ObjectMapper mapper = new ObjectMapper();

        Runnable jackson = () -> {
            try {
                byte[] bytes = mapper.writeValueAsBytes(person);
                //System.out.println(bytes.length);
                JPerson person1 = mapper.readValue(bytes, JPerson.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        // protobuf
        Person sam = Person.newBuilder()
                .setName("sam")
                .setAge(10)
                .build();
        Runnable proto = () -> {
            try {
                byte[] bytes = sam.toByteArray();
                //System.out.println(bytes.length);
                Person sam1 = Person.parseFrom(bytes);
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
            }
        };

        for (int i = 0; i < 1; i++) {
            runPerformanceTest(jackson, "JSON");
            runPerformanceTest(proto, "PROTO");
        }


    }

    private static void runPerformanceTest(Runnable runnable, String method){
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            runnable.run();
        }
        long time2 = System.currentTimeMillis();

        System.out.println(
               method + " : " + (time2 - time1) + " ms"
        );
    }


}
