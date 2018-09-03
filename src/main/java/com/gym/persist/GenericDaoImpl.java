/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gym.persist;

import com.gym.util.HibernateUtil;
import java.io.Serializable;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author lber
 */
public class GenericDaoImpl<T, ID extends Serializable> implements GenericDao<T, ID> {

    private Class<T> klass;
    private Session session = null;

    public GenericDaoImpl() {
    }

    public GenericDaoImpl(Class<T> klass) {

        this.klass = klass;
        session = HibernateUtil.getSessionFactory().openSession();
    }

    @Override
    public T findById(ID id) {
        T object = (T) session.get(klass, id);
        return object;
    }

    @Override
    public void save(T object) {
        Transaction t = session.beginTransaction();
        session.saveOrUpdate((T) object);
        t.commit();
    }

    @Override
    public void delete(T object) {
        Transaction t = session.beginTransaction();
        session.delete((T) object);
        t.commit();
    }

    @Override
    public List<T> listAll() {
        Transaction t = session.beginTransaction();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(klass);

        Root<T> klassRoot = query.from(klass);

        query.select(klassRoot);

        List<T> result = session.createQuery(query).getResultList();

        t.commit();

        return result;

    }

    @Override
    public List<T> findAll() {
        return findAll(null);
    }

    @SuppressWarnings({"deprecation", "unchecked"})
    @Override
    public List<T> findAll(Order order) {
        Transaction transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(klass);
        if (order != null) {
            criteria.addOrder(order);
        }
        transaction.commit();
        return (List<T>) criteria.list();
    }

    // Buscas avançadas
    @Override
    public List<T> findAllBy(String property, List<?> values) {
        return findAllBy(property, values, null);
    }

    @SuppressWarnings({"deprecation", "unchecked"})
    @Override
    public List<T> findAllBy(String property, List<?> values, Order order) {
        Transaction transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(klass).add(Restrictions.in(property, values));
        if (order != null) {
            criteria.addOrder(order);
        }
        transaction.commit();
        return (List<T>) criteria.list();
    }

    @Override
    public void close() {
        session.close();
    }
}