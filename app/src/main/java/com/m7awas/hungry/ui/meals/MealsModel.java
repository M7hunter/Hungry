package com.m7awas.hungry.ui.meals;

import android.content.Context;

import com.m7awas.hungry.Model.Meal;
import com.m7awas.hungry.localeDB.HungryDataBase;
import com.m7awas.hungry.localeDB.MealsDao;

import java.util.ArrayList;
import java.util.List;

class MealsModel implements MealsContract.Model {

    private MealsDao mealsDao;

    MealsModel(Context context) {
        this.mealsDao = HungryDataBase.getInstance(context).mealsDao();
    }

    @Override
    public void addDummyMealsForRestaurant(int restaurantId) {
        List<Meal> dummyMeals = new ArrayList<>();
        for (int i = 1; i < 4; i++)
        {
            dummyMeals.add(new Meal(restaurantId, "meal " + i, "this should be a meal description which describes meal contents in detail"
                    , "https://pluspng.com/img-png/png-meal-food-feature-small-png-885.png"
                    , i + 1, i + "50 g", (i * 200) + "$"));
        }
        mealsDao.addMeals(dummyMeals);
    }

    @Override
    public List<Meal> getMealsByRestaurantId(int restaurantId) {
        return mealsDao.getMealsByRestaurantId(restaurantId);
    }
}
