package br.com.tech4me.manufatura.manufatura.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

import br.com.tech4me.manufatura.manufatura.service.ManufaturaService;
import br.com.tech4me.manufatura.manufatura.shared.ManufaturaCompletoDto;
import br.com.tech4me.manufatura.manufatura.shared.ManufaturaDto;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/manufatura")
public class ManufaturaController {
    
    @Autowired
    private ManufaturaService servico;

    @PostMapping
    public ResponseEntity<ManufaturaCompletoDto> cadastrarManufatura(@RequestBody @Valid ManufaturaCompletoDto manufatura) {
        return new ResponseEntity<>(servico.cadastrar(manufatura), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ManufaturaCompletoDto>> obterManufatura() {
        return new ResponseEntity<>(servico.obterTodas(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ManufaturaDto> obterManufaturaPorId(@PathVariable String id) {
        Optional<ManufaturaDto> retorno = servico.obterPorId(id);
        
        if (retorno.isPresent()) {
            return new ResponseEntity<>(retorno.get(), HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirManufatura(@PathVariable String id) {
        servico.excluirPorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ManufaturaCompletoDto> atualizarManufatura(@PathVariable String id, @RequestBody ManufaturaCompletoDto manufatura) {
        Optional<ManufaturaCompletoDto> retorno = servico.atualizarPorId(id, manufatura);

        if (retorno.isPresent()) {
            return new ResponseEntity<>(retorno.get(), HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping("/porta")
    public String obterPorta(@Value("${local.server.port}") String porta) {
        return "A instância que responseu a requisição está rodando na porta" + porta;
    }
}
