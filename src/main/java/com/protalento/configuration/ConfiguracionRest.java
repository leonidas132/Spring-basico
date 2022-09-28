package com.protalento.configuration;

import com.protalento.caseuser.GetUser;
import com.protalento.caseuser.ImplUser;
import com.protalento.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfiguracionRest {

    @Bean
    GetUser getUser(UserService service){
        return new ImplUser(service);
    }

}
