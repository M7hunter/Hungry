package com.m7awas.hungry.localeDB;

import android.content.Context;

import com.m7awas.hungry.Model.Meal;
import com.m7awas.hungry.Model.Restaurant;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Restaurant.class, Meal.class}, version = 1)
public abstract class HungryDataBase extends RoomDatabase {

    private static HungryDataBase INSTANCE;

    public static HungryDataBase getInstance(Context context) {
        if (INSTANCE == null)
        {
            synchronized (HungryDataBase.class)
            {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(), HungryDataBase.class, "hungryDB.db")
                        .allowMainThreadQueries()
                        .build();
            }
        }
        return INSTANCE;
    }

    public abstract RestaurantsDao restaurantsDao();

    public abstract MealsDao mealsDao();
}
