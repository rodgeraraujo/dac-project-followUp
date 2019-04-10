package com.ifpb.followup.controller;

import com.ifpb.followup.consumer.ConsumerQuestao;
import com.ifpb.followup.model.Questao;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

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
    
    public String salvar(){
        consumerQuestao.salvar(questao);
        return null;
    }
    
    public List<Questao> listar(){
        return consumerQuestao.questoes();
    }

    public Questao getQuestao() {
        return questao;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
    }
    
}
