package service;

import exception.InvalidNumberException;

import java.util.Scanner;

public class MenuController {
    ArquivoService arquivoService = new ArquivoService();
    PetService petService = new PetService();

    Scanner sc = new Scanner(System.in);
    public static final String NAO_INFORMADO = "NÃO INFORMADO";

    public void executador(int opcao){
        if(opcao == 0 || opcao < 0){
            throw new InvalidNumberException("Número invalido!");
        }
        switch (opcao){
            case 1:
                cadastrarPet();
                break;

            case 2:
                alterarDados();
                break;
            case 3:
                deletarPet();
                break;
            case 4:
                listarTodosPets();
                break;

            case 5:
                listarPorCriterio();
                break;

            case 6:
                break;

            default:
                System.out.println("Opção inválida!");

        }
    }

    private void cadastrarPet(){
        System.out.println("Opção selecionada: Cadastrar Pet");
        arquivoService.lerArquivo();
        petService.cadastrarPet();

    }
    private void alterarDados(){
        System.out.println("Opção selecionada: Alterar os dados do pet cadastrado");
    }

    private void deletarPet(){
        System.out.println("Opção selecionada: Deletar um pet cadastrado");
    }

    private void listarTodosPets(){
        System.out.println("Opção selecionada: Listar todos os pets cadastrados");
    }

    private void listarPorCriterio(){
        System.out.println("Opção selecionada: Listar pets por algum critério (idade, nome, raça)");
    }

}
