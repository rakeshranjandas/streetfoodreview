package project.streetfoodreview.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.streetfoodreview.controllers.request.UserRegisterRequest;
import project.streetfoodreview.services.AuthService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@AllArgsConstructor
@RequestMapping("/v1/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody final UserRegisterRequest request) {

        if (!authService.register(request)) {
            return new ResponseEntity<>("username already exists", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }


}
