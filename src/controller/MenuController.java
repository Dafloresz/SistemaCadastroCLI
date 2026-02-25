package controller;

import java.util.Scanner;

public class MenuController {
    private PetController controller;

    public MenuController(PetController controller){
        this.controller = controller;
    }

    public void executador(int opcao) {
        switch (opcao) {
            case 1:
                controller.cadastrar();
                break;

            case 2:
                controller.alterarDados();
                break;
            case 3:
                controller.deletarPet();
                break;
            case 4:
                controller.listarTodosPets();
                break;

            case 5:
                controller.listarPetPorCriterio();
                break;

            default:
                System.out.println("Opção inválida!");

        }
    }

}
