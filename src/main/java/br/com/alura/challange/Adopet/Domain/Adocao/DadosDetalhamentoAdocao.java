package br.com.alura.challange.Adopet.Domain.Adocao;

import java.time.LocalDateTime;

public record DadosDetalhamentoAdocao(Long id, Long idTutor, Long idPet, LocalDateTime data) {
}


