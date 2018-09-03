package com.gym.persist;

import java.util.List;
import org.hibernate.criterion.Order;
import java.io.Serializable;

/**
 *
 * @author lber
 */
public interface GenericDao<T, ID extends Serializable> {

    void save(T object);

    void delete(T object);

    T findById(ID id);

    List<T> listAll();

    List<T> findAll();

    List<T> findAll(Order order);

    List<T> findAllBy(String property, List<?> values, Order order);

    List<T> findAllBy(String property, List<?> values);

    void close();
}