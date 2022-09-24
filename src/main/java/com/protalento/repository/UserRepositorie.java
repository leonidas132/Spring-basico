package com.protalento.repository;

import com.protalento.dto.UserDto;
import com.protalento.entidad.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.time.LocalDate;

import java.util.List;
import java.util.Optional;

@Repository //se utiliza para poder utlizar esta interface como dependencia
public interface UserRepositorie extends JpaRepository<User,Long> {
    // consulta JPQL (consulta atraves de objetos)


    // CONSULTA CON JPQL( SE DECLARA LA CONSULTA CON LA ANOTACION @QUERY)
    @Query("select u from User u where u.email=?1")
    Optional<User> findMyUserByEmail(String email);

    @Query("Select u from User u where u.name like ?1%") //ordenara apartir del nombre
    List<User> listaUsuarios (String name, Sort sort); //sort es una  clase que mos permite ordennar atributos

    @Query("SELECT u FROM User u WHERE u.id= ?1")
    Optional<User>findByUserById(long id);

    @Override
    void delete(User entity); //query method

   // CONSULTA JPQL CON QUERY METHODS

    List<User> findByName(String name);// query method
    Optional<User> findByEmailAndName(String email, String name);// QUERY METHOD CON LA SENTNECIA and

    List<User> findByNameLike(String name); //encontrar un usuario apartir de un caracter
    List<User> findByNameOrEmail(String name, String email); //usando el operador or

    List<User> findByBirthdayBetween(LocalDate begin ,LocalDate end);// consultar entre un rango de fecha

    List<User> findByNameLikeOrderByIdDesc(String name);//consulta pe un nombre y ordena poe id de manera desn


    //CONSULTA ATRAVEZ DE JPQL CON NAME PARAMETERS
    /*este metodo resibimos dos parametros que
    * iniciaran los parametros de la sentencia
    * y estamos retribuyendo los valores de la entidad User
    * a el contructor de la clase UserDto*/
    @Query("SELECT new com.protalento.dto.UserDto(ase.id, ase.name, ase.birthday) "+
            " From User ase "+
            " where ase.birthday=:parametroFecha "+
            " and ase.email=:parametroEmail ")
    Optional<List<UserDto>> getAllByBirthdayAndEmail(@Param("parametroFecha") LocalDate date, @Param("parametroEmail") String email);
}
