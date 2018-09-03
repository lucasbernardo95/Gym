package com.gym.test;

import com.gym.dao.AlunoDaoImpl;
import com.gym.model.Aluno;
import java.util.Date;

/**
 *
 * @author lber
 */
public class CrudAluno {
    
    public static void main(String[] args) {
        Aluno a = null;
//        a = new Aluno("lucas", 23, 1.79, 75.00, new Date());
        AlunoDaoImpl dao = new AlunoDaoImpl(Aluno.class);     
        
//        dao.save(a);
        a = dao.findById(1);
        System.out.println(a.toString());
    }
    
}
