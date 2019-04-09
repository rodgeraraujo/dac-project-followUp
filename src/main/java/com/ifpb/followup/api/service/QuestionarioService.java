package com.ifpb.followup.api.service;

import com.ifpb.followup.model.Questionario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * Created by Rodger on Apr 9, 2019 6:58:08 PM
 */
@Stateless
public class QuestionarioService extends AbstractServiceFacade<Questionario> {

    @PersistenceContext(unitName = "followupPU")
    private EntityManager em;

    public QuestionarioService() {
        super(Questionario.class);
    }

    @Override
    public void novo(Questionario entity) {
        super.novo(entity);
    }

    public void editar(Long id, Questionario entity) {
        super.editar(entity);
    }

    public void remover(Long id) {
        super.remover(super.buscar(id));
    }

    public Questionario buscar(Long id) {
        return super.buscar(id);
    }

    @Override
    public List<Questionario> buscarTodos() {
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