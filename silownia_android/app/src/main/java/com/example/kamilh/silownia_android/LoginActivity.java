package com.example.kamilh.silownia_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by KamilH on 2015-04-22.
 */
public class LoginActivity extends FragmentActivity implements View.OnClickListener {
    private Button btnLogin, btnLinkToRegisterScreen;
    private EditText login, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLinkToRegisterScreen = (Button) findViewById(R.id.btnLinkToRegisterScreen);

        btnLogin.setOnClickListener(this);
        btnLinkToRegisterScreen.setOnClickListener(this);

        login = (EditText) findViewById(R.id.login);
        password = (EditText) findViewById(R.id.password);
    }

    private void btnLogin_click(){
        if (login.getText().toString() == "admin"){
            if (password.getText().toString() == "admin"){
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                finish();
            } else password.setError("Hasło to 'admin'!");
        } else login.setError("Login to 'admin'!");
    }

    private void setBtnLinkToRegister_click(){
        Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin:
                btnLogin_click();
                break;
            case R.id.btnLinkToRegisterScreen:
                setBtnLinkToRegister_click();
                break;
        }
    }
}
