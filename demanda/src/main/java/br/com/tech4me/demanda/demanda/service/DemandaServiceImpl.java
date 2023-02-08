package br.com.tech4me.demanda.demanda.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.demanda.demanda.httpClient.ManufaturaClient;
import br.com.tech4me.demanda.demanda.model.Demanda;
import br.com.tech4me.demanda.demanda.repository.DemandaRepository;
import br.com.tech4me.demanda.demanda.shared.DemandaCompletoDto;
import br.com.tech4me.demanda.demanda.shared.DemandaDto;

@Service
public class DemandaServiceImpl implements DemandaService {
    
    @Autowired
    private DemandaRepository repository;

    @Autowired
    private ManufaturaClient manufaturaClient;

    @Override
    public List<DemandaCompletoDto> obterDemandas() {
        List<Demanda> demandas = repository.findAll();
        List<DemandaCompletoDto> dto = demandas.stream().map(p -> new ModelMapper().map(p, DemandaCompletoDto.class)).collect(Collectors.toList());
        return dto;
    }

    @Override
    public Optional<DemandaDto> obterDemandaPorId(String id) {
        Optional<Demanda> demanda = repository.findById(id);

        if (demanda.isPresent()) {
            DemandaDto demandaComManufatura = new ModelMapper().map(demanda, DemandaDto.class);
            demandaComManufatura.setDadosManufatura(manufaturaClient.obterManufatura(demandaComManufatura.getIdManufatura()));
            return Optional.of(demandaComManufatura);
        } else {
            return Optional.empty();
        }   
    }

    @Override
    public void excluirDemanda(String id) {
        repository.deleteById(id);
        
    }

    @Override
    public DemandaCompletoDto cadastrarDemanda(DemandaCompletoDto dto) {
        Demanda demanda = new ModelMapper().map(dto, Demanda.class);

        repository.save(demanda);

        return new ModelMapper().map(demanda, DemandaCompletoDto.class);
    }

    @Override
    public Optional<DemandaDto> atualizarDemandaPorId(String id, DemandaDto dto) {
        Optional<Demanda> retorno = repository.findById(id);

        if (retorno.isPresent()) {
            Demanda demandaRetorno = new ModelMapper().map(dto, Demanda.class);
            demandaRetorno.setId(id);
            repository.save(demandaRetorno);

            return Optional.of(new ModelMapper().map(demandaRetorno, DemandaDto.class));
        } else {
            return Optional.empty();
        }
    }


}
