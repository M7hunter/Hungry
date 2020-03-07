package com.m7awas.hungry.localeDB;

import com.m7awas.hungry.Model.Restaurant;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface RestaurantsDao {

    @Insert
    void addRestaurants(List<Restaurant> newRestaurants);

    @Query("SELECT * FROM Restaurant")
    List<Restaurant> getAllRestaurants();
}
