package br.com.karthank;

import br.com.karthank.domain.KartHank;
import br.com.karthank.domain.model.Volta;

import java.io.FileNotFoundException;
import java.util.List;

public class Hanking {

    private static final String LOCAL_FILE = "src/main/resources/race-log.txt";

    public static void main(String[] args) throws FileNotFoundException {
        KartHank kartHank = new KartHank(LOCAL_FILE);
        List<Volta> voltas = kartHank.hanking();
        voltas.forEach(volta -> System.out.println(volta.toString()));
    }
}
