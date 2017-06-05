package br.com.karthank.domain;

import br.com.karthank.domain.model.Volta;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.List;

public class KartHankTest {

    private KartHank kartHank;

    @Before
    public void setUp() throws Exception {
        kartHank = new KartHank();
    }

    @Test
    public void startCorrida_comArquivoRaceLog_deveRetornarInfoCadaPiloto() throws Exception {

        String file = "src/main/resources/race-log.txt";
        List<Volta> race = kartHank.startRace(file);
        Assert.assertThat(race, Matchers.not(Matchers.empty()));
    }
}