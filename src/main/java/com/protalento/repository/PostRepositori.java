package com.protalento.repository;

import com.protalento.entidad.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //se utiliza para poder utlizar esta interface como dependencia
public interface PostRepositori extends JpaRepository<Post,Long> {

}
