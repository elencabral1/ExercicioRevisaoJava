package iasi.CP2.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import iasi.CP2.model.Brinquedo;
import iasi.CP2.repository.BrinquedoRepositorio;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class BrinquedoController {
    @Autowired
    BrinquedoRepositorio brinquedoRepositorio;

    @GetMapping("/brinquedos")
    public ResponseEntity<List<EntityModel<Brinquedo>>> getAllBrinquedos(@RequestParam(required = false) String nome) {
        try {
            List<Brinquedo> brinquedos = new ArrayList<Brinquedo>();

            if (nome == null)
                brinquedoRepositorio.findAll().forEach(brinquedos::add);
            else
                brinquedoRepositorio.findByNameContaining(nome).forEach(brinquedos::add);

            if (brinquedos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            List<EntityModel<Brinquedo>> brinquedosModel = brinquedos.stream()
                    .map(brinquedo -> EntityModel.of(brinquedo,
                            linkTo(methodOn(BrinquedoController.class).getBrinquedoById(brinquedo.getId())).withSelfRel()))
                    .collect(Collectors.toList());

            return new ResponseEntity<>(brinquedosModel, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/brinquedos/{id}")
    public ResponseEntity<EntityModel<Brinquedo>> getBrinquedoById(@PathVariable("id") long id) {
        Brinquedo brinquedo = brinquedoRepositorio.findById(id);

        if (brinquedo != null) {
            EntityModel<Brinquedo> brinquedoModel = EntityModel.of(brinquedo,
                    linkTo(methodOn(BrinquedoController.class).getAllBrinquedos(null)).withRel("brinquedos"));
            return new ResponseEntity<>(brinquedoModel, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/brinquedos")
    public ResponseEntity<String> createBrinquedo(@RequestBody Brinquedo brinquedo) {
        try {
            brinquedoRepositorio.save(brinquedo);
            return new ResponseEntity<>("Brinquedo foi criado com sucesso.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/brinquedos/{id}")
    public ResponseEntity<String> updateBrinquedo(@PathVariable("id") long id, @RequestBody Brinquedo brinquedo) {
        Brinquedo _brinquedo = brinquedoRepositorio.findById(id);

        if (_brinquedo != null) {
            _brinquedo.setId(id);
            _brinquedo.setNome(brinquedo.getNome());
            _brinquedo.setTipo(brinquedo.getTipo());
            _brinquedo.setClassificacao(brinquedo.getClassificacao());
            _brinquedo.setTamanho(brinquedo.getTamanho());
            _brinquedo.setPreco(brinquedo.getPreco());

            brinquedoRepositorio.update(_brinquedo);
            return new ResponseEntity<>("Brinquedo foi atualizado com sucesso.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Não foi encontrada Brinquedo com id=" + id, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/brinquedos/{id}")
    public ResponseEntity<String> deleteBriquedo(@PathVariable("id") long id) {
        try {
            int result = brinquedoRepositorio.deleteById(id);
            if (result == 0) {
                return new ResponseEntity<>("Não foi encontrado Brinquedo com id=" + id, HttpStatus.OK);
            }
            return new ResponseEntity<>("Brinquedo foi deletada com sucesso.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Não é possível deletar Brinquedo.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/brinquedos")
    public ResponseEntity<String> deleteAllBrinquedos() {
        try {
            int numRows = brinquedoRepositorio.deleteAll();
            return new ResponseEntity<>("Deletados " + numRows + " Brinquedo(s) com sucesso.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Não é possível deletar Brinquedo.", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
