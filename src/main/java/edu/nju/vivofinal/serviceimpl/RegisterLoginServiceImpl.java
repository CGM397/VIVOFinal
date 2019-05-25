package edu.nju.vivofinal.serviceimpl;

import edu.nju.vivofinal.dao.CustomerInfoDao;
import edu.nju.vivofinal.dao.RestaurantInfoDao;
import edu.nju.vivofinal.model.Customer;
import edu.nju.vivofinal.model.Restaurant;
import edu.nju.vivofinal.service.CommonService;
import edu.nju.vivofinal.service.RegisterLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterLoginServiceImpl implements RegisterLoginService {

    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private CommonService commonService;
    @Autowired
    private CustomerInfoDao customerInfoDao;
    @Autowired
    private RestaurantInfoDao restaurantInfoDao;

    private static final String WRONG = "wrong_password";

    private static final String SUCCESS = "success";

    @Override
    public String login(String identity, String account, String password) {
        String res = "";
        if(identity.equals("顾客")) {
            res = customerLoginCheck(account, password);
        }else if(identity.equals("餐厅")) {
            res = restaurantLoginCheck(account, password);
        }
        return res;
    }

    private String customerLoginCheck(String account, String password){
        String res;
        Customer customer = customerInfoDao.findCustomerInfoByMail(account);
        if(customer == null || customer.getCustomerPassword() == null)
            res = WRONG;
        else if(customer.getCustomerPassword().equals(password)) {
            if(customer.isActive())
                res = SUCCESS;
            else
                res = "not_active";
        }
        else
            res = WRONG;
        return res;
    }

    private String restaurantLoginCheck(String account, String password){
        String res;
        Restaurant restaurant = restaurantInfoDao.findRestaurantInfoById(account);
        if(restaurant == null || restaurant.getRestaurantPassword() == null)
            res = WRONG;
        else if(restaurant.getRestaurantPassword().equals(password)) {
            res = SUCCESS;
        }
        else
            res = WRONG;
        return res;
    }

    @Override
    public String sendMail(String customerMail) {
        List<Customer> customers = customerInfoDao.showAllCustomers();
        for(Customer one : customers) {
            if(one.getCustomerMail().equals(customerMail))
                return "duplicate_mail";
        }
        SimpleMailMessage message = new SimpleMailMessage();
        String randomCode = commonService.generateRandomCode(6);
        message.setFrom("980231201@qq.com");
        message.setTo(customerMail);
        message.setSubject("VIVOFinal : 邮箱验证");
        message.setText("验证码 : " + randomCode);
        mailSender.send(message);
        return randomCode;
    }

    @Override
    public boolean customerRegister(String customerMail, String customerPassword,
                                    String customerName, String phoneNumber) {
        String customerId = "c_" + commonService.generateId(6,"customer");
        Customer customer = new Customer(customerId, customerMail, customerPassword, customerName,
                phoneNumber, true);
        return customerInfoDao.saveCustomerInfo(customer);
    }

    @Override
    public String restaurantRegister(String restaurantName, String restaurantPassword) {
        String restaurantId = commonService.generateId(7,"restaurant");
        Restaurant restaurant = new Restaurant(restaurantId, restaurantPassword,
                                                restaurantName,"type");
        if(restaurantInfoDao.saveRestaurantInfo(restaurant))
            return restaurantId;
        else
            return "fail";
    }
}
