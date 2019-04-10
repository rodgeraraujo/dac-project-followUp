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

    public String salvar() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        questao.setProfessor((Professor) session.getAttribute("usuario"));
        consumerQuestao.salvar(questao);
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

}
