/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ifpb.followup.api.service;

import com.ifpb.followup.model.Aluno;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * Created by Rodger on Apr 8, 2019 10:80:54 AM
 */
@Stateless
public class AlunoService extends AbstractServiceFacade<Aluno> {

    @PersistenceContext(unitName = "followUp")
    private EntityManager em;

    public AlunoService() {
        super(Aluno.class);
    }

    @Override
    public void novo(Aluno entity) {
        super.novo(entity);
    }

    public void editar(Long id, Aluno entity) {
        super.editar(entity);
    }

    public void remover(Long id) {
        super.remover(super.buscar(id));
    }

    public Aluno buscar(Long id) {
        return super.buscar(id);
    }

    @Override
    public List<Aluno> buscarTodos() {
        return super.buscarTodos();
    }

    public List<Aluno> buscarEntre(Integer de, Integer ate) {
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
