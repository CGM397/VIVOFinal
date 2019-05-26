package edu.nju.vivofinal.daoimpl;

import edu.nju.vivofinal.dao.BaseDao;
import edu.nju.vivofinal.dao.TeacherInfoDao;
import edu.nju.vivofinal.model.Teacher;
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
public class TeacherInfoDaoImpl implements TeacherInfoDao {

    @Autowired
    private BaseDao baseDao;

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @Override
    public boolean saveTeacherInfo(Teacher teacher) {
        return baseDao.save(teacher);
    }

    @Override
    public boolean updateTeacherInfo(Teacher teacher) {
        return baseDao.update(teacher);
    }

    @Override
    public boolean deleteTeacherInfo(long teacherId) {
        return baseDao.delete(Teacher.class, teacherId);
    }

    @Override
    public Teacher findTeacherById(long teacherId) {
        return (Teacher) baseDao.findById(Teacher.class, teacherId);
    }

    @Override
    public Teacher findTeacherByMail(String teacherMail) {
        Teacher res = new Teacher();
        try (Session session = baseDao.getSession()) {
            Transaction transaction = session.beginTransaction();
            String hql = "select t from Teacher t where t.teacherMail = ?1";
            Query query = session.createQuery(hql);
            query.setParameter(1, teacherMail);
            if(!query.list().isEmpty())
                res = (Teacher) query.list().get(0);
            transaction.commit();
        } catch (Exception e) {
            logger.error(new Date().toString() + ": ", e);
        }
        return res;
    }

    @Override
    public List<Teacher> findAllTeachers() {
        return (List<Teacher>) baseDao.getAllList(Teacher.class);
    }
}
