package com.m7awas.hungry.ui.restaurants;

import android.content.Context;

import com.m7awas.hungry.Model.Restaurant;
import com.m7awas.hungry.localeDB.HungryDataBase;
import com.m7awas.hungry.localeDB.RestaurantsDao;

import java.util.ArrayList;
import java.util.List;

class RestaurantsModel implements RestaurantsContract.Model {

    private RestaurantsDao restaurantsDao;

    RestaurantsModel(Context context) {
        this.restaurantsDao = HungryDataBase.getInstance(context).restaurantsDao();
    }

    @Override
    public void addDummyRestaurants() {
        List<Restaurant> dummyRestaurants = new ArrayList<>();
        for (int i = 1; i < 7; i++)
        {
            dummyRestaurants.add(new Restaurant("res " + i, i + 1
                    , "https://pluspng.com/img-png/png-meal-food-feature-small-png-885.png"));
        }
        restaurantsDao.addRestaurants(dummyRestaurants);
    }

    @Override
    public List<Restaurant> getRestaurants() {
        return restaurantsDao.getAllRestaurants();
    }
}
