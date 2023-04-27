package br.com.alura.challange.Adopet.Domain.Adocao;

import java.time.LocalDate;


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


