package com.jorgehernandezramirez.spring.springboot.async.service.impl;

import com.jorgehernandezramirez.spring.springboot.async.service.api.ILoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class LoginDummyService implements ILoginService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginDummyService.class);

    private static final String DUMMYTOKEN = "DUMMYTOKEN";

    public LoginDummyService(){
        //Para Spring
    }

    @Override
    public String doLogin(String principal, String credenctial) {
        LOGGER.info("Realizando login del usuario {}", principal);
        return DUMMYTOKEN;
    }

    @Async
    @Override
    public void refreshUserData(String principal) {
        try {
            Thread.sleep(10000);
            LOGGER.info("Se ha refrescado los datos del usuario {}", principal);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
