package service;


import java.time.LocalTime;

public class Mensagem {
    public static String mensagemDoDia() {
        LocalTime horaAtual = LocalTime.now();
        int hora = horaAtual.getHour();
        String mensagemDia;

        if (hora >= 5 && hora < 12) {
            return mensagemDia = "Bom dia";
        } else if (hora >= 12 && hora < 18) {
            return mensagemDia = "Boa tarde";
        } else {
            return mensagemDia = "Boa noite";
        }
    }
}

