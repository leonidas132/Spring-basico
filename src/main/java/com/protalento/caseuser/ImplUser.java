package com.protalento.caseuser;

import com.protalento.entidad.User;
import com.protalento.services.UserService;

import java.util.List;

public class ImplUser implements GetUser {
    private UserService service;

    public ImplUser(UserService service) {
        this.service = service;
    }

    @Override
    public List<User> getAll() {
        return service.getAllUsers();
    }
}
