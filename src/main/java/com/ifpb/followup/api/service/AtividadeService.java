package com.ifpb.followup.api.service;

import com.ifpb.followup.model.Atividade;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * Created by Rodger on Apr 9, 2019 6:47:25 PM
 */
@Stateless
public class AtividadeService extends AbstractServiceFacade<Atividade> {

    @PersistenceContext(unitName = "followupPU")
    private EntityManager em;

    public AtividadeService() {
        super(Atividade.class);
    }

    @Override
    public void novo(Atividade entity) {
        super.novo(entity);
    }

    public void editar(Long id, Atividade entity) {
        super.editar(entity);
    }

    public void remover(Long id) {
        super.remover(super.buscar(id));
    }

    public Atividade buscar(Long id) {
        return super.buscar(id);
    }

    @Override
    public List<Atividade> buscarTodos() {
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