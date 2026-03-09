package view;

public class MenuView {
    public static void exibirMenu(){
        System.out.println();
        System.out.println(montarMenu());
    }

    public static String montarMenu(){
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
    public static void exibeMenuBuscar(){
        System.out.println();
        System.out.println(menuBuscarPet());
    }


    public static String menuBuscarPet(){
        return """
               ----------- Buscar pet -----------
               Selecione 1 ou 2 critérios!
               
               - Nome ou Sobrenome
               - Sexo
               - Idade
               - Peso
               - Raça
               - Endereço
               """;
    }
}
