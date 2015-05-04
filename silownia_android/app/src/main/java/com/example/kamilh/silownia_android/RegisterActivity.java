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
public class RegisterActivity extends FragmentActivity implements View.OnClickListener {
    private Button btnRegister, btnLinkToLoginScreen;
    private EditText textLogin, textEmail, textPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnLinkToLoginScreen = (Button) findViewById(R.id.btnLinkToLoginScreen);

        btnRegister.setOnClickListener(this);
        btnLinkToLoginScreen.setOnClickListener(this);

        textEmail = (EditText) findViewById(R.id.textEmail);
        textLogin = (EditText) findViewById(R.id.textLogin);
        textPassword = (EditText) findViewById(R.id.textPassword);
    }

    private void registerUser(){
        String login = textLogin.getText().toString();
        String email = textEmail.getText().toString();
        String password = textPassword.getText().toString();
        RequestParams params = new RequestParams();
        
        if(Utility.isNotNull(login) && Utility.isNotNull(email) && Utility.isNotNull(password)){
            if(Utility.validate(email)){
                params.put("username", login);
                params.put("email", email);
                params.put("password", password);
                
                invokeWS(params);
            }
            // When Email is invalid
            else{
                Toast.makeText(getApplicationContext(), "Please enter valid email", Toast.LENGTH_LONG).show();
            }
        }
        // When any of the Edit View control left blank
        else{
            Toast.makeText(getApplicationContext(), "Please fill the form, don't leave any field blank", Toast.LENGTH_LONG).show();
        }

    }

    private void invokeWS(RequestParams params) {
        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://88.156.94.126:8080/rest/register/doregister", params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {
                String response = bytes.toString();
                Toast.makeText(getApplicationContext(), response, Toast.LENGTH_LONG).show();
                try {
                    JSONObject obj = new JSONObject(response);
                    if(obj.getBoolean("status")){
                        setDefaultValues();
                        Toast.makeText(getApplicationContext(), "Zarejestrowano poprawnie!", Toast.LENGTH_LONG).show();
                    }
                    else{
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
                    Toast.makeText(getApplicationContext(), "Nierozpoznany błąd!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void setDefaultValues(){
        textLogin.setText("");
        textEmail.setText("");
        textPassword.setText("");
    }

    private void btnRegister_click() {
        registerUser();
    }

    private void btnLinkToLoginScreen_click(){
        Intent i = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnRegister:
                btnRegister_click();
                break;
            case R.id.btnLinkToLoginScreen:
                btnLinkToLoginScreen_click();
                break;
        }
    }
}
