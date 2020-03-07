package com.m7awas.hungry.ui.restaurants;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.m7awas.hungry.Model.Restaurant;
import com.m7awas.hungry.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class RestaurantsAdapter extends RecyclerView.Adapter<RestaurantsAdapter.Holder> {

    private List<Restaurant> restaurantList;
    private RestaurantItemClickListener itemClickListener;

    RestaurantsAdapter(List<Restaurant> restaurantList, RestaurantItemClickListener itemClickListener) {
        this.restaurantList = restaurantList;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_restaurant, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.bind(restaurantList.get(position));
    }

    @Override
    public int getItemCount() {
        return restaurantList.size();
    }

    class Holder extends RecyclerView.ViewHolder {

        TextView tvTitle, tvMealsCount;
        ImageView ivIcon;
        FloatingActionButton fabArrow;

        Holder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tv_item_restaurant_title);
            tvMealsCount = itemView.findViewById(R.id.tv_meals_count);
            ivIcon = itemView.findViewById(R.id.iv_item_restaurant_icon);
            fabArrow = itemView.findViewById(R.id.fab_restaurant_arrow);
        }

        void bind(final Restaurant restaurant) {
            tvTitle.setText(restaurant.getTitle());
            tvMealsCount.setText(itemView.getContext().getString(R.string.items_count, restaurant.getMealsCount()));

            Picasso.with(itemView.getContext())
                    .load(!restaurant.getIconUrl().isEmpty() ? restaurant.getIconUrl() : "empty url")
                    .into(ivIcon);

            View.OnClickListener clickListener = new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemClickListener.onClick(restaurant);
                }
            };
            fabArrow.setOnClickListener(clickListener);
            itemView.setOnClickListener(clickListener);
        }
    }
}
