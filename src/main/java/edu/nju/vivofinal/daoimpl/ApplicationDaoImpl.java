package edu.nju.vivofinal.daoimpl;

import edu.nju.vivofinal.dao.ApplicationDao;
import edu.nju.vivofinal.dao.BaseDao;
import edu.nju.vivofinal.model.ParentApplication;
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
    public boolean saveApplication(ParentApplication parentApplication) {
        return baseDao.save(parentApplication);
    }

    @Override
    public boolean updateApplication(ParentApplication parentApplication) {
        return baseDao.update(parentApplication);
    }

    @Override
    public ParentApplication findApplicationById(long applicationId) {
        return (ParentApplication) baseDao.findById(ParentApplication.class, applicationId);
    }

    @Override
    public List<ParentApplication> findApplicationsByTeacherMail(String teacherMail) {
        List<ParentApplication> res = new ArrayList<>();
        try (Session session = baseDao.getSession()) {
            Transaction transaction = session.beginTransaction();
            String hql = "select a from ParentApplication a where a.teacherMail = ?1 and a.checked = false";
            Query query = session.createQuery(hql);
            query.setParameter(1, teacherMail);
            if(!query.list().isEmpty())
                res =(List<ParentApplication>) query.list();
            transaction.commit();
        } catch (Exception e) {
            logger.error(new Date().toString() + ": ", e);
        }
        return res;
    }
}
