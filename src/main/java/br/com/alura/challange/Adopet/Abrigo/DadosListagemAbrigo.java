package br.com.alura.challange.Adopet.Abrigo;

import br.com.alura.challange.Adopet.Tutor.DadosListagemTutor;

public record DadosListagemAbrigo(Long id, String nome, String cidade, String estado) {

    public DadosListagemAbrigo(Abrigo abrigo){
        this(abrigo.getId(), abrigo.getNome(), abrigo.getCidade(), abrigo.getEstado());
    }


}
