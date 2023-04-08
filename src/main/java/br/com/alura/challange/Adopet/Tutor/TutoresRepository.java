package br.com.alura.challange.Adopet.Tutor;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TutoresRepository extends JpaRepository<Tutor, Long> {

    Page<Tutor> findAll(Pageable paginacao);

}
