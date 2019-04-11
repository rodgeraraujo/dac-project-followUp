package com.ifpb.followup.controller;

import com.ifpb.followup.consumer.ConsumerAvaliacao;
import com.ifpb.followup.model.Avaliacao;
import com.ifpb.followup.model.Questao;
import com.ifpb.followup.model.TipoAvaliacao;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Amanda
 */
@Named
@SessionScoped
public class ControladorQuestionario implements Serializable{
    
    private Avaliacao questinario = new Avaliacao();
    private Questao questao = new Questao();
    
    @Inject
    private ConsumerAvaliacao consumerAvaliacao;
    
    public String salvar(){
        questinario.setTipo(TipoAvaliacao.QUESTIONARIO);
        consumerAvaliacao.salvar(questinario);
        questinario = new Avaliacao();
        return "questionarios.xhtml";
    }
    
    public String editar(Avaliacao a){
        this.questinario = a;
        return "editar-questionario.xhtml";
    }
    
    public String atualizar(){
        consumerAvaliacao.atualizar(questinario);
        this.questinario = new Avaliacao();
        return "questionarios.xhtml";
    }
    
    public String remover(long id){
        consumerAvaliacao.delete(id);
        return null;
    }
    
    public void adicionarQuestao(){
        this.questinario.getQuestao().add(questao);
        questao = new Questao();
    }
    
    public String removerQuestao(Questao q){
        this.questinario.getQuestao().remove(q);
        return null;
    }
    
    public List<Avaliacao> listar(){
        return consumerAvaliacao.avaliacoes();
    }

    public Avaliacao getQuestinario() {
        return questinario;
    }

    public void setQuestinario(Avaliacao questinario) {
        this.questinario = questinario;
    }

    public Questao getQuestao() {
        return questao;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
    }

}
