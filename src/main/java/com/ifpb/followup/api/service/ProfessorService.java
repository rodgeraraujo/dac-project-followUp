package com.ifpb.followup.api.service;

import com.ifpb.followup.model.Professor;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * Created by Rodger on Apr 8, 2019 10:10:48 AM
 */
@Stateless
public class ProfessorService extends AbstractServiceFacade<Professor> {

    @PersistenceContext(unitName = "followupPU")
    private EntityManager em;

    public ProfessorService() {
        super(Professor.class);
    }

    @Override
    public void novo(Professor entity) {
        super.novo(entity);
    }

    public void editar(Long id, Professor entity) {
        super.editar(entity);
    }

    public void remover(Long id) {
        super.remover(super.buscar(id));
    }

    public Professor buscar(Long id) {
        return super.buscar(id);
    }

    @Override
    public List<Professor> buscarTodos() {
        return super.buscarTodos();
    }

    public List<Professor> buscarEntre(Integer de, Integer ate) {
        return super.buscarEntre(new int[]{de, ate});
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
