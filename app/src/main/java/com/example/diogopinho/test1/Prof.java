package com.example.diogopinho.test1;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

class Prof {
    private String nome;
    private ArrayList <Atendimento> horario = new ArrayList<>();
    private String Nome_Sala;

    Prof(String nome, String nome_Sala) {
        this.setNome(nome);
        setNome_Sala(nome_Sala);
    }

    void add_tempo(String dia_semana, Date hora_inicio, Date hora_fim){
        Atendimento a = new Atendimento(dia_semana,hora_inicio,hora_fim);
        horario.add(a);
    }

    String verifica_atendimento(){
        Date currentTime = Calendar.getInstance().getTime();
        Date time = new Date(0,0,0,currentTime.getHours()+1,currentTime.getMinutes());
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        String dia_da_semana = null;
        switch (day) {
            case 1 : dia_da_semana = "Domingo";
            break;
            case 2 : dia_da_semana = "Segunda-Feira";
            break;
            case 3 : dia_da_semana = "Terça-Feira";
            break;
            case 4 : dia_da_semana = "Quarta-Feira";
            break;
            case 5 : dia_da_semana = "Quinta-Feira";
            break;
            case 6 : dia_da_semana = "Sexta-Feira";
            break;
            case 7 : dia_da_semana = "Sabádo";
            break;
        }
        System.out.println(dia_da_semana);
        for (int i = 0 ; i<horario.size();i++){
            if (horario.get(i).getDia_semana().equals(dia_da_semana)){
                if (time.after(horario.get(i).getHora_inicio()) && !time.after(horario.get(i).getHora_fim())){
                    return "Direções";
                }
            }
        }
        return this.getNome()+" de momento não está em atendimento deseja na mesma as direções?";
    }

    String getNome() {
        return nome;
    }

    private void setNome(String nome) {
        this.nome = nome;
    }

    /*public void setHorario(ArrayList<Atendimento> horario) {
        this.horario = horario;
    }*/

    String getNome_Sala() {
        return Nome_Sala;
    }

    private void setNome_Sala(String id_Sala) {
        Nome_Sala = id_Sala;
    }
}
