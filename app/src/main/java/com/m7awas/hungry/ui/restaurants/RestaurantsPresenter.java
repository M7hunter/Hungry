package com.m7awas.hungry.ui.restaurants;

class RestaurantsPresenter implements RestaurantsContract.Presenter {

    private RestaurantsContract.View view;
    private RestaurantsContract.Model model;

    RestaurantsPresenter(RestaurantsActivity resView) {
        view = resView;
        model = new RestaurantsModel(resView);

        view.initRestaurantsRV();

        if (model.getRestaurants().isEmpty())
            model.addDummyRestaurants();

        view.updateRestaurantsRV(model.getRestaurants());
    }

    @Override
    public void onDestroy() {
        view = null;
        model = null;
    }
}
