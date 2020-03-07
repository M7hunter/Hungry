package com.m7awas.hungry.ui.meals;

class MealsPresenter implements MealsContract.Presenter {

    private MealsContract.View view;
    private MealsContract.Model model;

    MealsPresenter(MealsActivity mealView) {
        view = mealView;
        model = new MealsModel(mealView);

        view.initViews();
        view.updateRestaurantTitle(view.getRestaurantTitle());

        int restaurantId = view.getRestaurantId();
        if (model.getMealsByRestaurantId(restaurantId).isEmpty())
            model.addDummyMealsForRestaurant(restaurantId);

        view.updateMealsRV(model.getMealsByRestaurantId(restaurantId));
    }

    @Override
    public void onDestroy() {
        view = null;
        model = null;
    }
}
