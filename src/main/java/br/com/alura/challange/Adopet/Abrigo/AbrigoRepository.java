package br.com.alura.challange.Adopet.Abrigo;

import br.com.alura.challange.Adopet.Tutor.Tutor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbrigoRepository extends JpaRepository<Abrigo, Long> {
    Page<Abrigo> findAll(Pageable paginacao);

}
