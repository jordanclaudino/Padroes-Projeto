package me.dio.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableFeignClients
@SpringBootApplication
@EntityScan(basePackages = {
		"me.dio.project.model"
})
@EnableJpaRepositories(basePackages = {
		"me.dio.project.repository"
})
public class ProjetoJavaSpringPadroesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoJavaSpringPadroesApplication.class, args);
	}

}
