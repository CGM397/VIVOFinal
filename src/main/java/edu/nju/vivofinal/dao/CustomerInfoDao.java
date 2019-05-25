package edu.nju.vivofinal.dao;

import edu.nju.vivofinal.model.Customer;

import java.util.List;

public interface CustomerInfoDao {

    boolean saveCustomerInfo(Customer customer);

    boolean updateCustomerInfo(Customer customer);

    Customer findCustomerInfoByMail(String customerMail);
    
    List<Customer> showAllCustomers();
}
