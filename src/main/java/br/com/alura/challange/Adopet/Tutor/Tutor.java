package br.com.alura.challange.Adopet.Tutor;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name ="tutores")
@Entity(name= "tutores")



@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of= "id")
public class Tutores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String senha;
    private String confirmacaoSenha;

    public Tutores(DadosCadastroTutor dados){
        this.name = dados.nome();
        this.email = dados.email();
        this.senha = dados.senha();
        this.confirmacaoSenha = dados.confirmacaoSenha();
    }

}
