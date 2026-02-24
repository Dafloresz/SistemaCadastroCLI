import service.Mensagem;
import service.MenuController;
import service.MenuView;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MenuView menuView = new MenuView();
        MenuController menuController = new MenuController();

        System.out.println("Olá, " + Mensagem.mensagemDoDia() + "!");
        menuView.exibirMenu();

        System.out.print("Digite a opção: ");
        int respostaUsuario = sc.nextInt();

        menuController.executador(respostaUsuario);






    }


}
