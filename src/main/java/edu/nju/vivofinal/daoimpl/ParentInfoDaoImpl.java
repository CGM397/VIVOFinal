package edu.nju.vivofinal.daoimpl;

import edu.nju.vivofinal.dao.BaseDao;
import edu.nju.vivofinal.dao.ParentInfoDao;
import edu.nju.vivofinal.dao.TeacherInfoDao;
import edu.nju.vivofinal.model.Parent;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class ParentInfoDaoImpl implements ParentInfoDao {

    @Autowired
    private BaseDao baseDao;

    @Autowired
    private TeacherInfoDao teacherInfoDao;

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @Override
    public boolean saveParentInfo(Parent parent) {
        return baseDao.save(parent);
    }

    @Override
    public boolean updateParentInfo(Parent parent) {
        return baseDao.update(parent);
    }

    @Override
    public boolean deleteParentInfo(long parentId) {
        return baseDao.delete(Parent.class, parentId);
    }

    @Override
    public Parent findParentById(long parentId) {
        return (Parent) baseDao.findById(Parent.class, parentId);
    }

    @Override
    public Parent findParentByMail(String parentMail) {
        Parent res = new Parent();
        try (Session session = baseDao.getSession()) {
            Transaction transaction = session.beginTransaction();
            String hql = "select p from Parent p where p.parentMail = ?1";
            Query query = session.createQuery(hql);
            query.setParameter(1, parentMail);
            if(!query.list().isEmpty())
                res = (Parent) query.list().get(0);
            transaction.commit();
        } catch (Exception e) {
            logger.error(new Date().toString() + ": ", e);
        }
        return res;
    }

    @Override
    public List<Parent> findAllParentsByTeacherId(long teacherId) {
        return teacherInfoDao.findTeacherById(teacherId).getParents();
    }

    @Override
    public List<Parent> findAllParents() {
        return (List<Parent>) baseDao.getAllList(Parent.class);
    }
}
