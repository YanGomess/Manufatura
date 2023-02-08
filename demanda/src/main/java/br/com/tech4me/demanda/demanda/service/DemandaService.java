package br.com.tech4me.demanda.demanda.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.demanda.demanda.shared.DemandaCompletoDto;
import br.com.tech4me.demanda.demanda.shared.DemandaDto;

public interface DemandaService {
    
    List<DemandaCompletoDto> obterDemandas();
    Optional<DemandaDto> obterDemandaPorId(String id);
    void excluirDemanda(String id);
    DemandaCompletoDto cadastrarDemanda(DemandaCompletoDto dto);
    Optional<DemandaDto> atualizarDemandaPorId(String id, DemandaDto dto);
}
