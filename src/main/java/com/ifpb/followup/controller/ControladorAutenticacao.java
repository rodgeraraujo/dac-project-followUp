package com.ifpb.followup.controller;

import com.ifpb.followup.consumer.ConsumerAluno;
import com.ifpb.followup.consumer.ConsumerProfessor;
import com.ifpb.followup.model.Aluno;
import com.ifpb.followup.model.Professor;
import java.io.IOException;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Amanda
 */
@Named
@SessionScoped
public class ControladorAutenticacao implements Serializable {

    private final String TIPO_ALUNO = "ALUNO";
    private final String TIPO_PROFESSOR = "PROFESSOR";

    private String email;
    private String senha;
    private String tipo;

    private Aluno aluno;
    private Professor professor;

    @Inject
    private ConsumerAluno consumerAluno;

    @Inject
    private ConsumerProfessor consumerProfessor;

    public String login() {

        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);

        if (tipo.equals(TIPO_ALUNO)) {
            aluno = consumerAluno.buscarPorEmail(email);
            if (email.equals(aluno.getEmail()) && senha.equals(aluno.getSenha())) {
                session.setAttribute("usuario", aluno);
                session.setAttribute("tipoUsuario", "aluno");
                return TIPO_ALUNO.toLowerCase() + "/index.xhtml?faces-redirect=true";
            }
        } else if (tipo.equals(TIPO_PROFESSOR)) {
            professor = consumerProfessor.buscarPorEmail(email);
            System.out.println("Professor: " + professor.toString());
            if (email.equals(professor.getEmail()) && senha.equals(professor.getSenha())) {
                session.setAttribute("usuario", professor);
                session.setAttribute("tipoUsuario", "professor");
                return TIPO_PROFESSOR.toLowerCase() + "/index.xhtml?faces-redirect=true";
            }
        }
        return null;
    }

    public String logout() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().invalidateSession();
        return "/index.xhtml?faces-redirect=true";
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTIPO_ALUNO() {
        return TIPO_ALUNO;
    }

    public String getTIPO_PROFESSOR() {
        return TIPO_PROFESSOR;
    }
}
