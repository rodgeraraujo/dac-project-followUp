package com.ifpb.followup.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Amanda
 */
@Entity
@XmlRootElement
public class Questao implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private String enunciado;
    @Column(nullable = false)
    private String alternativaA;
    @Column(nullable = false)
    private String alternativaB;
    @Column(nullable = false)
    private String alternativaC;
    @Column(nullable = false)
    private String alternativaD;
    @Enumerated(EnumType.STRING)
    private TipoQuestao tipo;
    @Column(columnDefinition = "CHAR(1)", nullable = false)
    private char alternativaCorreta;

    public Questao() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String getAlternativaA() {
        return alternativaA;
    }

    public void setAlternativaA(String alternativaA) {
        this.alternativaA = alternativaA;
    }

    public String getAlternativaB() {
        return alternativaB;
    }

    public void setAlternativaB(String alternativaB) {
        this.alternativaB = alternativaB;
    }

    public String getAlternativaC() {
        return alternativaC;
    }

    public void setAlternativaC(String alternativaC) {
        this.alternativaC = alternativaC;
    }

    public String getAlternativaD() {
        return alternativaD;
    }

    public void setAlternativaD(String alternativaD) {
        this.alternativaD = alternativaD;
    }

    public TipoQuestao getTipo() {
        return tipo;
    }

    public void setTipo(TipoQuestao tipo) {
        this.tipo = tipo;
    }

    public char getAlternativaCorreta() {
        return alternativaCorreta;
    }

    public void setAlternativaCorreta(char alternativaCorreta) {
        this.alternativaCorreta = alternativaCorreta;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 43 * hash + Objects.hashCode(this.enunciado);
        hash = 43 * hash + Objects.hashCode(this.alternativaA);
        hash = 43 * hash + Objects.hashCode(this.alternativaB);
        hash = 43 * hash + Objects.hashCode(this.alternativaC);
        hash = 43 * hash + Objects.hashCode(this.alternativaD);
        hash = 43 * hash + Objects.hashCode(this.tipo);
        hash = 43 * hash + this.alternativaCorreta;
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
        final Questao other = (Questao) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.alternativaCorreta != other.alternativaCorreta) {
            return false;
        }
        if (!Objects.equals(this.enunciado, other.enunciado)) {
            return false;
        }
        if (!Objects.equals(this.alternativaA, other.alternativaA)) {
            return false;
        }
        if (!Objects.equals(this.alternativaB, other.alternativaB)) {
            return false;
        }
        if (!Objects.equals(this.alternativaC, other.alternativaC)) {
            return false;
        }
        if (!Objects.equals(this.alternativaD, other.alternativaD)) {
            return false;
        }
        if (this.tipo != other.tipo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Questao{" + "id=" + id + ", enunciado=" + enunciado + ", alternativaA=" + alternativaA + ", alternativaB=" + alternativaB + ", alternativaC=" + alternativaC + ", alternativaD=" + alternativaD + ", tipo=" + tipo + ", alternativaCorreta=" + alternativaCorreta + '}';
    }
    
}
