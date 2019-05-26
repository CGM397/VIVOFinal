package edu.nju.vivofinal.dao;

import org.hibernate.Session;

import java.util.List;

public interface BaseDao {

    Session getSession();

    boolean save(Object object);

    boolean update(Object object);

    boolean delete(Class c, long id);

    Object findById(Class c, long id);

    List getAllList(Class c);
}
