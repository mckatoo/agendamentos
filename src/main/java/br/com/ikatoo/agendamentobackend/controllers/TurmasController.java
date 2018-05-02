/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ikatoo.agendamentobackend.controllers;

import br.com.ikatoo.agendamentobackend.models.Turmas;
import br.com.ikatoo.agendamentobackend.models.dao.TurmasDAO;
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
@Path("turmas")
public class TurmasController {

    private final TurmasDAO dao = new TurmasDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public List<Turmas> listTurmas() throws ParseException {
        
        return dao.findAll();

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}/")
    public Turmas getTurma(@PathParam("id") int id) throws ParseException {

        System.out.println(id);

        return dao.findById(id);

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/curso/{id}/")
    public Turmas getCurso(@PathParam("id") int id) throws ParseException {

        System.out.println(id);

        return (Turmas) dao.findCursos(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response create(Turmas turma) {

        dao.save(turma);
        
        return Response.status(Response.Status.OK).build();
        
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response update(Turmas turma) {
        
        dao.save(turma);
        
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
