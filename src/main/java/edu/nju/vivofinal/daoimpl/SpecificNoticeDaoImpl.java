package edu.nju.vivofinal.daoimpl;

import edu.nju.vivofinal.dao.BaseDao;
import edu.nju.vivofinal.dao.ParentInfoDao;
import edu.nju.vivofinal.dao.SpecificNoticeDao;
import edu.nju.vivofinal.model.SpecificNotice;
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
public class SpecificNoticeDaoImpl implements SpecificNoticeDao {

    @Autowired
    private BaseDao baseDao;
    @Autowired
    private ParentInfoDao parentInfoDao;

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @Override
    public boolean saveSpecificNotice(SpecificNotice specificNotice) {
        return baseDao.save(specificNotice);
    }

    @Override
    public boolean deleteSpecificNotice(long specificNoticeId) {
        return baseDao.delete(SpecificNotice.class, specificNoticeId);
    }

    @Override
    public SpecificNotice findSpecificNoticeById(long specificNoticeId) {
        return (SpecificNotice) baseDao.findById(SpecificNotice.class, specificNoticeId);
    }

    @Override
    public List<SpecificNotice> findAllSpecificNotices(long teacherId) {
        List<SpecificNotice> res = new ArrayList<>();
        try (Session session = baseDao.getSession()) {
            Transaction transaction = session.beginTransaction();
            String hql = "select s from SpecificNotice s where s.teacherId = ?1";
            Query query = session.createQuery(hql);
            query.setParameter(1, teacherId);
            if(!query.list().isEmpty())
                res =(List<SpecificNotice>) query.list();
            transaction.commit();
        } catch (Exception e) {
            logger.error(new Date().toString() + ": ", e);
        }
        return res;
    }

    @Override
    public List<SpecificNotice> findSpecificNoticesByParentMail(String parentMail) {
        List<SpecificNotice> res = new ArrayList<>();
        long parentId = parentInfoDao.findParentByMail(parentMail).getParentId();
        try (Session session = baseDao.getSession()) {
            Transaction transaction = session.beginTransaction();
            String hql = "select s from SpecificNotice s where s.parentId = ?1";
            Query query = session.createQuery(hql);
            query.setParameter(1, parentId);
            if(!query.list().isEmpty())
                res =(List<SpecificNotice>) query.list();
            transaction.commit();
        } catch (Exception e) {
            logger.error(new Date().toString() + ": ", e);
        }
        return res;
    }
}
