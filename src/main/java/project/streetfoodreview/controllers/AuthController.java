package project.streetfoodreview.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.streetfoodreview.controllers.request.UserLoginRequest;
import project.streetfoodreview.controllers.request.UserRegisterRequest;
import project.streetfoodreview.controllers.response.AuthResponse;
import project.streetfoodreview.services.AuthService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@AllArgsConstructor
@RequestMapping("/v1/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody final UserRegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponse> authenticate(@RequestBody final UserLoginRequest request) {
        return ResponseEntity.ok(authService.authenticate(request));
    }
}
