package br.com.karthank.domain;

import br.com.karthank.domain.infrastructure.DateUtil;
import br.com.karthank.domain.model.Piloto;
import br.com.karthank.domain.model.Volta;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KartHank {

    public static final int HORA = 0;
    public static final int ID = 1;
    public static final int NOME = 3;
    public static final int VOLTA = 4;
    public static final int TEMPO_VOLTA = 5;
    public static final int VELOCIDADE_MEDIA = 6;

    public List<Volta> startRace(String file) throws FileNotFoundException {

        List<Volta> voltas = new ArrayList<>();
        Scanner scanner = new Scanner(new File(file), "UTF-8");
        String line;
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            String[] columns = line.split("\\s+");
            voltas.add(new Volta(
                    DateUtil.getLocalTime(columns[HORA]),
                    new Piloto(Long.parseLong(columns[ID]), columns[NOME]),
                    Integer.valueOf(columns[VOLTA]),
                    DateUtil.getLocalTimeMillis(columns[TEMPO_VOLTA]),
                    new BigDecimal(columns[VELOCIDADE_MEDIA].replace(",", ".")).setScale(3)
            ));
        }
        return voltas;
    }
}
