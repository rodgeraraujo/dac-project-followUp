/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.followup.consumer;

import com.ifpb.followup.model.Questao;
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
 * @author Amanda
 */
@Stateless
public class ConsumerQuestao {
    
    private final String url = "http://0.0.0.0:8080/followUp/api/questao";
    private final Client client = ClientBuilder.newClient();
    private final WebTarget questoes = client.target(url);
    
    public void salvar(Questao questao) {
        Response resposta = questoes.request().
                post(Entity.json(questao));
    }

    public Questao buscar(String id) {
        WebTarget questaoComId = questoes.path("{id}").resolveTemplate("id", id);
        Response resposta =  questaoComId.request().get();
        String corpo = resposta.readEntity(String.class);
        return converter(corpo);
    }

    public void delete(long id) {
        WebTarget questaoComId = questoes.path("{id}")
                .resolveTemplate("id", id);
        Response delete = questaoComId.request().delete();

    }

    public void atualizar(Questao questao) {
        WebTarget questaoComId = questoes.path("{id}")
                .resolveTemplate("id", questao.getId());
        Response resposta = questaoComId.request().
                put(Entity.json(questao));
        String json = resposta.readEntity(String.class);
//        return converter(json);
    }

    public List<Questao> questoes() {
        Response resposta = questoes.request().get();
        String json = resposta.readEntity(String.class);
        JsonArray array = Json.createReader(
            new StringReader(json)
        ).readArray();

        return array.stream()
            .map(obj -> new Questao((JsonObject) obj))
            .collect(Collectors.toList());
    }
    
    public Questao converter(String json) {
        JsonObject jsonObject = Json.createReader(
            new StringReader(json)
        ).readObject();
        return new Questao(jsonObject);
    }

}
