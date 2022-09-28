package com.protalento.caseuser;


import com.protalento.services.UserService;

import org.springframework.stereotype.Component;


@Component // marca la clase Java como un bean
public class DeleteUser {
    private UserService service;


    public DeleteUser(UserService service) {
        this.service = service;

    }

    public void remove(Long id){
        service.remove(id);
    }


}
