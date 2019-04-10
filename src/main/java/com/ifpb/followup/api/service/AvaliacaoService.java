/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ifpb.followup.api.service;

import com.ifpb.followup.model.Avaliacao;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * Created by Rodger on Apr 8, 2019 10:80:54 AM
 */
@Stateless
public class AvaliacaoService extends AbstractServiceFacade<Avaliacao> {

    @PersistenceContext(unitName = "followupPU")
    private EntityManager em;

    public AvaliacaoService() {
        super(Avaliacao.class);
    }

    @Override
    public void novo(Avaliacao entity) {
        super.novo(entity);
    }

    public void editar(Long id, Avaliacao entity) {
        super.editar(entity);
    }

    public void remover(Long id) {
        super.remover(super.buscar(id));
    }

    public Avaliacao buscar(Long id) {
        return super.buscar(id);
    }

    @Override
    public List<Avaliacao> buscarTodos() {
        return super.buscarTodos();
    }

    public List<Avaliacao> buscarEntre(Integer de, Integer ate) {
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
