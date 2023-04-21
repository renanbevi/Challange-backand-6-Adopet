package br.com.alura.challange.Adopet.Controller;


import br.com.alura.challange.Adopet.adocao.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
