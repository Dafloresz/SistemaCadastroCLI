package controller;

import entities.Pet;
import service.PetService;
import view.PetView;

public class PetController {
    private PetView petView;
    private PetService petService;

    public PetController(PetView petView, PetService petService) {
        this.petView = petView;
        this.petService = petService;
    }

    public void cadastrar() {
        System.out.println("Opção selecionada: Cadastrar um novo pet");
        Pet pet = petView.coletarDados();
        petService.cadastrarPet(pet);
    }

    public void alterarDados() {
        System.out.println("Opção selecionada: Alterar os dados do pet cadastrado");
    }

    public void deletarPet() {
        System.out.println("Opção selecionada: Deletar um pet cadastrado");
    }

    public void listarTodosPets() {
        System.out.println("Opção selecionada: Listar todos os pets cadastrados");
    }

    public void listarPetPorCriterio() {
        System.out.println("Opção selecionada: Listar pets por algum critério (idade, nome, raça)");
    }

}
