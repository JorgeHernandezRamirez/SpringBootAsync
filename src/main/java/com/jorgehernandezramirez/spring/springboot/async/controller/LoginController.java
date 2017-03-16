package com.jorgehernandezramirez.spring.springboot.async.controller;

import com.jorgehernandezramirez.spring.springboot.async.service.api.ILoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private ILoginService loginService;

    public LoginController(){
        //Para Spring
    }

    @RequestMapping(method = RequestMethod.POST)
    public String getUsers(@RequestParam("username") String username,
                @RequestParam("password") final String password){
        final String tokenToReturn = loginService.doLogin(username, password);
        loginService.refreshUserData(username);
        LOGGER.info("Procediendo a devolver los usuarios del sistema...");
        return tokenToReturn;
    }
}
