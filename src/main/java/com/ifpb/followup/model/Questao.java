package com.ifpb.followup.model;

import java.io.Serializable;
import java.io.StringReader;
import java.util.Objects;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
    @Column(columnDefinition = "CHAR(1)", nullable = false)
    private char alternativaCorreta;
    @ManyToOne
    private Professor professor;
    
    
    public Questao() {
    }

    public Questao(JsonObject jsonObject) {
        this.id = jsonObject.getJsonNumber("id").longValue();
        this.enunciado = jsonObject.getString("enunciado");
        this.alternativaA = jsonObject.getString("alternativaA");
        this.alternativaB = jsonObject.getString("alternativaB");
        this.alternativaC = jsonObject.getString("alternativaC");
        this.alternativaD = jsonObject.getString("alternativaD");
        this.alternativaCorreta = jsonObject.getString("alternativaCorreta").charAt(0);
        //professor
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

    public char getAlternativaCorreta() {
        return alternativaCorreta;
    }

    public void setAlternativaCorreta(char alternativaCorreta) {
        this.alternativaCorreta = alternativaCorreta;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 47 * hash + Objects.hashCode(this.enunciado);
        hash = 47 * hash + Objects.hashCode(this.alternativaA);
        hash = 47 * hash + Objects.hashCode(this.alternativaB);
        hash = 47 * hash + Objects.hashCode(this.alternativaC);
        hash = 47 * hash + Objects.hashCode(this.alternativaD);
        hash = 47 * hash + this.alternativaCorreta;
        hash = 47 * hash + Objects.hashCode(this.professor);
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
        if (!Objects.equals(this.professor, other.professor)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Questao{" + "id=" + id + ", enunciado=" + enunciado + ", alternativaA=" + alternativaA + ", alternativaB=" + alternativaB + ", alternativaC=" + alternativaC + ", alternativaD=" + alternativaD + ", alternativaCorreta=" + alternativaCorreta + ", professor=" + professor + '}';
    }
    
}
