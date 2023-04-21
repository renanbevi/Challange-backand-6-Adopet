package br.com.alura.challange.Adopet.Controller;

import br.com.alura.challange.Adopet.Abrigo.*;
import br.com.alura.challange.Adopet.Pets.DadosListagemPets;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("abrigos")
public class AbrigoController {

    @Autowired
    private AbrigoRepository abrigoRepository;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroAbrigo dados) {
        abrigoRepository.save(new Abrigo(dados));
        return ResponseEntity.ok("Abrigo cadastrado com sucesso");
    }

    @GetMapping
    public ResponseEntity listar() {
        var abrigo = abrigoRepository.findAll();
        if (abrigo.isEmpty()) {
            return ResponseEntity.ok("Não encontrado");
        }
        return ResponseEntity.ok(abrigo.stream().map(DadosListagemAbrigo::new).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity listarAbrigoporID(@PathVariable Long id) throws Exception {
        var abrigo = abrigoRepository.getReferenceById(id);
        if (!abrigoRepository.existsById(id)) {
            throw new Exception("Id informado não existe");
        }
        return ResponseEntity.ok(new DadosListagemAbrigo(abrigo));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarAbrigo(@RequestBody @Valid DadosAtualizacaoAbrigo dados) {
        try {


            var abrigo = abrigoRepository.getReferenceById(dados.id());
            abrigo.atualizarInformacoes(dados);
            return ResponseEntity.ok("Atualização efetuada com sucesso");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.ok("Abrigo não encontrado");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarAbrigo(@PathVariable Long id) {
        try {
            var abrigo = abrigoRepository.getReferenceById(id);
            abrigoRepository.delete(abrigo);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.ok("Abrigo não encontrado para deletar");
        }
    }
}


