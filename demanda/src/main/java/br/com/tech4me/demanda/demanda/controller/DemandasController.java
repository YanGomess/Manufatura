package br.com.tech4me.demanda.demanda.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4me.demanda.demanda.service.DemandaService;
import br.com.tech4me.demanda.demanda.shared.DemandaCompletoDto;
import br.com.tech4me.demanda.demanda.shared.DemandaDto;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/demandas")
public class DemandasController {
    
    @Autowired
    private DemandaService servico;

    @PostMapping
    public ResponseEntity<DemandaCompletoDto> cadastrarDemanda(@RequestBody @Valid DemandaCompletoDto demanda) {
        return new ResponseEntity<>(servico.cadastrarDemanda(demanda), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DemandaCompletoDto>> obterDemandas() {
        return new ResponseEntity<>(servico.obterDemandas(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DemandaDto> obterDemandaPorId(@PathVariable String id) {
        Optional<DemandaDto> retorno = servico.obterDemandaPorId(id);

        if (retorno.isPresent()) {
            return new ResponseEntity<>(retorno.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirDemanda(@PathVariable String id) {
        servico.excluirDemanda(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DemandaDto> atualizarDemanda(@PathVariable String id, @Valid DemandaDto demanda) {
        Optional<DemandaDto> retorno = servico.atualizarDemandaPorId(id, demanda);

        if (retorno.isPresent()) {
            return new ResponseEntity<>(retorno.get(), HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
