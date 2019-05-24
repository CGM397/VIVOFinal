package edu.nju.vivofinal.dao;

import edu.nju.vivofinal.model.DiscountInfo;
import edu.nju.vivofinal.model.Restaurant;

import java.util.ArrayList;

public interface RestaurantInfoDao {

    ArrayList<Restaurant> showAllRestaurants();

    ArrayList<DiscountInfo> showDiscountInfo(String restaurantId);

    boolean saveRestaurantInfo(Restaurant restaurant);

    boolean updateRestaurantInfo(Restaurant restaurant);

    Restaurant findRestaurantInfoById(String restaurantId);

}
