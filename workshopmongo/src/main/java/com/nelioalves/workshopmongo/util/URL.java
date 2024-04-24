package com.nelioalves.workshopmongo.util;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/* There was the following Sonar Warning on this utility class: "Add a private constructor to hide the implicit public
 * one". Utility classes don't save any data or state; they only contain behavior. Since I didn't add a constructor to
 * this class, Java implicitly added a default public one, and the default constructor allows users to create an
 * instance of this class. To resolve this issue, I needed to create a private constructor with no arguments.
 * Based on: https://www.baeldung.com/java-sonar-hide-implicit-constructor */
public class URL {

    private URL() {
        throw new UnsupportedOperationException("This ia a utility class and cannot be instantiated");
    }

    public static String decodeParam(String text) {
        return URLDecoder.decode(text, StandardCharsets.UTF_8);
    }

    public static Date convertDate(String textDate, Date defaultValue) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        try {
            return sdf.parse(textDate);
        } catch (ParseException e) {
            return defaultValue;
        }
    }

}