package com.ifpb.followup.api.service;

import com.ifpb.followup.model.RespostaAtividade;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * Created by Rodger on Apr 9, 2019 7:08:50 PM
 */
@Stateless
public class RespostaAtividadeService extends AbstractServiceFacade<RespostaAtividade> {

    @PersistenceContext(unitName = "followupPU")
    private EntityManager em;

    public RespostaAtividadeService() {
        super(RespostaAtividade.class);
    }

    @Override
    public void novo(RespostaAtividade entity) {
        super.novo(entity);
    }

    public void editar(Long id, RespostaAtividade entity) {
        super.editar(entity);
    }

    public void remover(Long id) {
        super.remover(super.buscar(id));
    }

    public RespostaAtividade buscar(Long id) {
        return super.buscar(id);
    }

    @Override
    public List<RespostaAtividade> buscarTodos() {
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