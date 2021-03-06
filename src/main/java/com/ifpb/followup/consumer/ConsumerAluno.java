/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.followup.consumer;

import com.ifpb.followup.model.Aluno;
import java.io.StringReader;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 *
 * @author Cliente
 */
@Stateless
public class ConsumerAluno {

    private final String url = "http://0.0.0.0:8080/followUp/api/aluno";
    private final Client client = ClientBuilder.newClient();
    private final WebTarget alunos = client.target(url);

    public void salvar(Aluno aluno) {
        Response resposta = alunos.request().
                post(Entity.json(aluno));
    }

    public Aluno buscar(long id) {
        WebTarget alunocomId = alunos.path("{id}").resolveTemplate("id", id);
        Response resposta = alunocomId.request().get();
        String corpo = resposta.readEntity(String.class);
        return converter(corpo);
    }
    
    public Aluno buscarPorEmail(String email){
        WebTarget alunocomId = alunos.path("auth/{email}").resolveTemplate("email", email);
        Response resposta = alunocomId.request().get();
        String corpo = resposta.readEntity(String.class);
        return converter(corpo);
    }

    public void delete(String id) {
        WebTarget alunocomId = alunos.path("{id}")
                .resolveTemplate("id", id);
     Response delete = alunocomId.request().delete();
        
    }

    public Aluno atualizar(Aluno aluno) {
        WebTarget alunoComId = alunos.path("{id}")
                .resolveTemplate("id", aluno.getId());
        Response resposta = alunoComId.request().
                put(Entity.json(aluno));
        String json = resposta.readEntity(String.class);
        return converter(json);
    }

    public List<Aluno> alunos() {
        Response resposta = alunos.request().get();
        String json = resposta.readEntity(String.class);
        JsonArray array = Json.createReader(
                new StringReader(json)
        ).readArray();

        return array.stream()
                .map(obj -> new Aluno((JsonObject) obj))
                .collect(Collectors.toList());
    }

    public Aluno converter(String json) {
        String j = json.replaceAll("\r?\n", "");
        JsonObject jsonObject = Json.createReader(
                new StringReader(j)
        ).readObject();

        return new Aluno(jsonObject);
    }
}
