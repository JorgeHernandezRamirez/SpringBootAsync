package com.jorgehernandezramirez.spring.springboot.async.service.api;


/**
 * Api de login del usuario
 */
public interface ILoginService {

    /**
     * Método que realiza el login del usuario
     * @param principal
     * @param credenctial
     * @return
     */
    String doLogin(String principal, String credenctial);

    /**
     * Método que refresca los datos del usuario
     * @param principal
     */
    void refreshUserData(String principal);
}
