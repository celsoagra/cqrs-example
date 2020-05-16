package me.celso.agra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"me.celso.agra"})
public class CqrsExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(CqrsExampleApplication.class, args);
	}

}
