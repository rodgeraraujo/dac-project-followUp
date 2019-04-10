package com.ifpb.followup.api.resource;

import com.ifpb.followup.api.service.QuestaoService;
import com.ifpb.followup.model.Questao;
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
 * Created by Rodger on Apr 9, 2019 7:02:48 PM
 */
@Stateless
@Path("questao")
public class ResourceQuestao {

    @Inject
    private QuestaoService service;
      
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void novo(Questao entity) {
        service.novo(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void editar(@PathParam("id") Long id, Questao entity) {
        service.editar(entity);
    }

    @DELETE
    @Path("{id}")
    public void remover(@PathParam("id") Long id) {
        service.remover(service.buscar(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Questao buscar(@PathParam("id") Long id) {
        return service.buscar(id);
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Questao> buscarTodos() {
        return service.buscarTodos();
    }

    @GET
    @Path("{de}/{ate}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Questao> buscarEntre(@PathParam("de") Integer from, @PathParam("ate") Integer to) {
        return service.buscarEntre(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String quantidade() {
        return String.valueOf(service.quantidade());
    }

}
