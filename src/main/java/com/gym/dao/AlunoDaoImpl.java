/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gym.dao;

import com.gym.model.Aluno;
import com.gym.persist.GenericDaoImpl;

/**
 *
 * @author lber
 */
public class AlunoDaoImpl extends GenericDaoImpl<Aluno, Integer> implements AlunoDao{

    public AlunoDaoImpl(Class<Aluno> klass) {
        super(klass);
    }
    
}
