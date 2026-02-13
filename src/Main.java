import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        LocalTime horaAtual = LocalTime.now();
        int hora = horaAtual.getHour();

        System.out.println("Olá, " +  mensagemDoDia(hora) + "!");
       try (BufferedReader br = new BufferedReader(new FileReader("formulario.txt"))) {
           String line = br.readLine();

           while(line != null){
               System.out.println(line);
               line = br.readLine();
           }
       } catch (IOException e) {
           System.out.println("Error: " + e.getMessage());;
       }

        System.out.println("----------------- MENU ----------------");
    }

    static String mensagemDoDia(int hora){
        String mensagemDia;
        if (hora >= 5 && hora < 12){
          return  mensagemDia = "Bom dia";
        } else if (hora >= 12 && hora < 18) {
          return   mensagemDia = "Boa tarde";
        } else {
           return mensagemDia = "Boa noite";
        }
    }
}
