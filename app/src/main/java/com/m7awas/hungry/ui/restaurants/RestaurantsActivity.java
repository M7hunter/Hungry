package com.m7awas.hungry.ui.restaurants;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.m7awas.hungry.Model.Restaurant;
import com.m7awas.hungry.R;
import com.m7awas.hungry.ui.meals.MealsActivity;

import java.util.List;

public class RestaurantsActivity extends AppCompatActivity implements RestaurantsContract.View {

    public static final String RESTAURANT_ID = "restaurant_id_key";
    public static final String RESTAURANT_TITLE = "restaurant_title_key";

    private RestaurantsContract.Presenter presenter;
    private RecyclerView rvRestaurants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);

        presenter = new RestaurantsPresenter(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        presenter.onDestroy();
    }

    @Override
    public void initRestaurantsRV() {
        if (rvRestaurants == null) rvRestaurants = findViewById(R.id.rv_restaurants);
        rvRestaurants.setLayoutManager(new LinearLayoutManager(this));
        rvRestaurants.setHasFixedSize(true);
    }

    @Override
    public void updateRestaurantsRV(List<Restaurant> restaurants) {
        rvRestaurants.setAdapter(new RestaurantsAdapter(restaurants
                , new RestaurantItemClickListener() {
            @Override
            public void onClick(Restaurant restaurant) {
                startActivity(new Intent(RestaurantsActivity.this, MealsActivity.class)
                        .putExtra(RESTAURANT_ID, restaurant.getId())
                        .putExtra(RESTAURANT_TITLE, restaurant.getTitle()));
            }
        }));
    }
}
