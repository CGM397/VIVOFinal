package edu.nju.vivofinal.daoimpl;

import edu.nju.vivofinal.dao.BaseDao;
import edu.nju.vivofinal.dao.CommonNoticeDao;
import edu.nju.vivofinal.dao.TeacherInfoDao;
import edu.nju.vivofinal.model.CommonNotice;
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
public class CommonNoticeDaoImpl implements CommonNoticeDao {

    @Autowired
    private BaseDao baseDao;
    @Autowired
    private TeacherInfoDao teacherInfoDao;

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @Override
    public boolean saveCommonNotice(CommonNotice commonNotice) {
        return baseDao.save(commonNotice);
    }

    @Override
    public boolean deleteCommonNotice(long commonNoticeId) {
        return baseDao.delete(CommonNotice.class, commonNoticeId);
    }

    @Override
    public CommonNotice findCommonNoticeById(long commonNoticeId) {
        return (CommonNotice) baseDao.findById(CommonNotice.class, commonNoticeId);
    }

    @Override
    public List<CommonNotice> findAllCommonNotices(long teacherId) {
        List<CommonNotice> res = new ArrayList<>();
        try (Session session = baseDao.getSession()) {
            Transaction transaction = session.beginTransaction();
            String hql = "select c from CommonNotice c where c.teacherId = ?1";
            Query query = session.createQuery(hql);
            query.setParameter(1, teacherId);
            if(!query.list().isEmpty())
                res =(List<CommonNotice>) query.list();
            transaction.commit();
        } catch (Exception e) {
            logger.error(new Date().toString() + ": ", e);
        }
        return res;
    }

    @Override
    public List<CommonNotice> findCommonNoticesByParentMail(String parentMail) {
        long teacherId = teacherInfoDao.findTeacherByParentMail(parentMail).getTeacherId();
        return findAllCommonNotices(teacherId);
    }
}
