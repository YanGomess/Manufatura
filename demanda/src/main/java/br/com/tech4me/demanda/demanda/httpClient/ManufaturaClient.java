package br.com.tech4me.demanda.demanda.httpClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.tech4me.demanda.demanda.model.Manufatura;

@FeignClient("manufatura")
public interface ManufaturaClient {
    
    @RequestMapping(method = RequestMethod.GET, value = "/manufatura/{id}")
    Manufatura obterManufatura(@PathVariable String id);
}
