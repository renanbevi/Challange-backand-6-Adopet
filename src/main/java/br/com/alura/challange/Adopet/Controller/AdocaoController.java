package br.com.alura.challange.Adopet.Controller;


import br.com.alura.challange.Adopet.Domain.Adocao.AdocaoService;
import br.com.alura.challange.Adopet.Domain.Adocao.DadosAdocao;
import br.com.alura.challange.Adopet.Domain.Adocao.DadosCadastroAdocao;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/adocao")
public class AdocaoController {

    @Autowired
    private AdocaoService service;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroAdocao dados){
        var adocao = service.cadastroAdocao(dados);
        return ResponseEntity.ok(new DadosAdocao(adocao));
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarAdocao(@PathVariable Long id){
        service.deletarAdocao(id);
        return ResponseEntity.ok("Adoção apagada com sucesso");


    }

}
