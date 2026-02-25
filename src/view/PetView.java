package view;

import entities.Endereco;
import entities.Pet;
import entities.Sexo;
import entities.Tipo;

import java.util.Scanner;

public class PetView {
    Scanner sc = new Scanner(System.in);

    public Pet coletarDados() {
        System.out.println("");

        System.out.print("Nome e sobrenome: ");
        String nome = sc.nextLine();

        System.out.print("Tipo (Cachorro/Gato): ");
        String tipoUsuario = sc.nextLine();
        Tipo tipo = Tipo.valueOf(tipoUsuario.toUpperCase());

        System.out.print("Sexo (Macho/Femea): ");
        String sexoUsuario = sc.nextLine();
        Sexo sexo = Sexo.valueOf(sexoUsuario.toUpperCase());

        System.out.println("-- Endereço --");
        System.out.print("Nome da rua: ");
        String nomeRua = sc.nextLine();
        System.out.print("Número da casa: ");
        String numCasa = sc.nextLine();
        System.out.print("Cidade: ");
        String cidade = sc.nextLine();

        Endereco endereco = new Endereco(numCasa, cidade, nomeRua);

        System.out.print("Idade: ");
        String idade = sc.nextLine();

        System.out.print("Peso: ");
        String peso = sc.nextLine();

        System.out.print("Raça: ");
        String raca = sc.nextLine();

        return new Pet(nome, tipo, sexo, endereco, idade, peso, raca);

    }
}
