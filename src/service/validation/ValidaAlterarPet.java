package service.validation;

import exception.BuscarPetValidationException;

public class ValidaAlterarPet {
    public static void validaTipoObrigatorio(String criterio){
        if(criterio.isBlank() || criterio.isEmpty()){
            throw new BuscarPetValidationException("Critério de busca não pode ser vazio");
        }
        if(!criterio.contains("tipo")){
            throw new BuscarPetValidationException("O critério tipo é obrigatório!");
        }
    }
}
