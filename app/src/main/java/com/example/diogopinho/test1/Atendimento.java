package com.example.diogopinho.test1;

import java.util.Date;

/**
 * Created by João Cardoso on 17/05/2018.
 */

public class Atendimento {
    private String dia_semana;
    private Date hora_inicio;
    private Date hora_fim;

    public Atendimento(String dia_semana, Date hora_inicio , Date hora_fim) {
        this.setDia_semana(dia_semana);
        this.setHora_inicio(hora_inicio);
        this.setHora_fim(hora_fim);
    }

    public String getDia_semana() {
        return dia_semana;
    }

    public void setDia_semana(String dia_semana) {
        this.dia_semana = dia_semana;
    }

    public Date getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(Date hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public Date getHora_fim() {
        return hora_fim;
    }

    public void setHora_fim(Date hora_fim) {
        this.hora_fim = hora_fim;
    }
}
