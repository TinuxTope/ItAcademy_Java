package cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.controllers;

import cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.config.auth.LoginUser;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.config.auth.RegisterUser;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.model.domain.Player;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.model.dto.LoginResponse;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.security.AuthenticationService;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.security.jwt.JwtService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationService authenticationService;

    @Operation(summary = "Registers a new player")
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterUser registerUser) {
        Player player = authenticationService.signup(registerUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(player);
    }

    @Operation(summary = "Authenticates a player and returns a JWT token")
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUser loginUser) {
        Player authenticatePlayer = authenticationService.authenticate(loginUser);
        String jwtToken = jwtService.generateToken(authenticatePlayer);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok().body(loginResponse);
    }
}
