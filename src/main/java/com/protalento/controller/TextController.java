package com.protalento.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TextController {
    @RequestMapping ("")//anotacion que nos permite resibir todas las peticiones http
    @ResponseBody // nos permite reponder un cuerpo a nivel de servicios
    public ResponseEntity<String> funcion(){
        return new ResponseEntity<>("hola mundo con REST controller", HttpStatus.OK);
    }

}
