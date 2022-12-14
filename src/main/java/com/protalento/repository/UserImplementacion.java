package com.protalento.repository;

import com.protalento.SpringBasicoApplication;
import com.protalento.entidad.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;

public class UserImplementacion implements Crud{
    private final Log LOGGER = LogFactory.getLog(UserImplementacion.class);
    private  UserRepositorie userRepositorie;

    public UserImplementacion(UserRepositorie userRepositorie) {
        this.userRepositorie = userRepositorie;
    }

    @Override
    public void consultando(String correo){
       LOGGER.info("consultando: "+userRepositorie.findMyUserByEmail(correo).orElseThrow(() -> new RuntimeException("no existe el correo")));
    }

    /**
     *
     * este metodo nos permite consultar
     * una lista de usuario y ordenarla
     * lops nombre por id y de manera desendente
     * Sort.by() nos permite ordernar a travez de una propiedad
     * en esté cáso por id
      */
    @Override
    public void orderByName(String name) {
        userRepositorie.listaUsuarios(name, Sort.by("id").descending()).stream().forEach(user -> LOGGER.info("ORDENADO CON SORT " + user) );
    }

    @Override
    public void getQueryById(long id) {
        //orElseThrow() Si hay un valor presente, devuelve el valor; de lo contrario, lanza NoSuchElementException.
        LOGGER.info("QUERYING USER BY ID ;" +userRepositorie.findByUserById(id).orElseThrow(() -> new RuntimeException("EL ID NO EXISYE")));
    }

    @Override
    public void getDeleteById(User o) {
        userRepositorie.delete(o);
        LOGGER.info("SE ELIMINO EL USUARIO");
    }

    @Override
    public void getQueryWhitQueryMethods(String nombre) {
        userRepositorie.findByName(nombre).stream().forEach(user1 -> LOGGER.info("QUERYING WHIT QUERY METHODS: "+ user1));
    }

    @Override
    public void getQueryinByEmailAndName(String email, String name) {
       LOGGER.info("CONSULTA CORREO Y CLAVE: "+ userRepositorie.findByEmailAndName(email,name)); ;
    }


    @Override
    public void getQueryinWhitLike(String name) {
        userRepositorie.findByNameLike(name).stream().forEach(us -> LOGGER.info("QUERYIN NAME BY CARACTER USING THE OPERATOR lIKE:"  + us  ));
    }

    @Override
    public void getQueryNameOrEmail(String name, String email) {
        userRepositorie.findByNameOrEmail(null,email).stream().forEach(usuario -> LOGGER.info("QUERYIN NAME BY CARACTER USING THE OPERATOR OR:" +usuario));
    }

    @Override
    public void getQueryByDate(LocalDate begin, LocalDate end) {

    }

}
