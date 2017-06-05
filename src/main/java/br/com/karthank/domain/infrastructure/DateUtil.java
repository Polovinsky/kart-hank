package br.com.karthank.domain.infrastructure;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class DateUtil {

    public static final LocalTime getLocalTime(String str) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
        return LocalTime.parse(str, formatter);
    }

    public static final LocalTime getLocalTimeMillis(String str) {
        DateTimeFormatter formatter1 = new DateTimeFormatterBuilder().appendPattern("[m][:ss][.SSS]")
                .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
                .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
                .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
                .toFormatter();
        return LocalTime.parse(str, formatter1);
    }
}
