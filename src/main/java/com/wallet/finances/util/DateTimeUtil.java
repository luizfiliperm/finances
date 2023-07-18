package com.wallet.finances.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("MM-dd-yyyy");

    public static LocalDate convertStringToLocalDate(String date) {
        return LocalDate.parse(date, FORMATTER);
    }
}
