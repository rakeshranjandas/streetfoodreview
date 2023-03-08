package project.streetfoodreview.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import project.streetfoodreview.config.JwtService;
import project.streetfoodreview.controllers.request.UserLoginRequest;
import project.streetfoodreview.controllers.request.UserRegisterRequest;
import project.streetfoodreview.controllers.response.AuthResponse;
import project.streetfoodreview.entities.User;
import project.streetfoodreview.repository.UserRepository;

@Service
@AllArgsConstructor
@Slf4j
public class AuthService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private final JwtService jwtService;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private final AuthenticationManager authenticationManager;

    public AuthResponse register(UserRegisterRequest request) {
        var existingUsername = userRepository.findAllByName(request.getUsername());

        if (existingUsername.size() > 0) {
            return AuthResponse.builder()
                    .token("")
                    .error("username already exists.")
                    .build();
        }

        var newUser = User.builder()
                .name(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();

        userRepository.save(newUser);

        var jwtToken = jwtService.generateToken(newUser);

        return AuthResponse.builder().token(jwtToken).build();
    }

    public AuthResponse authenticate(UserLoginRequest request) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                    request.getUsername(),
                    request.getPassword()
            )
        );

        var users = userRepository.findAllByName(request.getUsername());
        System.out.println(users);


        if (users.size() == 0) {
            return AuthResponse.builder().error("bad login").build();
        }


        var user = users.get(0);
        var jwtToken = jwtService.generateToken(user);

        return AuthResponse.builder().token(jwtToken).build();
    }
}
