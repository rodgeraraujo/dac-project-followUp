/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.followup.controller;

import com.ifpb.followup.consumer.ConsumerAluno;
import com.ifpb.followup.model.Aluno;
import java.util.List;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Cliente
 */
@Named("controladorAluno")
@RequestScoped
public class ControladorAluno {

    @Inject
    ConsumerAluno consumerAluno;

    private Aluno aluno = new Aluno();

    public String salvar() {
        Aluno salvar = this.consumerAluno.salvar(this.aluno);
        this.aluno = new Aluno();
        return null;
    }

    public String excluir(long id) {
        this.consumerAluno.delete(String.valueOf(id));
        return null;
    }

    public String atualizar() {
        Aluno atualizarAluno = this.consumerAluno.atualizar(this.aluno);
        return null;
    }

    public List<Aluno> todosOsProdutos() {
        return this.consumerAluno.alunos();
    }

    public Aluno buscar(long id) {
        return this.consumerAluno.buscar(String.valueOf(id));
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

}
