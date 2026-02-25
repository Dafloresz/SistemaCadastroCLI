import controller.MenuController;
import controller.PetController;
import exception.NumeroInvalidoException;
import service.ArquivoService;
import util.Mensagem;
import service.PetService;
import view.MenuView;
import view.PetView;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Dependências mais internas
        ArquivoService arquivoService = new ArquivoService();
        PetService petService = new PetService(arquivoService);
        PetView petView = new PetView();


        PetController petController = new PetController(petView, petService);
        MenuController menuController = new MenuController(petController);

        System.out.println("Olá, " + Mensagem.mensagemDoDia() + "!");

        int respostaUsuario;

        while (true) {
            MenuView.exibirMenu();

            try {
                System.out.print("Digite a opção: ");
                respostaUsuario = sc.nextInt();

                if (respostaUsuario <= 0 || respostaUsuario >= 8) {
                    throw new NumeroInvalidoException("Número invalido!");
                }

                if (respostaUsuario == 6) {
                    System.out.println("Saindo...");
                    break;
                }

                menuController.executador(respostaUsuario);

            } catch (InputMismatchException e) {
                System.out.println("Digite apenas números!");
                sc.nextLine();

            } catch (NumeroInvalidoException e) {
                System.out.println("Número inválido");
            }
        }


    }


}
