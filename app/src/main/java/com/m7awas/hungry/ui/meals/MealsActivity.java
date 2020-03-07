package com.m7awas.hungry.ui.meals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.m7awas.hungry.Model.Meal;
import com.m7awas.hungry.R;

import java.util.List;

import static com.m7awas.hungry.ui.restaurants.RestaurantsActivity.RESTAURANT_ID;
import static com.m7awas.hungry.ui.restaurants.RestaurantsActivity.RESTAURANT_TITLE;

public class MealsActivity extends AppCompatActivity implements MealsContract.View {

    private MealsContract.Presenter presenter;
    private TextView tvRestaurantTitle;
    private RecyclerView rvMeals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meals);

        presenter = new MealsPresenter(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        presenter.onDestroy();
    }

    @Override
    public void initViews() {
        tvRestaurantTitle = findViewById(R.id.tv_restaurant_title);
        rvMeals = findViewById(R.id.rv_meals);
        rvMeals.setLayoutManager(new LinearLayoutManager(this));
        rvMeals.setHasFixedSize(true);
    }

    @Override
    public String getRestaurantTitle() {
        return getIntent().getExtras() != null ? getIntent().getExtras().getString(RESTAURANT_TITLE) : "";
    }

    @Override
    public int getRestaurantId() {
        return getIntent().getExtras() != null ? getIntent().getExtras().getInt(RESTAURANT_ID) : -111;
    }

    @Override
    public void updateRestaurantTitle(String title) {
        tvRestaurantTitle.setText(getString(R.string.restaurant_menu, title));
    }

    @Override
    public void updateMealsRV(List<Meal> meals) {
        rvMeals.setAdapter(new MealsAdapter(meals));
    }
}
