package com.ruby.protobuf;

import com.ruby.models.Credentials;
import com.ruby.models.EmailCredentials;
import com.ruby.models.PhoneOTP;

public class OneOfDemo07 {

    public static void main(String[] args) {

        EmailCredentials emailCredentials = EmailCredentials.newBuilder()
                .setEmail("nobody@gmail.com")
                .setPassword("admin123")
                .build();

        PhoneOTP phoneOTP = PhoneOTP.newBuilder()
                .setNumber(1231231234)
                .setCode(456)
                .build();

        Credentials credentials = Credentials.newBuilder()
                .setEmailMode(emailCredentials)
                .setPhoneMode(phoneOTP)

                .build();

        login(credentials);
    }

    private static void login(Credentials credentials){

        switch (credentials.getModeCase()){
            case EMAILMODE:
                System.out.println(credentials.getEmailMode());
                break;
            case PHONEMODE:
                System.out.println(credentials.getPhoneMode());
                break;
        }

    }

}
