package br.com.tech4me.manufatura.manufatura.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.manufatura.manufatura.model.Manufatura;
import br.com.tech4me.manufatura.manufatura.repository.ManufRepository;
import br.com.tech4me.manufatura.manufatura.shared.ManufaturaCompletoDto;
import br.com.tech4me.manufatura.manufatura.shared.ManufaturaDto;

@Service
public class ManufaturaServiceImpl implements ManufaturaService{

    @Autowired
    private ManufRepository repositorio;

    @Override
    public List<ManufaturaCompletoDto> obterTodas() {
        List<Manufatura> manufaturas = repositorio.findAll();

        return manufaturas.stream()
                        .map(p -> new ModelMapper().map(p, ManufaturaCompletoDto.class))
                        .collect(Collectors.toList());
    }

    @Override
    public Optional<ManufaturaDto> obterPorId(String id) {
        Optional<Manufatura> manufatura = repositorio.findById(id);

        if (manufatura.isPresent()) {
        return Optional.of(new ModelMapper().map(manufatura.get(), ManufaturaDto.class));
        }
        return Optional.empty();
    }

    @Override
    public void excluirPorId(String id) {
        repositorio.deleteById(id);      
    }

    @Override
    public ManufaturaCompletoDto cadastrar(ManufaturaCompletoDto dto) {
        Manufatura manufatura = new ModelMapper().map(dto, Manufatura.class);
        repositorio.save(manufatura);

        return new ModelMapper().map(manufatura, ManufaturaCompletoDto.class);
    }

    @Override
    public Optional<ManufaturaCompletoDto> atualizarPorId(String id, ManufaturaCompletoDto dto) {
        Optional<Manufatura> retorno = repositorio.findById(id);

        if (retorno.isPresent()) {
            Manufatura manufatura = new ModelMapper().map(dto, Manufatura.class);
            manufatura.setId(id);
            repositorio.save(manufatura);
            return Optional.of(new ModelMapper().map(manufatura, ManufaturaCompletoDto.class));

        } else {
            return Optional.empty();
        }
    }

    
}
