package edu.nju.vivofinal.daoimpl;

import edu.nju.vivofinal.dao.BaseDao;
import edu.nju.vivofinal.dao.CustomerInfoDao;
import edu.nju.vivofinal.model.Customer;
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
public class CustomerInfoDaoImpl implements CustomerInfoDao {

    @Autowired
    private BaseDao baseDao;

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @Override
    public boolean saveCustomerInfo(Customer customer) {
        return baseDao.save(customer);
    }

    @Override
    public boolean updateCustomerInfo(Customer customer) {
        return baseDao.update(customer);
    }

    @Override
    public Customer findCustomerInfoByMail(String customerMail) {
        Customer res = new Customer();
        try (Session session = baseDao.getSession()) {
            Transaction transaction = session.beginTransaction();
            String hql = "select c from Customer c where c.customerMail = ?1";
            Query query = session.createQuery(hql);
            query.setParameter(1,customerMail);
            if(!query.list().isEmpty())
                res = (Customer) query.list().get(0);
            transaction.commit();
        } catch (Exception e) {
            logger.error(new Date().toString() + ": ", e);
        }
        return res;
    }

    @Override
    public List<Customer> showAllCustomers() {
        ArrayList<Customer> res = new ArrayList<>();
        try(Session session = baseDao.getSession()) {
            Transaction transaction = session.beginTransaction();
            String hql = "from Customer";
            Query query = session.createQuery(hql);
            if(!query.list().isEmpty())
                res = (ArrayList<Customer>) query.list();
            transaction.commit();
        }catch (Exception e) {
            logger.error(new Date().toString() + ": ", e);
        }
        return res;
    }
}
