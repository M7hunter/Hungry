package com.m7awas.hungry.ui.login;

interface LoginContract {

    interface View {

        void initViews();

        void onPhoneValidationError(String error);

        void onPasswordValidationError(String error);

        void gotoRestaurantsActivity();
    }

    interface Presenter {

        void onLoginClicked(String phone, String password);

        void onDestroy();
    }
}
