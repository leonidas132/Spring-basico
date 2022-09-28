package com.protalento.controller;

import com.protalento.caseuser.CreateUser;
import com.protalento.caseuser.DeleteUser;
import com.protalento.caseuser.GetUser;
import com.protalento.caseuser.UpdateUser;
import com.protalento.entidad.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/users")
public class UserRestController {
    //create,get,delete,Update

     private GetUser getUser;
     private CreateUser createUser;

     private DeleteUser deleteUser;

     private UpdateUser updateUser;

    public UserRestController(GetUser getUser, CreateUser createUser,DeleteUser deleteUser, UpdateUser updateUser) {
        this.getUser = getUser;
        this.createUser = createUser;
        this.deleteUser = deleteUser;
        this.updateUser = updateUser;
    }

    @GetMapping("/all") //Para procesar las solicitudes de obtención de dato
    List<User> get(){
        return getUser.getAll();
    }

    @PostMapping("/")//para enviar datos atravez de solicitudes http
    ResponseEntity<User> newUser(@RequestBody User newUser){
        return new ResponseEntity<>(createUser.save(newUser), HttpStatus.CREATED);// HttpStatus.CREATED nos devuelve el codigo de estado 201
    }

    @PutMapping("/{id}")
    ResponseEntity<User> replaceUser(@RequestBody User newUser,@PathVariable Long id){
        return new ResponseEntity<>(updateUser.update(newUser,id),HttpStatus.OK);
    }


    @DeleteMapping("/{id}") // path por donde se consumira el servicio y se eliminara
    ResponseEntity deleteUser(@PathVariable Long id){  // relaciona
        deleteUser.remove(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT); //  USAMOS NO CONTENT POR QUE VA HACER SUCEFULL LA RESPUESTA PERO NO VAMOS A RECIBIR CONTENIDO
    }




}
