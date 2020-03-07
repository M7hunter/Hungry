package com.m7awas.hungry.ui.meals;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.m7awas.hungry.Model.Meal;
import com.m7awas.hungry.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MealsAdapter extends RecyclerView.Adapter<MealsAdapter.Holder> {

    private List<Meal> mealList;

    MealsAdapter(List<Meal> mealList) {
        this.mealList = mealList;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_meal, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.bind(mealList.get(position));
    }

    @Override
    public int getItemCount() {
        return mealList.size();
    }

    class Holder extends RecyclerView.ViewHolder {

        TextView tvTitle, tvDescription, tvWeight, tvPrice;
        ImageView ivIcon;
        RatingBar rbRate;

        Holder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tv_item_meal_title);
            tvDescription = itemView.findViewById(R.id.tv_item_meal_description);
            rbRate = itemView.findViewById(R.id.rb_item_meal);
            tvWeight = itemView.findViewById(R.id.tv_item_meal_weight);
            tvPrice = itemView.findViewById(R.id.tv_item_meal_price);
            ivIcon = itemView.findViewById(R.id.iv_item_meal_icon);
        }

        void bind(final Meal meal) {
            tvTitle.setText(meal.getTitle());
            tvDescription.setText(meal.getDescription());
            tvWeight.setText(meal.getWeight());
            tvPrice.setText(meal.getPrice());
            rbRate.setRating(meal.getRate());

            Picasso.with(itemView.getContext())
                    .load(!meal.getIconUrl().isEmpty() ? meal.getIconUrl() : "empty url")
                    .into(ivIcon);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (tvDescription.getVisibility() == View.VISIBLE)
                    {
                        tvDescription.setVisibility(View.GONE);
                    }
                    else
                    {
                        tvDescription.setVisibility(View.VISIBLE);
                    }
                }
            });
        }
    }
}
