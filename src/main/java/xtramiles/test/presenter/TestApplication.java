package xtramiles.test.presenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;

@SpringBootApplication(scanBasePackages = {"xtramiles.test.presenter", "xtramiles.test.data.db.jpa"})
public class TestApplication {

	@PostConstruct
	void init() {
		System.out.println("Hello World!");
	}

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}
}
