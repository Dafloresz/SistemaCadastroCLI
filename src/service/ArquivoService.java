package service;

import entities.Pet;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArquivoService {
    public void lerArquivo(){
        Scanner sc = new Scanner(System.in);
        List<String> mensagemUsuario = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader("arquivos/formulario.txt"))) {
            String line = br.readLine();

            while (line != null){
                System.out.println(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());;
        }
    }

    public void criarArquivo(Pet pet){
        List<String> respostaUsuario = new ArrayList<>();
        respostaUsuario.add(pet.getNome());
        respostaUsuario.add(String.valueOf(pet.getTipo()));
        respostaUsuario.add(String.valueOf(pet.getSexo()));
        respostaUsuario.add(pet.getLocalEncontrado());
        respostaUsuario.add(pet.getIdade() + "anos");
        respostaUsuario.add(pet.getPeso() + "kg");
        respostaUsuario.add(pet.getRaca());

        LocalDateTime horario = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm");


        String path = "petsCadastrados\\" + horario.format(formatter).replace("-", "")
                + "-" + pet.getNome().replace(" ", "").toUpperCase() + ".txt";

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
            for(String resposta : respostaUsuario){
                int num = 1;
                bw.write(num + " - " + resposta);
                bw.newLine();
                num++;
            }

        } catch (IOException e){
            System.out.println("Erro ao criar arquivo: " + e.getMessage());
        }

    }
}
