package com.ifpb.followup.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.json.JsonObject;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Amanda
 */
@Entity
public class Professor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nome;
    @Column(unique = true)
    private String email;
    private String senha;
    private int matricula;

    public Professor() {
    }

    public Professor(JsonObject jsonObject) {
        this.id = jsonObject.getJsonNumber("id").longValue();
        this.nome = jsonObject.getString("nome");
        this.email = jsonObject.getString("email");
        this.senha = jsonObject.getString("senha");
        this.matricula = jsonObject.getInt("matricula");
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 23 * hash + Objects.hashCode(this.nome);
        hash = 23 * hash + Objects.hashCode(this.email);
        hash = 23 * hash + Objects.hashCode(this.senha);
        hash = 23 * hash + this.matricula;
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
        final Professor other = (Professor) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.matricula != other.matricula) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Professor{" + "id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", matricula=" + matricula + '}';
    }

}
