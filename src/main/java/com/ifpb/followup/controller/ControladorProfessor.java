/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.followup.controller;

import com.ifpb.followup.consumer.ConsumerProfessor;
import com.ifpb.followup.model.Professor;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Cliente
 */
@Named("controladorProfessor")
@RequestScoped
public class ControladorProfessor implements Serializable{

    @Inject
    ConsumerProfessor consumerProfessor;

    private Professor professor = new Professor();

    public String salvar() {
        this.consumerProfessor.salvar(this.professor);
        this.professor = new Professor();
        return null;
    }

    public String excluir(long id) {
        this.consumerProfessor.delete(String.valueOf(id));
        return null;
    }

    public String atualizar() {
        this.consumerProfessor.atualizar(this.professor);

        return null;
    }

    public List<Professor> todosOsAlunos() {
        return this.consumerProfessor.professores();
    }

    public Professor buscar(long id) {
        return this.consumerProfessor.buscar(String.valueOf(id));
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

}
