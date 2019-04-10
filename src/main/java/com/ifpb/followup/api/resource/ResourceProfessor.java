package com.ifpb.followup.api.resource;


import com.ifpb.followup.model.Professor;
//import service.*;
import com.ifpb.followup.api.service.ProfessorService;
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
 * Created by Rodger on Apr 8, 2019 10:10:48 AM
 */
@Stateless
@Path("professor")
public class ResourceProfessor {

    @Inject
    private ProfessorService service;
      
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void novo(Professor entity) {
        service.novo(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void editar(@PathParam("id") Long id, Professor entity) {
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
    public Professor buscar(@PathParam("id") Long id) {
        return service.buscar(id);
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Professor> buscarTodos() {
        return service.buscarTodos();
    }

    @GET
    @Path("{de}/{ate}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Professor> buscarEntre(@PathParam("de") Integer from, @PathParam("ate") Integer to) {
        return service.buscarEntre(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String quantidade() {
        return String.valueOf(service.quantidade());
    }

}
