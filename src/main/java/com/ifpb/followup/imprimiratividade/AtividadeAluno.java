/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.followup.imprimiratividade;

import java.io.Serializable;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.SqlResultSetMapping;

/**
 *
 * @author Cliente
 */
@SqlResultSetMapping(
        name = "atividadeMapping",
        classes = @ConstructorResult(
                targetClass = AtividadeAluno.class,
                columns = {
                    @ColumnResult(name = "aluno")
                    ,
                   @ColumnResult(name = "matricula", type = Long.class)
                    ,
                   @ColumnResult(name = "enunciado")
                    ,
                   @ColumnResult(name = "alternativaA")
                    ,
                   @ColumnResult(name = "alternativaB")
                    ,
                   @ColumnResult(name = "alternativaC")
                    ,
                   @ColumnResult(name = "alternativaD")}
        ))

public class AtividadeAluno implements Serializable {

    private String aluno;
    private long matricula;
    private String enunciado;
    private String alternativaA;
    private String alternativaB;
    private String alternativaC;
     private String alternativaD;

    public AtividadeAluno() {
    }

    public AtividadeAluno(long matricula,String aluno,  String enunciado,
            String alternativaA, String alternativaB, String alternativaC,String alternativaD) {
        this.aluno = aluno;
        this.matricula = matricula;
        this.enunciado = enunciado;
        this.alternativaA = alternativaA;
        this.alternativaB = alternativaB;
        this.alternativaC = alternativaC;
        this.alternativaD = alternativaD;
    }

    public String getAluno() {
        return aluno;
    }

    public void setAluno(String aluno) {
        this.aluno = aluno;
    }

    public String getAlternativaD() {
        return alternativaD;
    }

    public void setAlternativaD(String alternativaD) {
        this.alternativaD = alternativaD;
    }

    public long getMatricula() {
        return matricula;
    }

    public void setMatricula(long matricula) {
        this.matricula = matricula;
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

    @Override
    public String toString() {
        return "AtividadeAluno{" + "aluno=" + aluno + ", matricula=" + matricula + 
                ", enunciado=" + enunciado + ", alternativaA=" + alternativaA 
                + ", alternativaB=" + alternativaB + ", alternativaC=" + 
                alternativaC + ", alternativaD=" + alternativaD + '}';
    }

   
}
