package com.ifpb.followup.api.service;

import com.ifpb.followup.model.RespostaQuestionario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * Created by Rodger on Apr 9, 2019 7:11:17 PM
 */
@Stateless
public class RespostaQuestionarioService extends AbstractServiceFacade<RespostaQuestionario> {

    @PersistenceContext(unitName = "followupPU")
    private EntityManager em;

    public RespostaQuestionarioService() {
        super(RespostaQuestionario.class);
    }

    @Override
    public void novo(RespostaQuestionario entity) {
        super.novo(entity);
    }

    public void editar(Long id, RespostaQuestionario entity) {
        super.editar(entity);
    }

    public void remover(Long id) {
        super.remover(super.buscar(id));
    }

    public RespostaQuestionario buscar(Long id) {
        return super.buscar(id);
    }

    @Override
    public List<RespostaQuestionario> buscarTodos() {
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