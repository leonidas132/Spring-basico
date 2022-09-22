package com.protalento.repository;

import com.protalento.entidad.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository //se utiliza para poder utlizar esta interface como dependencia
public interface UserRepositorie extends JpaRepository<User,Long> {
    @Query("select u from User u where u.email=?1") // consulta pql (consulta atraves de objetos)
    Optional<User> findMyUserByEmail(String email);

    @Query("Select u from User u where u.name like ?1%") //ordenara apartir del nombre
    List<User> listaUsuarios (String name, Sort sort); //sort es una  clase que mos permite ordennar atributos

    @Query("SELECT u FROM User u WHERE u.id= ?1")
    Optional<User>findByUserById(long id);


    @Override
    void delete(User entity); //query method

    List<User> findByName(String name);// query method

    Optional<User> findByEmailAndName(String email, String name);
}
