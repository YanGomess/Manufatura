package br.com.tech4me.demanda.demanda.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.tech4me.demanda.demanda.model.Demanda;

public interface DemandaRepository extends MongoRepository<Demanda, String>{
    
}
