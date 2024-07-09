package cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.config.initializer;

import cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.model.domain.Player;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.model.domain.enums.Role;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.model.repository.PlayerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;
@Configuration
public class DataInitializer {
    private final PlayerRepository playerRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(PlayerRepository playerRepository, PasswordEncoder passwordEncoder) {
        this.playerRepository = playerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public CommandLineRunner initDatabase() {
        return args -> {

            Optional<Player> adminPlayer = playerRepository.findByEmail("admin@example.com");

            if (adminPlayer.isEmpty()) {
                Player admin = new Player();
                admin.setName("Admin");
                admin.setEmail("admin@example.com");
                admin.setPassword(passwordEncoder.encode("adminpassword"));
                admin.setRegisterDate(new java.util.Date());
                admin.setRole(Role.ROLE_ADMIN);

                playerRepository.save(admin);
                System.out.println("Administrador creado: admin@example.com / adminpassword");
            }
        };
    }
}
