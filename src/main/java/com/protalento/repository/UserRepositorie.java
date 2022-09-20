package com.protalento.repository;

import com.protalento.entidad.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //se utiliza para poder utlizar esta interface como dependencia

public interface UserRepositorie extends JpaRepository<User,Long> {



}
