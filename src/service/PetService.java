package service;

import entities.Pet;
import exception.IdadePesoValidationException;
import exception.NomeValidationException;
import service.validation.ValidaCadastroPet;

public class PetService {
    private final ArquivoService arquivoService;

    public PetService(ArquivoService arquivoService) {
        this.arquivoService = arquivoService;
    }

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
            System.out.println("Pet cadastrado!");

        } catch (NomeValidationException e) {
            System.out.println("Erro ao cadastrar pet! " + e.getMessage());

        } catch (IdadePesoValidationException e) {
            System.out.println("Erro ao cadastrar pet! " + e.getMessage());
        }

    }


}
