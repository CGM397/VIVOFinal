package edu.nju.vivofinal.dao;

import edu.nju.vivofinal.model.Customer;

import java.util.ArrayList;

public interface CustomerInfoDao {

    boolean saveCustomerInfo(Customer customer);

    boolean updateCustomerInfo(Customer customer);

    Customer findCustomerInfoByMail(String customerMail);
    
    ArrayList<Customer> showAllCustomers();
}
