package edu.nju.vivofinal.dao;

import edu.nju.vivofinal.model.CommodityInfo;
import edu.nju.vivofinal.model.DiscountInfo;

import java.util.ArrayList;

public interface CommodityInfoDao {

    boolean saveCommodityInfo(CommodityInfo commodityInfo);

    boolean updateCommodityInfo(CommodityInfo commodityInfo);

    boolean updateDiscountInfo(DiscountInfo discountInfo);

    boolean saveDiscountInfo(DiscountInfo discountInfo);

    ArrayList<CommodityInfo> showCommodity(String restaurantId);

    ArrayList<CommodityInfo> showCommodityToCome(String restaurantId);
}
