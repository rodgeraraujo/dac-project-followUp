/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.followup.imprimiratividade;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Cliente
 */
@Stateless
public class ListarQuestoes {

    @PersistenceContext
    private EntityManager em;

    public List<AtividadeAluno> getAtividade(long id, long alunoId) {

        String sql = "SELECT a.matricula,a.nome, q.enunciado,q.alternativaA,q.alternativaB,q.alternativaC,q.alternativaD FROM questao q, aluno a "
                + "WHERE a.id =?1 and q.id "
                + "IN(" +
                "SELECT q.id FROM questao q ,avaliacao_questao aq WHERE aq.avaliacao_id =?1)  ";

        Query query = em.createNativeQuery(sql, "AtividadeMapping");
        query.setParameter(1, id);
        query.setParameter(2, alunoId);
        List<Object[]> objs = query.getResultList();
        List<AtividadeAluno> questoes = new ArrayList();
        for (Object[] o : objs) {
            Object[] aux = o;
            AtividadeAluno at = new AtividadeAluno();
            at.setMatricula((Long) aux[0]);
            at.setAluno((String) aux[1]);
            at.setEnunciado((String) aux[2]);
            at.setAlternativaA((String) aux[3]);
            at.setAlternativaB((String) aux[4]);
            at.setAlternativaC((String) aux[5]);
            at.setAlternativaD((String) aux[6]);
            questoes.add(at);
        }
        
        Collections.shuffle(questoes);
        return questoes;

    }
}
