package edu.nju.vivofinal.daoimpl;

import edu.nju.vivofinal.dao.BaseDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;
import java.util.Date;
import java.util.List;

@Repository
public class BaseDaoImpl implements BaseDao {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @Override
    public Session getSession() {
        return entityManagerFactory.unwrap(SessionFactory.class).openSession();
    }

    @Override
    public boolean save(Object object) {
        boolean res = false;
        try(Session session = getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(object);
            transaction.commit();
            res = true;
        }catch (Exception e) {
            logger.error(new Date().toString() + ": ", e);
        }
        return res;
    }

    @Override
    public boolean update(Object object) {
        boolean res = false;
        try(Session session = getSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(object);
            transaction.commit();
            res = true;
        }catch (Exception e) {
            logger.error(new Date().toString() + ": ", e);
        }
        return res;
    }

    @Override
    public boolean delete(Class c, long id) {
        boolean res = false;
        try(Session session = getSession()){
            Transaction transaction = session.beginTransaction();
            Object obj = session.get(c, id);
            session.delete(obj);
            transaction.commit();
            res = true;
        }catch (Exception e){
            logger.error(new Date().toString() + ": ", e);
        }

        return res;
    }

    @Override
    public Object findById(Class c, long id) {
        Object res = null;
        try(Session session = getSession()){
            res = session.get(c, id);
        }catch (Exception e){
            logger.error(new Date().toString() + ": ", e);
        }

        return res;
    }

    @Override
    public List getAllList(Class c) {
        List res = null;
        try(Session session = getSession()){
            String sql = "from " + c.getName();
            res = session.createQuery(sql).list();
        }catch (Exception e){
            logger.error(new Date().toString() + ": ", e);
        }
        return res;
    }
}
