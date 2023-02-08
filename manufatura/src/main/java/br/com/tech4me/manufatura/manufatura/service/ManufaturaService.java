package br.com.tech4me.manufatura.manufatura.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.manufatura.manufatura.shared.ManufaturaCompletoDto;
import br.com.tech4me.manufatura.manufatura.shared.ManufaturaDto;

public interface ManufaturaService {
    List<ManufaturaCompletoDto> obterTodas();
    Optional<ManufaturaDto> obterPorId(String id);
    void excluirPorId(String id);
    ManufaturaCompletoDto cadastrar(ManufaturaCompletoDto dto);
    Optional<ManufaturaCompletoDto> atualizarPorId(String id, ManufaturaCompletoDto dto);
}
