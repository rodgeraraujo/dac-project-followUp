/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.followup.consumer;

import com.ifpb.followup.model.Professor;
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
public class ConsumerProfessor {

    private final String url = "http://localhost:8080/followUP/api/professores";
    private final Client client = ClientBuilder.newClient();
    private final WebTarget professores = client.target(url);

    public Professor salvar(Professor professor) {
        Response resposta = professores.request().
                post(Entity.json(professor));

        String json = resposta.readEntity(String.class);
        return converter(json);

    }

    public Professor buscar(String id) {
        WebTarget professorComId = professores.path("{id}").resolveTemplate("id", id);
        Response resposta =  professorComId.request().get();
        String corpo = resposta.readEntity(String.class);
        return converter(corpo);
    }

    public void delete(String id) {
        WebTarget professorComId = professores.path("{id}")
                .resolveTemplate("id", id);
        Response delete = professorComId.request().delete();

    }

    public Professor atualizar(Professor professor) {
        WebTarget professorComId = professores.path("{id}")
                .resolveTemplate("id", professor.getId());
        Response resposta = professorComId.request().
                put(Entity.json(professor));
        String json = resposta.readEntity(String.class);
        return converter(json);
    }

    public List<Professor> professores() {
        Response resposta = professores.request().get();
        String json = resposta.readEntity(String.class);
        JsonArray array = Json.createReader(
                new StringReader(json)
        ).readArray();

//        return array.stream()
//                .map(obj -> new Professor((JsonObject) obj))
//                .collect(Collectors.toList());
        return null;
    }

    public Professor converter(String json) {
        JsonObject jsonObject = Json.createReader(
                new StringReader(json)
        ).readObject();

//        return new Professor(jsonObject);
        return null;
    }
}
