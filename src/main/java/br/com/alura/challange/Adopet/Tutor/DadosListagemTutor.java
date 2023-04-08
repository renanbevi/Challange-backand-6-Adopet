package br.com.alura.challange.Adopet.Tutor;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public record DadosListagemTutor(Long id, String nome, String email) {

    public DadosListagemTutor(Tutor tutor){
        this(tutor.getId(), tutor.getNome(), tutor.getEmail());

    }





}
