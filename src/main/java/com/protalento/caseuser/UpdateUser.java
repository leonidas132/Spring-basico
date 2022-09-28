package com.protalento.caseuser;

import com.protalento.entidad.User;
import com.protalento.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class UpdateUser {
    private UserService service;

    public UpdateUser(UserService service) {
        this.service = service;
    }

    public User update(User newUser, Long id) {
       return service.update(newUser,id);
    }
}
