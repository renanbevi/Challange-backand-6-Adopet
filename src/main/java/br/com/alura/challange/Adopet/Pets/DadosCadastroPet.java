package br.com.alura.challange.Adopet.Pets;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroPet(

        @NotBlank
        String nome,
        @NotBlank
        String descricao,
        @NotNull
        Boolean adotado,
        @NotBlank
        String idade,
        @NotBlank
        String imagem,
        @NotNull
        Long idAbrigo

) {
}
