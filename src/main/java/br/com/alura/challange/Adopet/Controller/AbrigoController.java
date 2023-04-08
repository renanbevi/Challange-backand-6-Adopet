package br.com.alura.challange.Adopet.Controller;

import br.com.alura.challange.Adopet.Abrigo.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("abrigos")
public class AbrigoController {

    @Autowired
    private AbrigoRepository abrigoRepository;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroAbrigo dados){

        abrigoRepository.save(new Abrigo(dados));
        return ResponseEntity.ok("Abrigo cadastrado com sucesso");
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemAbrigo>>listar(Pageable paginacao){
        var page = abrigoRepository.findAll(paginacao).map(DadosListagemAbrigo::new);
        return ResponseEntity.ok(page);
    }
    @GetMapping("/{id}")
    public ResponseEntity listarAbrigoporID(@PathVariable Long id) throws Exception {
        var abrigo = abrigoRepository.getReferenceById(id);
        if(!abrigoRepository.existsById(id)) {
            throw new Exception("Id informado não existe");
        }
        return ResponseEntity.ok(new DadosListagemAbrigo(abrigo));
        }
    @PutMapping
    @Transactional
    public String atualizarAbrigo(@RequestBody @Valid DadosAtualizacaoAbrigo dados){
        var abrigo = abrigoRepository.getReferenceById(dados.id());
        abrigo.atualizarInformacoes(dados);
        return ResponseEntity.ok("Atualização efetuada com sucesso").getBody();

    }
    @DeleteMapping("/{id}")
    public ResponseEntity deletarAbrigo(@PathVariable Long id){
        var abrigo = abrigoRepository.getReferenceById(id);
        abrigoRepository.delete(abrigo);
        return ResponseEntity.noContent().build();
    }

    }

