/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gym.dao;

import com.gym.model.Instrutor;
import com.gym.persist.GenericDaoImpl;

/**
 *
 * @author lber
 */
public class InstrutorDaoImpl extends GenericDaoImpl<Instrutor, Integer> implements InstrutorDao{

    public InstrutorDaoImpl(Class<Instrutor> klass) {
        super(klass);
    }
    
}