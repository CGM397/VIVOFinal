package edu.nju.vivofinal.serviceimpl;

import edu.nju.vivofinal.dao.CustomerInfoDao;
import edu.nju.vivofinal.dao.RestaurantInfoDao;
import edu.nju.vivofinal.model.Customer;
import edu.nju.vivofinal.model.Restaurant;
import edu.nju.vivofinal.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Random;

@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    private CustomerInfoDao customerInfoDao;

    @Autowired
    private RestaurantInfoDao restaurantInfoDao;

    @Override
    public String generateRandomCode(int length) {
        String res = "";
        if(length < 1)
            return res;
        int min = (int)Math.pow(10, length - 1.0);
        int max = (int)Math.pow(10, length) - min;
        Random random = new SecureRandom();
        res = (random.nextInt(max) + min) + "";
        return res;
    }

    @Override
    public String generateId(int length, String identity) {
        int maxId = 0;
        if(identity.equals("customer")) {
            maxId = getMaxCustomerId();
        }else if(identity.equals("restaurant")) {
            maxId = getMaxRestaurantId();
        }
        maxId = maxId + 1;
        StringBuilder res = new StringBuilder(maxId + "");
        int idLength = res.length();
        for(int i = 0; i < length - idLength; i++){
            res.insert(0,'0');
        }
        return res.toString();
    }

    private int getMaxCustomerId(){
        int maxId = 0;
        ArrayList<Customer> customers = customerInfoDao.showAllCustomers();
        if(!customers.isEmpty()) {
            for(Customer one : customers) {
                int currentId = Integer.parseInt(one.getCustomerId().split("_")[1]);
                if(maxId < currentId)
                    maxId = currentId;
            }
        }
        return maxId;
    }

    private int getMaxRestaurantId(){
        int maxId = 0;
        ArrayList<Restaurant> restaurants = restaurantInfoDao.showAllRestaurants();
        if(!restaurants.isEmpty()) {
            for(Restaurant one : restaurants) {
                int currentId = Integer.parseInt(one.getRestaurantId());
                if(maxId < currentId)
                    maxId = currentId;
            }
        }
        return maxId;
    }
}
