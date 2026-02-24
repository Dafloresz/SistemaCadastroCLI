package service;

import entities.Pet;
import entities.Sexo;
import entities.Tipo;
import exception.InvalidNumberException;

import java.util.Scanner;

public class PetService {
    Scanner sc = new Scanner(System.in);

    private ArquivoService service = new ArquivoService();
    private Pet pet;

    public void cadastrarPet(){
        try{
            System.out.print("Nome e sobrenome: ");
            String nome = sc.nextLine();

            System.out.print("Tipo (Cachorro/Gato): ");
            String tipoUsuario = sc.nextLine();
            Tipo tipo = Tipo.valueOf(tipoUsuario.toUpperCase());

            System.out.print("Sexo: ");
            String sexoUsuario = sc.nextLine();
            Sexo sexo = Sexo.valueOf(sexoUsuario.toUpperCase());

            System.out.print("Número da casa: ");
            String numCasa = sc.nextLine();
            System.out.print("Cidade: ");
            String cidade = sc.nextLine();
            System.out.print("Rua: ");
            String rua = sc.nextLine();
            String endereco = rua + ", " + numCasa + ", " + cidade;

            System.out.print("Idade: ");
            Double idade = Double.parseDouble(sc.nextLine());


            System.out.print("Peso: ");
            Double peso = Double.parseDouble(sc.nextLine());

            System.out.print("Raça: ");
            String raca = sc.nextLine();

            Pet pet = new Pet(nome, tipo, sexo, endereco, idade, peso, raca);
            service.criarArquivo(pet);

            // FALTA AS EXCEcoeES E CONDIcoES

        } catch (RuntimeException e){
            e.getMessage();
        }

    }


}
