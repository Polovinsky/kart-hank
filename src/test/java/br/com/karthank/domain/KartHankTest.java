package br.com.karthank.domain;

import br.com.karthank.domain.model.Volta;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class KartHankTest {

    private static final String LOCAL_FILE = "src/main/resources/race-log.txt";
    private KartHank kartHank;

    @Before
    public void setUp() throws Exception {
        kartHank = new KartHank(LOCAL_FILE);
    }

    @Test
    public void startCorrida_comArquivoRaceLog_deveRetornarInfoCadaPiloto() throws Exception {
        List<Volta> race = kartHank.startRace();
        Assert.assertThat(race, Matchers.not(Matchers.empty()));
    }

    @Test
    public void buscarPilotosComQatroVoltas_comListaDeVoltas_deveRetornarListaComVolta4() throws Exception {
        List<Volta> voltasCampoes = kartHank.getPilotosVoltaQuatro(kartHank.startRace());
        Assert.assertThat(voltasCampoes, Matchers.hasSize(5));
    }

    @Test
    public void ordemPorPilotoMaisRapido_comListaVoltas_deveRetornarListaOrdenadaPorPilotoMaisRapido()
            throws Exception {

        List<Volta> ordemMaisRapido =
                kartHank.ordemPorPilotoMaisRapido(kartHank.getPilotosVoltaQuatro(kartHank.startRace()));

        Assert.assertThat(ordemMaisRapido, Matchers.hasSize(5));
        Assert.assertThat(ordemMaisRapido.get(0).getPiloto().getId(), Matchers.is(38L));
        Assert.assertThat(ordemMaisRapido.get(1).getPiloto().getId(), Matchers.is(2L));
        Assert.assertThat(ordemMaisRapido.get(2).getPiloto().getId(), Matchers.is(33L));
        Assert.assertThat(ordemMaisRapido.get(3).getPiloto().getId(), Matchers.is(23L));
        Assert.assertThat(ordemMaisRapido.get(4).getPiloto().getId(), Matchers.is(15L));
    }
}