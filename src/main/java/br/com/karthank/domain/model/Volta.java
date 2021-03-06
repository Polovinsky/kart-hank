package br.com.karthank.domain.model;

import java.math.BigDecimal;
import java.time.LocalTime;

public class Volta {

    private LocalTime hora;
    private Piloto piloto;
    private Integer volta;
    private LocalTime tempoVolta;
    private BigDecimal velocidadeMedia;

    public Volta(LocalTime hora, Piloto piloto, int volta, LocalTime tempoVolta, BigDecimal velocidadeMedia) {
        this.hora = hora;
        this.piloto = piloto;
        this.volta = volta;
        this.tempoVolta = tempoVolta;
        this.velocidadeMedia = velocidadeMedia;
    }

    public int getVolta() {
        return volta;
    }

    public LocalTime getTempoVolta() {
        return tempoVolta;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    @Override
    public String toString() {
        return hora + "  " + piloto.getId() + " - " + piloto.getNome() + "  " + volta + "  " + tempoVolta + "  " + velocidadeMedia;
    }
}
