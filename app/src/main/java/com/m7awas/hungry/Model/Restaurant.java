package com.m7awas.hungry.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Restaurant {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo
    private String title;

    @ColumnInfo
    private int mealsCount;

    @ColumnInfo
    private String iconUrl;

    public Restaurant() {
    }

    @Ignore
    public Restaurant(String title, int mealsCount, String iconUrl) {
        this.title = title;
        this.mealsCount = mealsCount;
        this.iconUrl = iconUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getMealsCount() {
        return mealsCount;
    }

    public void setMealsCount(int mealsCount) {
        this.mealsCount = mealsCount;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }
}
