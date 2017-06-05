package br.com.karthank.domain;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class KartHankTest {

    private KartHank kartHank;

    @Before
    public void setUp() throws Exception {
        kartHank = new KartHank();
    }

    @Test
    public void name_informandoListaDeHorarios_deveInformarOMenor() throws Exception {


        String menorVolta = kartHank.getMenorVolta();
        Assert.assertThat(menorVolta, Matchers.is("1.0"));
    }

}