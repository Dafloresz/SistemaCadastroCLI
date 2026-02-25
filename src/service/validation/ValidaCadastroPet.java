package service.validation;

import exception.IdadePesoValidationException;
import exception.NomeValidationException;

public class ValidaCadastroPet {
    public static final String NAO_INFORMADO = "NÃO INFORMADO";

    public static void validarNome(String nome) throws NomeValidationException {
        if (nome == null || nome.isBlank()) {
            throw new NomeValidationException("O pet deve ter um nome!");
        }

        if (!nome.trim().contains(" ")) {
            throw new NomeValidationException("Deve conter nome e sobrenome!");
        }

        if (nome.matches(".*[!@#$%&*].*")) {
            throw new NomeValidationException("Por favor, sem caracteres especiais no nome!");
        }
    }

    public static void validaIdade(Double idade) {
        if (idade > 20) {
            throw new IdadePesoValidationException("Idade não pode ser maior que 20 anos");
        }

    }

    public static void validaPeso(Double peso) {
        if (peso <= 0.5 || peso >= 60) {
            throw new IdadePesoValidationException("Peso deve ser maior que 0.5 gramas e menor que 60kg!");
        }

    }

    public static String validaCampoNulo(String valor) {
        if (valor == null || valor.isBlank()) {
            valor = NAO_INFORMADO;
        }
        return valor;
    }
}
