package com.ifpb.followup.consumer;

import com.ifpb.followup.model.Avaliacao;
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
public class ConsumerAvaliacao {
    
    private final String url = "http://0.0.0.0:8080/followUp/api/avaliacao";
    private final Client client = ClientBuilder.newClient();
    private final WebTarget avaliacoes = client.target(url);
    
    public void salvar(Avaliacao avaliacao) {
        Response resposta = avaliacoes.request().
                post(Entity.json(avaliacao));
    }

    public Avaliacao buscar(String id) {
        WebTarget avaliacaoComId = avaliacoes.path("{id}").resolveTemplate("id", id);
        Response resposta =  avaliacaoComId.request().get();
        String corpo = resposta.readEntity(String.class);
        return converter(corpo);
    }

    public void delete(long id) {
        WebTarget questaoComId = avaliacoes.path("{id}")
                .resolveTemplate("id", id);
        Response delete = questaoComId.request().delete();

    }

    public void atualizar(Avaliacao avaliacao) {
        WebTarget questaoComId = avaliacoes.path("{id}")
                .resolveTemplate("id", avaliacao.getId());
        Response resposta = questaoComId.request().
                put(Entity.json(avaliacao));
        String json = resposta.readEntity(String.class);
    }

    public List<Avaliacao> avaliacoes() {
        Response resposta = avaliacoes.request().get();
        String json = resposta.readEntity(String.class);
        JsonArray array = Json.createReader(
            new StringReader(json)
        ).readArray();

        return array.stream()
            .map(obj -> new Avaliacao((JsonObject) obj))
            .collect(Collectors.toList());
    }
    
    public Avaliacao converter(String json) {
        JsonObject jsonObject = Json.createReader(
            new StringReader(json)
        ).readObject();
        return new Avaliacao(jsonObject);
    }

}
