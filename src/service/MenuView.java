package service;

public class MenuView {
    public void exibirMenu(){
        System.out.println();
        System.out.println(montarMenu());
    }

    public String montarMenu(){
        return  """
               ----------- MENU -----------
               1. Cadastrar um novo pet
               2. Alterar os dados do pet cadastrado
               3. Deletar um pet cadastrado
               4. Listar todos os pets cadastrados
               5. Listar pets por algum critério (idade, nome, raça)
               6. Sair
               """;
    }
}
