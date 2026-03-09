package service;

import entities.Pet;
import exception.IdadePesoValidationException;
import exception.NomeValidationException;
import service.validation.ValidaCadastroPet;
import view.MenuView;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PetService {
    private final ArquivoService arquivoService;
    Scanner sc = new Scanner(System.in);

    public PetService(ArquivoService arquivoService) {
        this.arquivoService = arquivoService;
    }

    public List<Pet> petsCadastrados = new ArrayList<>();

    public void cadastrarPet(Pet pet) {
        try {
            ValidaCadastroPet.validarNome(pet.getNome());

            if (!pet.getIdade().isBlank()) {
                String retiraTexto = pet.getIdade().replaceAll("[^0-9.]", "");
                Double idadeToDouble = Double.valueOf(retiraTexto);
                ValidaCadastroPet.validaPeso(idadeToDouble);

            } else {
                pet.setIdade(ValidaCadastroPet.validaCampoNulo(pet.getIdade()));

            }

            if (!pet.getPeso().isBlank()) {
                String retiraTexto = pet.getPeso().replaceAll("[^0-9.]", "");
                Double pesoToDouble = Double.valueOf(retiraTexto);
                ValidaCadastroPet.validaIdade(pesoToDouble);

            } else {
                pet.setPeso(ValidaCadastroPet.validaCampoNulo(pet.getPeso()));
            }

            ValidaCadastroPet.validaCampoNulo(pet.getEndereco().getNumCasa());

            arquivoService.criarArquivo(pet);
            petsCadastrados.add(pet);
            System.out.println("Pet cadastrado!");

        } catch (NomeValidationException e) {
            System.out.println("Erro ao cadastrar pet! " + e.getMessage());

        } catch (IdadePesoValidationException e) {
            System.out.println("Erro ao cadastrar pet! " + e.getMessage());
        }

    }

    public void buscaPetCriterio(String[] criterios, List<File> arquivos) {
        int contador = 1;
        boolean encontrou = false;

        for (File arquivo : arquivos) {
            try {
                List<String> linhas = Files.readAllLines(arquivo.toPath());
                String conteudo = String.join(" ", linhas).toLowerCase();
                boolean atende = false;

                for (String criterio : criterios) {
                    criterio = criterio.trim().toLowerCase();
                    if (conteudo.contains(criterio)) {
                        atende = true;
                        break;
                    }
                }
                if (atende) {
                    System.out.println(contador + ". " + String.join(" - ", linhas));
                    contador++;
                    encontrou = true;
                }

            } catch (IOException e) {
                System.out.println("Erro ao ler arquivo: " + arquivo.getName());
            }
        }
        if (!encontrou) {
            System.out.println("Pet não encontrado!");
        }
    }
    
    public void buscaTodosPet(List<File> arquivos){
        int contador = 1;
        for (File arquivo : arquivos) {
            try {
                List<String> linhas = Files.readAllLines(arquivo.toPath());
                String conteudo = contador + ". " + String.join(" - ", linhas);
                System.out.println(conteudo);

                contador++;

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    

    public String[] coletaCriterios(){
        MenuView.exibeMenuBuscar();
        System.out.print("Digite o(s) critério(s): ");
        String entrada = sc.nextLine().toLowerCase().trim();

        String[] formataEntrada = entrada.split(" e ");
        String[] criterios = new String[formataEntrada.length + 1];

        System.out.print("Digite o tipo do pet: ");
        criterios[0] = sc.nextLine();

        for(int i = 0; i < formataEntrada.length; i++){
            System.out.print("Digite o " + formataEntrada[i] + ": ");
            criterios[i + 1] = sc.nextLine();
        }

        return criterios;
    }

    public List<File> listaArquivos(){
        File pasta = new File("petsCadastrados");
        File[] arquivos = pasta.listFiles();

        if(arquivos == null){
            return new ArrayList<>();
        }

        return Arrays.asList(arquivos);
    }
}

