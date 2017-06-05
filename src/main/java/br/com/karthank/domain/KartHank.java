package br.com.karthank.domain;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class KartHank {

    private LocalTime melhorVolta;

    public LocalTime getHora(List<String> strHora) {

        strHora.forEach(hora -> {
            LocalTime instance = LocalTime.parse("00:00:00.000");
            LocalTime time = getLocalTime(hora);
            if (time.isAfter(instance)) {
                melhorVolta = instance.with(time);
            }
        });

        return melhorVolta;
    }

    private LocalTime getLocalTime(String str) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
        return LocalTime.parse(str, formatter);
    }

    public LocalTime getMelhorVolta() {
        return melhorVolta;
    }
}
