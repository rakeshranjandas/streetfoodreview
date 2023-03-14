package project.streetfoodreview.services;

import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import project.streetfoodreview.entities.UserLogin;

import java.nio.file.attribute.UserPrincipalNotFoundException;

@Service
@AllArgsConstructor
public class PrincipalService {

    public long setReferenceUserId(long userId) throws Exception{
        if (userId > 0)
            return userId;

        return getPrincipalId();
    }

    public long getPrincipalId() throws Exception {

        SecurityContext securityContext = SecurityContextHolder.getContext();

        if (securityContext.getAuthentication() == null)
            throw new UserPrincipalNotFoundException("Prinicipal not found.");

        var principal = (UserLogin) securityContext.getAuthentication().getPrincipal();

        return principal.getId();
    }
}
