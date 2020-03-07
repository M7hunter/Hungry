package com.m7awas.hungry.ui.meals;

import com.m7awas.hungry.Model.Meal;

import java.util.List;

interface MealsContract {

    interface View {

        void initViews();

        String getRestaurantTitle();

        int getRestaurantId();

        void updateRestaurantTitle(String title);

        void updateMealsRV(List<Meal> meals);
    }

    interface Presenter {

        void onDestroy();
    }

    interface Model {

        void addDummyMealsForRestaurant(int restaurantId);

        List<Meal> getMealsByRestaurantId(int restaurantId);
    }
}
