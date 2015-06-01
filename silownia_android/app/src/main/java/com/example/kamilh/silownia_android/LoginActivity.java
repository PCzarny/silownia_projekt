package com.example.kamilh.silownia_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by KamilH on 2015-04-22.
 */
public class LoginActivity extends FragmentActivity implements View.OnClickListener {
    private Button btnLogin, btnLinkToRegisterScreen;
    private EditText textLogin, textPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLinkToRegisterScreen = (Button) findViewById(R.id.btnLinkToRegisterScreen);

        btnLogin.setOnClickListener(this);
        btnLinkToRegisterScreen.setOnClickListener(this);

        textLogin = (EditText) findViewById(R.id.textLogin);
        textPassword = (EditText) findViewById(R.id.textPassword);
    }

    private void  loginUser(){
        String login = textLogin.getText().toString();
        String password = textPassword.getText().toString();

        RequestParams params = new RequestParams();
        if(Utility.isNotNull(login) && Utility.isNotNull(password)) {
            params.put("username", login);
            params.put("password", password);
            invokeWS(params);
        }
        else{
            Toast.makeText(getApplicationContext(), "Proszę wypełnić wszystkie pola!", Toast.LENGTH_LONG).show();
        }
    }

    private void invokeWS(RequestParams params) {
        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://192.168.56.1:8080/rest/login/dologin", params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {
                String response = bytes.toString();
                Toast.makeText(getApplicationContext(), response, Toast.LENGTH_LONG).show();
                try {
                    JSONObject obj = new JSONObject(response);
                    if (obj.getBoolean("status")) {
                        Toast.makeText(getApplicationContext(), "Zalogowano poprawnie!", Toast.LENGTH_LONG).show();
                        navigateToHomeActivity();
                    } else {
                        Toast.makeText(getApplicationContext(), obj.getString("error_msg"), Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    Toast.makeText(getApplicationContext(), "Error Occured [Server's JSON response might be invalid]!", Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] bytes, Throwable throwable) {
                if (statusCode == 404) {
                    Toast.makeText(getApplicationContext(), "404 - Nie odnaleziono serwera!", Toast.LENGTH_LONG).show();
                } else if (statusCode == 500) {
                    Toast.makeText(getApplicationContext(), "500 - Coś poszło nie tak po stronie serwera!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), throwable.toString(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }


    private void btnLogin_click(){
        loginUser();
    }

    private void setBtnLinkToRegister_click(){
        Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
        startActivity(i);
        finish();
    }

    private void navigateToHomeActivity() {
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
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
