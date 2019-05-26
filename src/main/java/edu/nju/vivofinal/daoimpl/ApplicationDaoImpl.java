package edu.nju.vivofinal.daoimpl;

import edu.nju.vivofinal.dao.ApplicationDao;
import edu.nju.vivofinal.dao.BaseDao;
import edu.nju.vivofinal.model.Application;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class ApplicationDaoImpl implements ApplicationDao {

    @Autowired
    private BaseDao baseDao;

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @Override
    public boolean saveApplication(Application application) {
        return baseDao.save(application);
    }

    @Override
    public boolean updateApplication(Application application) {
        return baseDao.update(application);
    }

    @Override
    public Application findApplicationById(long applicationId) {
        return (Application) baseDao.findById(Application.class, applicationId);
    }

    @Override
    public List<Application> findApplicationsByTeacherMail(String teacherMail) {
        List<Application> res = new ArrayList<>();
        try (Session session = baseDao.getSession()) {
            Transaction transaction = session.beginTransaction();
            String hql = "select a from Application a where a.teacherMail = ?1 and a.checked = false";
            Query query = session.createQuery(hql);
            query.setParameter(1, teacherMail);
            if(!query.list().isEmpty())
                res =(List<Application>) query.list();
            transaction.commit();
        } catch (Exception e) {
            logger.error(new Date().toString() + ": ", e);
        }
        return res;
    }
}
