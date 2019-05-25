package edu.nju.vivofinal.dao;

import edu.nju.vivofinal.model.Restaurant;

import java.util.List;

public interface RestaurantInfoDao {

    List<Restaurant> showAllRestaurants();

    boolean saveRestaurantInfo(Restaurant restaurant);

    boolean updateRestaurantInfo(Restaurant restaurant);

    Restaurant findRestaurantInfoById(String restaurantId);

}
