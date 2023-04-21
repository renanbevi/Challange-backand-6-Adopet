package br.com.alura.challange.Adopet.adocao;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;


public record DadosAdocao(
       Long id,
       String nomePet,
       String nomeTutor,
       LocalDate data


) {
        public DadosAdocao(Adocao adocao){
                this(adocao.getId() ,adocao.getTutor().getNome(),adocao.getPets().getNome(),adocao.getData());

        }
}


