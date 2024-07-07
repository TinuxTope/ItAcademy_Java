package cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.security;

import cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.exceptions.PlayerNotFoundException;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.model.repository.PlayerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class ApplicationConfiguration {
    private final PlayerRepository playerRepository;

    public ApplicationConfiguration(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Bean
    UserDetailsService userDetailsService() {
        return name -> (UserDetails) playerRepository.findByName(name)
                .orElseThrow(() -> new PlayerNotFoundException("User Not Found."));
    }

    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }
}