/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domain.User;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 *
 * @author Nick de Kort
 */
@Singleton
@Startup
public class StartUp {

    @Inject 
    private KwetterService service;
      
    public StartUp() {
        //
    }
     
    @PostConstruct
    private void intData() {
        service.register("username", "password", "displayName", "avatar", "biography", "location", "website", true);
    }
    
}
