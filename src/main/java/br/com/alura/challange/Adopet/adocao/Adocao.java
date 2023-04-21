package br.com.alura.challange.Adopet.adocao;


import br.com.alura.challange.Adopet.Pets.Pets;
import br.com.alura.challange.Adopet.Tutor.Tutor;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
;




@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(of = {"id", "data"})

@Entity
@Table(name="adocoes")

public class Adocao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "tutor_id")
    private Tutor tutor;

    @OneToOne
    @JoinColumn(name = "pet_id")
    private Pets pets;


      public Adocao(DadosCadastroAdocao dados, Tutor tutor, Pets pets){
        this.tutor = tutor;
        this.pets = pets;
        this.data = dados.data();

    }

}
