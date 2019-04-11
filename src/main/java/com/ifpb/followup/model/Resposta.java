package com.ifpb.followup.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Amanda
 */
@Entity
@XmlRootElement
public class Resposta implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @OneToOne
    private Questao questao;
    @ManyToOne
    private Avaliacao avaliacao;
    @Column(columnDefinition = "CHAR(1)", nullable = false)
    private String resoposta;

    public Resposta() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Questao getQuestao() {
        return questao;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getResoposta() {
        return resoposta;
    }

    public void setResoposta(String resoposta) {
        this.resoposta = resoposta;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 97 * hash + Objects.hashCode(this.questao);
        hash = 97 * hash + Objects.hashCode(this.avaliacao);
        hash = 97 * hash + Objects.hashCode(this.resoposta);
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
        final Resposta other = (Resposta) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.resoposta, other.resoposta)) {
            return false;
        }
        if (!Objects.equals(this.questao, other.questao)) {
            return false;
        }
        if (!Objects.equals(this.avaliacao, other.avaliacao)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Resposta{" + "id=" + id + ", questao=" + questao + ", avaliacao=" + avaliacao + ", resoposta=" + resoposta + '}';
    }

}
