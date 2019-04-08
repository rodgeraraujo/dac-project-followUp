/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.followup.resource;

import com.ifpb.followup.model.Aluno;
import com.ifpb.followup.service.AlunoIF;
import java.net.URI;
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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Cliente
 */
@Stateless
@Path("alunos")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class ResourceAluno {

    @Inject
    private AlunoIF service;

    @Context
    private UriInfo uriInfo;

    @POST
    public Response salvarAluno(Aluno a) {
        Aluno resposta = service.salvar(a);
        String id = String.valueOf(a.getId());
        URI location = uriInfo.getAbsolutePathBuilder()
                .path(id)
                .build();
        return Response.created(location)
                .entity(resposta)
                .build();
    }

    @DELETE
    @Path("{id}")

    public Response removerAluno(
            @PathParam("id") int id) {
        boolean resposta = this.service.delete(id);

        if (resposta) {
            return Response.noContent()
                    .build();
        }
        return Response.notModified("Erro ao tentar remover aluno ")
                .build();
    }

    @PUT
    @Path("{id}")
    public Response atualizarAluno(@PathParam("id") long id, Aluno aluno) {
        Aluno resposta = this.service.atualizar(id, aluno);
        return Response.ok()
                .entity(resposta)
                .build();
    }

    @GET
    @Path("{id}")
    public Response localizarAluno(
            @PathParam("id") int id) {

        Aluno resposta = this.service.buscar(id);
        return Response.ok()
                .entity(resposta)
                .build();
    }

    @GET

    public Response listarAlunos() {

        List<Aluno> resposta = this.service.alunos();
        GenericEntity<List<Aluno>> lista = new GenericEntity<List<Aluno>>(resposta) {
        };
        return Response.ok()
                .entity(lista)
                .build();
    }
}
