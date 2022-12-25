package project.streetfoodreview.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import project.streetfoodreview.entities.User;
import project.streetfoodreview.repository.UserRepository;


@Service
@AllArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository repository;

    public User getUserDataFromId(long id) throws Exception {
        return repository.findById(id)
                         .orElseThrow(() -> {
                             log.error("User info not found for id {}", id);
                             return new Exception("User not found");
                         });
    }
}
