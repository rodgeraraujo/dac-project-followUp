/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ifpb.followup.api.resource;

import com.ifpb.followup.api.service.QuestionarioService;
import com.ifpb.followup.model.Questionario;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * Created by Rodger on Apr 9, 2019 6:56:49 PM
 */
@Stateless
@Path("questionario")
public class ResourceQuestionario {

    @Inject
    private QuestionarioService service;
      
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void novo(Questionario entity) {
        service.novo(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void editar(@PathParam("id") Long id, Questionario entity) {
        service.editar(entity);
    }

    @DELETE
    @Path("{id}")
    public void remover(@PathParam("id") Long id) {
        service.remover(service.buscar(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Questionario buscar(@PathParam("id") Long id) {
        return service.buscar(id);
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Questionario> buscarTodos() {
        return service.buscarTodos();
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String quantidade() {
        return String.valueOf(service.quantidade());
    }

}