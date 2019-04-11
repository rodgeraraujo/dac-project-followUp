/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.followup.controller;

import com.ifpb.followup.imprimiratividade.ImprimirAtividade;
import com.ifpb.followup.imprimiratividade.ListarQuestoes;
import com.ifpb.followup.imprimiratividade.AtividadePDF;
import com.ifpb.followup.model.Aluno;
import com.ifpb.followup.model.Avaliacao;
import java.io.IOException;
import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Cliente
 */
@Named
@ViewScoped
public class ControladorAvaliacao implements Serializable {

    private final ListarQuestoes questoes = new ListarQuestoes();
    private ImprimirAtividade atividade;
    private Avaliacao a = new Avaliacao();
    private Aluno aluno = new Aluno();

    public void imprimirtividade() throws IOException {
        atividade = new AtividadePDF(
                this.questoes.getAtividade(a.getId(),aluno.getId())
        );

    }

    public ImprimirAtividade getAtividade() {
        return atividade;
    }

    public void setAtividade(ImprimirAtividade atividade) {
        this.atividade = atividade;
    }

    public Avaliacao getA() {
        return a;
    }

    public void setA(Avaliacao a) {
        this.a = a;
    }

}
