package com.app.spring.angular.course.SpringAngularCourse.utils;

import java.security.SecureRandom;
import java.util.Random;
import java.util.UUID;

/**
 * Created by jose de leon on 5/3/2021.
 */
public class CodeGenerationUtil {

    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static SecureRandom rnd = new SecureRandom();

    public static String StringCodeGenerated(int len) {
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        return sb.toString();
    }


    public static String stringUUIDGenerator(){
        UUID uuid = UUID. randomUUID();
        String uuidAsString = uuid.toString();
        return uuidAsString;
    }

    String StringRandom(int len){
        StringBuilder sb = new StringBuilder(len);
        for(int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }



}
