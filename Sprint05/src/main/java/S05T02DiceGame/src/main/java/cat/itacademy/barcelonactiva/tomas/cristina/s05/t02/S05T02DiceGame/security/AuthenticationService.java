package cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.security;

import cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.config.auth.LoginUser;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.config.auth.RegisterUser;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.exceptions.PlayerAlreadyExistsException;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.model.domain.Player;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.model.domain.enums.Role;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.model.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    public Player signup(RegisterUser registerUser) {
        if (playerRepository.findByEmail(registerUser.getEmail()).isPresent()) {
            throw new PlayerAlreadyExistsException("Player with email " + registerUser.getEmail() + " already exists");
        }

        Player player = new Player();
        player.setName(registerUser.getUsername());
        player.setEmail(registerUser.getEmail());
        player.setPassword(passwordEncoder.encode(registerUser.getPassword()));
        player.setRegisterDate(new java.util.Date());
        player.setRole(Role.ROLE_USER);

        return playerRepository.save(player);
    }

    public Player authenticate(LoginUser loginUser) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword())
        );

        return (Player) authentication.getPrincipal();
    }
}
