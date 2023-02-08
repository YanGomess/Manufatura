package br.com.tech4me.manufatura.manufatura.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.tech4me.manufatura.manufatura.model.Manufatura;

public interface ManufRepository extends MongoRepository<Manufatura, String>{
    
}
