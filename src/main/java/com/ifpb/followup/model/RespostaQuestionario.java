package com.ifpb.followup.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author Amanda
 */
@Entity
public class RespostaQuestionario implements Serializable{
    
    @Id
    @GeneratedValue
    private long id;
    @OneToOne
    private Aluno aluno;
    @OneToOne
    private Resposta resposta;
    @ManyToOne
    private Questionario questionario;

    public RespostaQuestionario() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Resposta getResposta() {
        return resposta;
    }

    public void setResposta(Resposta resposta) {
        this.resposta = resposta;
    }

    public Questionario getQuestionario() {
        return questionario;
    }

    public void setQuestionario(Questionario questionario) {
        this.questionario = questionario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 19 * hash + Objects.hashCode(this.aluno);
        hash = 19 * hash + Objects.hashCode(this.resposta);
        hash = 19 * hash + Objects.hashCode(this.questionario);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RespostaQuestionario other = (RespostaQuestionario) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.aluno, other.aluno)) {
            return false;
        }
        if (!Objects.equals(this.resposta, other.resposta)) {
            return false;
        }
        if (!Objects.equals(this.questionario, other.questionario)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RespostaQuestionario{" + "id=" + id + ", aluno=" + aluno + ", resposta=" + resposta + ", questionario=" + questionario + '}';
    }
    
}
