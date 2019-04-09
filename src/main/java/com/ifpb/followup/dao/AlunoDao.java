///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.ifpb.followup.dao;
//
//import com.ifpb.followup.model.Aluno;
//import com.ifpb.followup.interfaces.AlunoIF;
//import java.util.List;
//import javax.ejb.Stateless;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//
///**
// *
// * @author Cliente
// */
//@Stateless
//
//public class AlunoDao implements AlunoIF{
//
//    @PersistenceContext("followUp")
//    private EntityManager em;
//
//    @Override
//    public Aluno salvar(Aluno aluno) {
//        em.persist(aluno);
//        return aluno;
//    }
//
//    
//
//    @Override
//    public Aluno buscar(long id) {
//        Aluno aluno = em.find(Aluno.class, id);
//        if (aluno == null) {
//            return Aluno.empty();
//        }
//        return aluno;
//    }
//
//    
//
//    @Override
//    public boolean delete(long id) {
//        Aluno aluno = em.find(Aluno.class, id);
//        if (aluno == null) {
//            return false;
//        }
//        em.remove(aluno);
//        return true;
//    }
//
//    @Override
//    public Aluno atualizar(long id, Aluno a) {
//        Aluno aluno = em.find(Aluno.class, id);
//        if (aluno == null) {
//            return Aluno.empty();
//        }
//        aluno = a;
//        aluno.setId(id);
//
//        return em.merge(aluno);
//    }
//
//    @Override
//    public List<Aluno> alunos() {
//        return em.createQuery("From Produto p",Aluno.class)
//            .getResultList();
//    }
//  
//  
//
//}
