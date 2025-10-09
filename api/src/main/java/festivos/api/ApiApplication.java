package festivos.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "festivos")
@EnableJpaRepositories(basePackages = {"repositories", "festivos.infraestructura"}) 
@EntityScan(basePackages = {"festivos.dominio", "entities"})
@ComponentScan(basePackages = {"festivos.api", "services"})
public class ApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }
}