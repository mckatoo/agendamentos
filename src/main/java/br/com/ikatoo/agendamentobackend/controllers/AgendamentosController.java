/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ikatoo.agendamentobackend.controllers;

import br.com.ikatoo.agendamentobackend.models.Agendamentos;
import br.com.ikatoo.agendamentobackend.models.Turmas;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public List<Agendamentos> listAgendamentos() throws ParseException {
        Agendamentos agend1 = new Agendamentos();
        agend1.setDia(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2001"));
        agend1.setAmplificador(true);
        agend1.setDatashow(true);
        
//        agend1.setIdCurso(0);
//        agend1.setIdProfessor(0);
//        agend1.setIdTurma(0);

        agend1.setPreaula(true);
        agend1.setPrimeirop(true);
        agend1.setSegundop(true);

        Agendamentos agend2 = new Agendamentos();
        agend2.setDia(new SimpleDateFormat("dd/MM/yyyy").parse("22/02/2001"));
        agend2.setAmplificador(false);
        agend2.setDatashow(true);
        agend2.setIdCurso(1);
        agend2.setIdProfessor(3);
        agend2.setIdTurma(2);
        agend2.setPreaula(false);
        agend2.setPrimeirop(true);
        agend2.setSegundop(false);

        Agendamento agend3 = new Agendamento();
        agend3.setDia(new SimpleDateFormat("dd/MM/yyyy").parse("25/03/2003"));
        agend3.setAmplificador(false);
        agend3.setDatashow(false);
        agend3.setIdCurso(3);
        agend3.setIdProfessor(1);
        agend3.setIdTurma(0);
        agend3.setPreaula(false);
        agend3.setPrimeirop(false);
        agend3.setSegundop(false);

        List<Agendamento> agendamentos = new ArrayList<>();
        agendamentos.add(agend1);
        agendamentos.add(agend2);
        agendamentos.add(agend3);

        return agendamentos;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}/")
    public Agendamento getAgendamento(@PathParam("id") long id) throws ParseException {

        Agendamento agend1 = new Agendamento();
        agend1.setIdAgendamento(id);
        agend1.setDia(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2001"));
        agend1.setAmplificador(true);
        agend1.setDatashow(true);
        agend1.setIdCurso(0);
        agend1.setIdProfessor(0);
        agend1.setIdTurma(0);
        agend1.setPreaula(true);
        agend1.setPrimeirop(true);
        agend1.setSegundop(true);

        return null;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response create(Agendamento agendamento) {
        System.out.println("Imprimindo");
        System.out.println(agendamento.toString());
        return Response.status(Response.Status.OK).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response update(Agendamento agendamento) {
        System.out.println(agendamento.toString());
        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}/")
    public Response delete(@PathParam("id") long id) {
        System.out.println("Deletando ID: " + id);
        return Response.status(Response.Status.OK).build();
    }
}
