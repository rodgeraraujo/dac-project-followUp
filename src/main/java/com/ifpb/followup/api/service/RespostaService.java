package com.ifpb.followup.api.service;

import com.ifpb.followup.model.Resposta;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * Created by Rodger on Apr 9, 2019 7:05:37 PM
 */
@Stateless
public class RespostaService extends AbstractServiceFacade<Resposta> {

    @PersistenceContext(unitName = "followUp")
    private EntityManager em;

    public RespostaService() {
        super(Resposta.class);
    }

    @Override
    public void novo(Resposta entity) {
        super.novo(entity);
    }

    public void editar(Long id, Resposta entity) {
        super.editar(entity);
    }

    public void remover(Long id) {
        super.remover(super.buscar(id));
    }

    public Resposta buscar(Long id) {
        return super.buscar(id);
    }

    @Override
    public List<Resposta> buscarTodos() {
        return super.buscarTodos();
    }

    @Override
    public int quantidade() {
        return super.quantidade();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}