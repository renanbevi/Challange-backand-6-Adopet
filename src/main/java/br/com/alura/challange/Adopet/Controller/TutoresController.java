package br.com.alura.challange.Adopet.Controller;

import br.com.alura.challange.Adopet.Tutor.*;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("tutores")
public class TutoresController {

    @Autowired
    private TutoresRepository tutoresRepository;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroTutor dados) {

        if (!dados.senha().equals(dados.confirmacaoSenha())) {
            return ResponseEntity.badRequest().body("Senha ou confirmação de senha não válida");
        }

        tutoresRepository.save(new Tutor(dados));
        return ResponseEntity.ok("Tutor cadastrado com sucesso");
    }

    @GetMapping("/{id}")
    public ResponseEntity listarTutor(@PathVariable Long id) throws Exception {

        var tutor = tutoresRepository.getReferenceById(id);

        if (!tutoresRepository.existsById(id)) {
            throw new Exception("Id informado não existe");
        }
        return ResponseEntity.ok(new DadosListagemTutor(tutor));

    }

    @PutMapping
    @Transactional
    public String atualizarTutor (@RequestBody @Valid DadosAtualizacaoTutor dados){
        var tutor = tutoresRepository.getReferenceById(dados.id());
        tutor.atualizaInformacoes(dados);

        return ResponseEntity.ok("Atualização efetuada com sucesso").getBody();
    }

    @GetMapping
    public ResponseEntity <Page<DadosListagemTutor>> listar(Pageable paginacao){
        var page = tutoresRepository.findAll(paginacao).map(DadosListagemTutor::new);
        return ResponseEntity.ok(page);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarTutor(@PathVariable Long id){
        var tutor = tutoresRepository.getReferenceById(id);
        tutoresRepository.delete(tutor);
        return ResponseEntity.noContent().build();


    }

}




