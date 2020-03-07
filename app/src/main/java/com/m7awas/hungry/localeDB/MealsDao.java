package com.m7awas.hungry.localeDB;

import com.m7awas.hungry.Model.Meal;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface MealsDao {

    @Insert
    void addMeals(List<Meal> newMeals);

    @Query("SELECT * FROM Meal")
    List<Meal> getAllMeals();

    @Query("SELECT * FROM Meal WHERE :restaurantId = restaurantId")
    List<Meal> getMealsByRestaurantId(int restaurantId);
}
