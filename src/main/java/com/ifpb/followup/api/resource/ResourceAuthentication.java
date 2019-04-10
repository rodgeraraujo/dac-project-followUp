package com.ifpb.followup.api.resource;

import com.ifpb.followup.api.service.AlunoService;
import com.ifpb.followup.model.Aluno;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * Created by Rodger on Apr 10, 2019 5:44:48 PM
 */
@Stateless
@Path("/login")
public class ResourceAuthentication {

    private Aluno aluno;

    @Inject
    private AlunoService service;

    @GET
    @Path("aluno/{email}/{senha}")
    @Produces(MediaType.APPLICATION_JSON)
    public String authUsuario(@PathParam("email") String email,
            @PathParam("senha") String senha) {

        if (!isAuthenticated(new String[]{email, senha})) {
            return "{\"error\":\"not authenticated\"}";
        }
        return "{\"success\":\"authenticated\"}";
    }

    private boolean isAuthenticated(String[] info) {
        aluno = service.buscarPorEmail(info[0]);
        if (aluno != null) {
            if (aluno.getEmail().equals(info[0]) && aluno.getSenha().equals(info[1])) {
                return true;
            }
        }
        return false;
    }
}
