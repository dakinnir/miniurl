package com.repo.utils;

public class URLShortenerUtils {
    public static String generateShortCode(int length) {
        String AlphaNumericStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyz0123456789";
        // creating a StringBuffer size of AlphaNumericStr
        StringBuilder shortCode = new StringBuilder(length);
        for (int i=0; i<length; i++) {
            //generating a random number using math.random()
            int ch = (int)(AlphaNumericStr.length() * Math.random());
            shortCode.append(AlphaNumericStr.charAt(ch));
        }

        return shortCode.toString();
    }
}
