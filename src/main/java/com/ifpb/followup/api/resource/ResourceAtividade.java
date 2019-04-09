/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ifpb.followup.api.resource;

import com.ifpb.followup.api.service.AtividadeService;
import com.ifpb.followup.model.Atividade;
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
 * Created by Rodger on Apr 9, 2019 7:01:43 PM
 */
@Stateless
@Path("atividade")
public class ResourceAtividade {

    @Inject
    private AtividadeService service;
      
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void novo(Atividade entity) {
        service.novo(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void editar(@PathParam("id") Long id, Atividade entity) {
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
    public Atividade buscar(@PathParam("id") Long id) {
        return service.buscar(id);
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Atividade> buscarTodos() {
        return service.buscarTodos();
    }

    @GET
    @Path("{de}/{ate}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Atividade> buscarEntre(@PathParam("de") Integer from, @PathParam("ate") Integer to) {
        return service.buscarEntre(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String quantidade() {
        return String.valueOf(service.quantidade());
    }

}
