package com.example.diogopinho.test1;

import java.util.Date;


class Atendimento {
    private String dia_semana;
    private Date hora_inicio;
    private Date hora_fim;

    Atendimento(String dia_semana, Date hora_inicio, Date hora_fim) {
        this.setDia_semana(dia_semana);
        this.setHora_inicio(hora_inicio);
        this.setHora_fim(hora_fim);
    }

    String getDia_semana() {
        return dia_semana;
    }

    private void setDia_semana(String dia_semana) {
        this.dia_semana = dia_semana;
    }

    Date getHora_inicio() {
        return hora_inicio;
    }

    private void setHora_inicio(Date hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    Date getHora_fim() {
        return hora_fim;
    }

    private void setHora_fim(Date hora_fim) {
        this.hora_fim = hora_fim;
    }
}
