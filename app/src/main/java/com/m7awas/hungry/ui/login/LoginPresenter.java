package com.m7awas.hungry.ui.login;

import android.util.Patterns;

class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View view;

    LoginPresenter(LoginContract.View loginView) {
        this.view = loginView;

        view.initViews();
    }

    @Override
    public void onLoginClicked(String phone, String password) {
        boolean gotoRestaurantsActivity = true;

        // phone
        if (phone.isEmpty())
        {
            view.onPhoneValidationError("phone is empty");
            gotoRestaurantsActivity = false;
        }
        else if (phone.length() != 11)
        {
            view.onPhoneValidationError("phone must be 11 number");
            gotoRestaurantsActivity = false;
        }
        else if (!Patterns.PHONE.matcher(phone).matches())
        {
            view.onPhoneValidationError("phone is not valid");
            gotoRestaurantsActivity = false;
        }

        // password
        if (password.isEmpty())
        {
            view.onPasswordValidationError("password is empty");
            gotoRestaurantsActivity = false;
        }

        // valid ?
        if (gotoRestaurantsActivity)
        {
            view.gotoRestaurantsActivity();
        }
    }

    @Override
    public void onDestroy() {
        view = null;
    }
}
