package br.com.alura.challange.Adopet.Controller;

import br.com.alura.challange.Adopet.Domain.Abrigo.Abrigo;
import br.com.alura.challange.Adopet.Domain.Abrigo.AbrigoRepository;
import br.com.alura.challange.Adopet.Domain.Pets.*;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("pets")
public class PetsController {

    @Autowired
    private PetsRepository petsRepository;
    @Autowired
    private AbrigoRepository abrigoRepository;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroPet dados){
        var abrigo = abrigoRepository.getReferenceById(dados.idAbrigo());
        var pet = new Pets(dados, abrigo);
        petsRepository.save(pet);
        return ResponseEntity.ok("Pet cadastrado com sucesso");

    }

    @GetMapping
    public ResponseEntity listar(DadosCadastroPet dados) {

        var pets = petsRepository.findAll();

        if (pets.isEmpty()) {
            return ResponseEntity.ok("Não encontrado");
        }
        return ResponseEntity.ok(pets.stream().map(DadosListagemPets::new).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity listarPetsPorID(@PathVariable Long id) throws Exception {

        var pets = petsRepository.getReferenceById(id);
        if(!petsRepository.existsById(id)) {
            throw new Exception("Id informado não existe");
        }
        return ResponseEntity.ok(new DadosListagemPets(pets));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarPet(@RequestBody @Valid DadosatualizacaoPet dados) {
        try {
            Abrigo abrigo = null;
            if (abrigo != null) {
                abrigo = abrigoRepository.getReferenceById(dados.idAbrigo());
            }
            var pet = petsRepository.getReferenceById(dados.id());
            pet.atualizadados(dados, abrigo);
            return ResponseEntity.ok(new DadosListagemPets(pet));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.ok("Pet não encontrado");
        }
    }
        @DeleteMapping("/{id}")
        public ResponseEntity deletePet(@PathVariable Long id)   {
           try{

            var pet = petsRepository.getReferenceById(id);
            petsRepository.delete(pet);
            return ResponseEntity.ok("Pet deletado");
           }catch (EntityNotFoundException e){
               return ResponseEntity.ok("Pet não encontrado para deletar");
           }
        }

   }

