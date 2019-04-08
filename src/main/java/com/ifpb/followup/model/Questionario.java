package com.ifpb.followup.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Amanda
 */
@Entity
public class Questionario implements Serializable{
    
    @Id
    @GeneratedValue
    private long id;
    @OneToMany
    private List<Questao> questoes;

    public Questionario() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Questao> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(List<Questao> questoes) {
        this.questoes = questoes;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 71 * hash + Objects.hashCode(this.questoes);
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
        final Questionario other = (Questionario) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.questoes, other.questoes)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Questionario{" + "id=" + id + ", questoes=" + questoes + '}';
    }
    
}
