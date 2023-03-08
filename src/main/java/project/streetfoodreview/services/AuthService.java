package project.streetfoodreview.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.streetfoodreview.controllers.request.UserRegisterRequest;
import project.streetfoodreview.entities.User;
import project.streetfoodreview.repository.UserRepository;

@Service
@AllArgsConstructor
@Slf4j
public class AuthService {

    @Autowired
    UserRepository userRepository;

    public boolean register(UserRegisterRequest request) {
        var existingUsername = userRepository.findByName(request.getUsername());

        if (existingUsername.size() > 0)
            return false;

        var newUser = User.builder()
                .name(request.getUsername())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();

        userRepository.save(newUser);

        return true;
    }
}
