package com.m7awas.hungry.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Meal {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo
    private int restaurantId;

    @ColumnInfo
    private String title;

    @ColumnInfo
    private String description;

    @ColumnInfo
    private String iconUrl;

    @ColumnInfo
    private int rate;

    @ColumnInfo
    private String weight;

    @ColumnInfo
    private String price;

    public Meal() {
    }

    @Ignore
    public Meal(int restaurantId, String title, String description, String iconUrl, int rate, String weight, String price) {
        this.restaurantId = restaurantId;
        this.title = title;
        this.description = description;
        this.iconUrl = iconUrl;
        this.rate = rate;
        this.weight = weight;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
