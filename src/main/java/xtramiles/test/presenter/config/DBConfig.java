package xtramiles.test.presenter.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = {"xtramiles.test.data.db.jpa.entities"})
@EnableJpaRepositories(basePackages = {"xtramiles.test.data.db.jpa.repositories"})
public class DBConfig {
}
