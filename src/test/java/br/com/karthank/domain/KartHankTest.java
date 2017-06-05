package br.com.karthank.domain;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalTime;
import java.util.Arrays;

public class KartHankTest {

    private KartHank kartHank;

    @Before
    public void setUp() throws Exception {
        kartHank = new KartHank();
    }

    @Test
    public void getHora_ComListaDeVoltas_deveRetornarAMaisRapida() throws Exception {

        String strHora = "23:49:08.277";
        LocalTime time = kartHank.getHora(Arrays.asList(strHora, strHora));
        Assert.assertThat(time, Matchers.is(kartHank.getMelhorVolta()));
    }
}