package br.com.karthank.domain;

import br.com.karthank.domain.infrastructure.DateUtil;
import br.com.karthank.domain.model.Piloto;
import br.com.karthank.domain.model.Volta;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class KartHank {

    private static String LOCAL_FILE = "src/main/resources/race-log.txt";
    private static final int HORA = 0;
    private static final int ID = 1;
    private static final int NOME = 3;
    private static final int VOLTA = 4;
    private static final int TEMPO_VOLTA = 5;
    private static final int VELOCIDADE_MEDIA = 6;

    public KartHank(final String LOCAL_FILE) {
        this.LOCAL_FILE = LOCAL_FILE;
    }

    protected List<Volta> startRace() throws FileNotFoundException {

        List<Volta> voltas = new ArrayList<>();
        Scanner scanner = new Scanner(new File(LOCAL_FILE), "UTF-8");
        String line;
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            String[] columns = line.split("\\s+");
            Volta volta = new Volta(
                    DateUtil.getLocalTime(columns[HORA]),
                    new Piloto(Long.parseLong(columns[ID]), columns[NOME]),
                    Integer.valueOf(columns[VOLTA]),
                    DateUtil.getLocalTimeMillis(columns[TEMPO_VOLTA]),
                    new BigDecimal(columns[VELOCIDADE_MEDIA].replace(",", ".")).setScale(3)
            );
            voltas.add(volta);
        }
        return voltas;
    }

    protected List<Volta> getPilotosVoltaQuatro(List<Volta> voltas) {
        Stream<Volta> campeoes = voltas.stream().filter(volta -> volta.getVolta() == 4);
        return campeoes.collect(Collectors.toList());
    }

    protected List<Volta> ordemPorPilotoMaisRapido(List<Volta> pilotosVoltaQuatro) {
        Collections.sort(pilotosVoltaQuatro, (o1, o2) -> {
            if (o1.getTempoVolta().isAfter(o2.getTempoVolta())) return 1;
            if (o1.getTempoVolta().isBefore(o2.getTempoVolta())) return -1;
            return 0;
        });
        return pilotosVoltaQuatro;
    }

    public List<Volta> hanking() throws FileNotFoundException {
        List<Volta> todasAsVoltas = startRace();
        List<Volta> pilotos4Voltas = getPilotosVoltaQuatro(todasAsVoltas);
        return ordemPorPilotoMaisRapido(pilotos4Voltas);
    }
}
