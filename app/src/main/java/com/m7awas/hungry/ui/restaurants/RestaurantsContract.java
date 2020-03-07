package com.m7awas.hungry.ui.restaurants;

import com.m7awas.hungry.Model.Restaurant;

import java.util.List;

interface RestaurantsContract {

    interface View {

        void initRestaurantsRV();

        void updateRestaurantsRV(List<Restaurant> restaurants);
    }

    interface Presenter {

        void onDestroy();
    }

    interface Model {

        void addDummyRestaurants();

        List<Restaurant>  getRestaurants();
    }
}
