/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.followup.interfaces;

import com.ifpb.followup.model.Aluno;
import java.util.List;

/**
 *
 * @author Cliente
 */
public interface AlunoIF {

    Aluno salvar(Aluno aluno);

    Aluno buscar(long id);

    boolean delete(long obj);

    Aluno atualizar(long id, Aluno aluno);

    List<Aluno> alunos();

}
