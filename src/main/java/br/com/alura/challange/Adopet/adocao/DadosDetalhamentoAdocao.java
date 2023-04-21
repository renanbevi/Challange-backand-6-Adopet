package br.com.alura.challange.Adopet.adocao;

import java.time.LocalDateTime;

public record DadosDetalhamentoAdocao(Long id, Long idTutor, Long idPet, LocalDateTime data) {
}


