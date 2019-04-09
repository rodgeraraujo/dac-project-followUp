/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ifpb.followup.api.service;

import com.ifpb.followup.model.Questao;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * Created by Rodger on Apr 9, 2019 6:56:08 PM
 */
@Stateless
public class QuestaoService extends AbstractServiceFacade<Questao> {

    @PersistenceContext(unitName = "followupPU")
    private EntityManager em;

    public QuestaoService() {
        super(Questao.class);
    }

    @Override
    public void novo(Questao entity) {
        super.novo(entity);
    }

    public void editar(Long id, Questao entity) {
        super.editar(entity);
    }

    public void remover(Long id) {
        super.remover(super.buscar(id));
    }

    public Questao buscar(Long id) {
        return super.buscar(id);
    }

    @Override
    public List<Questao> buscarTodos() {
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