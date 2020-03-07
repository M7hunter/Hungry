package com.m7awas.hungry.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;
import com.m7awas.hungry.R;
import com.m7awas.hungry.ui.restaurants.RestaurantsActivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {

    private LoginContract.Presenter presenter;
    private EditText etPhone, etPassword;
    private TextInputLayout tlPhone, tlPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        presenter = new LoginPresenter(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        presenter.onDestroy();
    }

    @Override
    public void initViews() {
        etPhone = findViewById(R.id.et_phone);
        etPassword = findViewById(R.id.et_password);
        tlPhone = findViewById(R.id.tl_phone);
        tlPassword = findViewById(R.id.tl_password);
        btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tlPhone.setError(null);
                tlPassword.setError(null);

                presenter.onLoginClicked(etPhone.getText().toString(), etPassword.getText().toString());
            }
        });
    }

    @Override
    public void onPhoneValidationError(String error) {
        tlPhone.setError(error);
    }

    @Override
    public void onPasswordValidationError(String error) {
        tlPassword.setError(error);
    }

    @Override
    public void gotoRestaurantsActivity() {
        startActivity(new Intent(this, RestaurantsActivity.class)
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));
    }
}
