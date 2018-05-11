/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ikatoo.agendamentobackend;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @author mckatoo
 */

@ApplicationPath("rest")
public class App extends ResourceConfig {
    public App(){
        packages("br.com.ikatoo.agendamentobackend.controllers");
        register(ResponseFilter.class);
    }
}