package edu.nju.vivofinal.dao;

import edu.nju.vivofinal.model.Modification;

import java.util.ArrayList;

public interface ModificationDao {

    boolean addModification(Modification modification);

    boolean updateModification(Modification modification);

    ArrayList<Modification> findRestaurantModification(String restaurantId);

    ArrayList<Modification> showModification();
}
