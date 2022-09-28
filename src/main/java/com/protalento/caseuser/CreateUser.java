package com.protalento.caseuser;

import com.protalento.entidad.User;
import com.protalento.services.UserService;
import org.springframework.stereotype.Component;

@Component
public class CreateUser {
    private UserService service;

    public CreateUser(UserService service){
        this.service = service;
    }

    public User save(User newUser){
        return service.save(newUser);
    }

}
