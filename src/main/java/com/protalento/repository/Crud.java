package com.protalento.repository;

import com.protalento.entidad.User;

import javax.persistence.Entity;
import java.time.LocalDate;

public interface Crud {
    public void consultando(String correo);

    public void orderByName(String paran);

    public void getQueryById(long id);

    public void getDeleteById(User o);

    /**
     * @param nombre es un estring
     * @return List<> una lista de nombres
     * repetidos
     * */
    public void getQueryWhitQueryMethods(String nombre);

    public void getQueryinByEmailAndName(String email, String name);

    public void getQueryinWhitLike(String name);

    public void getQueryNameOrEmail(String name, String email);

    public void getQueryByDate(LocalDate begin ,LocalDate end);

}
