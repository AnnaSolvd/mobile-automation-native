package com.solvd.service;

import java.security.SecureRandom;
import java.util.Random;

public class DataGeneratorService {

    private static final Random random = new SecureRandom();

    public static String generateRandomString(int length) {
        String candidateChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(candidateChars.charAt(random.nextInt(candidateChars.length())));
        }
        return sb.toString();
    }

    public static String generateRandomData(int stringLength) {
        return generateRandomString(stringLength);
    }
}