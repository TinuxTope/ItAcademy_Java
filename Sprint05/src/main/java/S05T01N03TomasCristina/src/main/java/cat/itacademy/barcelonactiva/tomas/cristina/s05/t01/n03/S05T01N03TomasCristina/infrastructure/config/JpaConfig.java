package cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.infrastructure.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@Profile("jpa")
@EnableJpaRepositories(basePackages = "cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.domain.repository.jpa")
public class JpaConfig {
}
