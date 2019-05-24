package edu.nju.vivofinal.dao;

import edu.nju.vivofinal.model.OrderInfo;

import java.util.ArrayList;
import java.util.Date;

public interface OrderInfoDao {

    OrderInfo findOneOrderById(long orderId);

    ArrayList<OrderInfo> showCustomerOrders(String customerId);

    ArrayList<OrderInfo> showRestaurantOrders(String restaurantId);

    boolean saveOrderInfo(OrderInfo orderInfo);

    boolean updateOrderCondition(long orderId, String orderCondition);

    boolean confirmOrderInAdvance(long orderId, Date confirmTime);
}
