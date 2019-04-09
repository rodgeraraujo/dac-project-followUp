package com.ifpb.followup.api.resource;

import com.ifpb.followup.api.service.RespostaQuestionarioService;
import com.ifpb.followup.model.RespostaQuestionario;
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
 * Created by Rodger on Apr 9, 2019 7:09:39 PM
 */
@Stateless
@Path("res-questionario")
public class ResourceRespostaQuestionario {

    @Inject
    private RespostaQuestionarioService service;
      
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void novo(RespostaQuestionario entity) {
        service.novo(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void editar(@PathParam("id") Long id, RespostaQuestionario entity) {
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
    public RespostaQuestionario buscar(@PathParam("id") Long id) {
        return service.buscar(id);
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<RespostaQuestionario> buscarTodos() {
        return service.buscarTodos();
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String quantidade() {
        return String.valueOf(service.quantidade());
    }

}