package com.ifpb.followup.controller;

import com.ifpb.followup.consumer.ConsumerQuestao;
import com.ifpb.followup.model.Professor;
import com.ifpb.followup.model.Questao;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Amanda
 */
@Named
@RequestScoped
public class ControladorQuestao {

    @Inject
    private ConsumerQuestao consumerQuestao;
    private Questao questao = new Questao();
    private boolean editando = false;

    FacesContext context = FacesContext.getCurrentInstance();
    HttpSession session = (HttpSession) context.getExternalContext().getSession(false);

    public String salvar() {
        questao.setProfessor((Professor) session.getAttribute("usuario"));
        consumerQuestao.salvar(questao);
        return null;
    }

    public String remover(long id) {
        this.consumerQuestao.delete(id);
        return null;
    }

    public void editar(Questao questao) {
        this.questao = questao;
        this.editando = true;
    }

    public String atualizar() {
        questao.setProfessor((Professor) session.getAttribute("usuario"));
        this.consumerQuestao.atualizar(this.questao);
        this.editando = false;
        return null;
    }

    public List<Questao> listar() {
        return consumerQuestao.questoes();
//        return null;
    }

    public Questao getQuestao() {
        return questao;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
    }

    public boolean isEditando() {
        return editando;
    }

    public void setEditando(boolean editando) {
        this.editando = editando;
    }

}
