package br.com.tech4me.manufatura.manufatura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ManufaturaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManufaturaApplication.class, args);
	}

}
