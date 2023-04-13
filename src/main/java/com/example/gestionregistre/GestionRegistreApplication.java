package com.example.gestionregistre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.gestionregistre"},
        entityManagerFactoryRef = "entityManagerFactory",
        transactionManagerRef = "transactionManager" )
@ComponentScan(basePackages = {"com.gestionregistre"})
@EntityScan("com.gestionregistre")
@EnableSwagger2
public class GestionRegistreApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionRegistreApplication.class, args);
    }

}
