package com.protalento.services;

import com.protalento.entidad.User;
import com.protalento.repository.UserRepositorie;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service //https://todosobreprogramacion.blogspot.com/2013/10/spring-como-manejar-transacciones-y-sus.html#:~:text=Una%20transacci%C3%B3n%20de%20base%20de,el%20proceso%20se%20echa%20atr%C3%A1s.
public class UserService {

    private final Log Logger = LogFactory.getLog(UserService.class);

    //inyectando dependencia

    private UserRepositorie userRepositorie;
    //contructor para la inyecsion de dependencia
    public UserService(UserRepositorie userRepositorie) {
        this.userRepositorie = userRepositorie;
    }

    // peek() para mostrar por consola los valores devueltos
    @Transactional // lo que nos permite es saber si ocurrio un error en la inserción y poder hacer un rollback de todos las transaciones que se hiciero en la base de datos
    public void getSaveTransactional(List<User> userList){
        userList.stream().peek(user -> Logger.info("USUARIOS INSERTADOS: "+ user)).forEach(userRepositorie::save); //en el for se hace un referenciado por la clase de esta manera tambien podemos iterrar
    }

    public List<User> getAllUsers(){
        return userRepositorie.findAll();
    }

}
