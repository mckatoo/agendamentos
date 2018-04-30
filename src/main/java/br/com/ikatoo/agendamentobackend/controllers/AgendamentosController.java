/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ikatoo.agendamentobackend.controllers;

import br.com.ikatoo.agendamentobackend.models.Agendamentos;
import br.com.ikatoo.agendamentobackend.models.dao.AgendamentosDAO;
import java.text.ParseException;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author mckatoo
 */
@Path("agendamentos")
public class AgendamentosController {

    private final AgendamentosDAO dao = new AgendamentosDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public List<Agendamentos> listAgendamentos() throws ParseException {
        
        return dao.findAll();

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}/")
    public Agendamentos getCurso(@PathParam("id") int id) throws ParseException {

        System.out.println(id);

        return dao.findById(id);

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response create(Agendamentos agendamento) {

        dao.save(agendamento);
        
        return Response.status(Response.Status.OK).build();
        
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response update(Agendamentos agendamento) {
        
        dao.save(agendamento);
        
        return Response.status(Response.Status.OK).build();
        
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}/")
    public Response delete(@PathParam("id") int id) {
        
        dao.remove(id);
        
        return Response.status(Response.Status.OK).build();
        
    }
}
