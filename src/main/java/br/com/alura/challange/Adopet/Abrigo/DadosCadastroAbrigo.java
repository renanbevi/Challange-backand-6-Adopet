package br.com.alura.challange.Adopet.Abrigo;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroAbrigo(
        @NotBlank
        String nome,
        @NotBlank
        String cidade,
        @NotBlank
        String estado
) {
}
