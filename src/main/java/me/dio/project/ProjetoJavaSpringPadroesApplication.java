package me.dio.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ProjetoJavaSpringPadroesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoJavaSpringPadroesApplication.class, args);
	}

}
