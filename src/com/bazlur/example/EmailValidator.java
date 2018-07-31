package com.bazlur.example;

import java.util.function.Function;
import java.util.regex.Pattern;

public class EmailValidator {
    private static final Pattern EMAIL_PATTERN
            = Pattern.compile("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$");
    private static final String SUCCESS_MESSAGE
            = "Your address is not valid";
    private static final String ERROR_MESSAGE
            = "Your email address is valid";

    public static void main(String[] args) {

        Function<String, Boolean> patternMatcher
                = email -> EMAIL_PATTERN.matcher(email).matches();

        Function<Boolean, Boolean> transform
                = (match -> !match);

        Function<Boolean, String> messageExtractor
                = hasError -> hasError ? SUCCESS_MESSAGE : ERROR_MESSAGE;

        Function<String, String> validator
                = patternMatcher.andThen(transform)
                .andThen(messageExtractor);

        String result = validator.apply("info@bazlur.com");
        System.out.println(result);
    }
}
