package com.ifpb.followup.controller;

import com.ifpb.followup.consumer.ConsumerAluno;
import com.ifpb.followup.consumer.ConsumerProfessor;
import com.ifpb.followup.model.Aluno;
import com.ifpb.followup.model.Professor;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Amanda
 */
@Named
@RequestScoped
public class ControladorCadastro {

    private final String TIPO_ALUNO = "ALUNO";
    private final String TIPO_PROFESSOR = "PROFESSOR";
    private String tipo;
    private String nome;
    private String email;
    private String senha;
    private int matricula;
    
    @Inject
    ConsumerAluno consumerAluno;
    
    @Inject
    ConsumerProfessor consumerProfessor;

    public String cadastrar() {
        if(tipo.equals(TIPO_ALUNO)){
            Aluno aluno = new Aluno();
            aluno.setNome(nome);
            aluno.setEmail(email);
            aluno.setSenha(senha);
            aluno.setMatricula(matricula);  
            consumerAluno.salvar(aluno);
        } else if(tipo.equals(TIPO_PROFESSOR)){
            Professor professor = new Professor();
            professor.setNome(nome);
            professor.setEmail(email);
            professor.setSenha(senha);
            professor.setMatricula(matricula);
            consumerProfessor.salvar(professor);
        }
        
        return "index.xhtml";
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

}
