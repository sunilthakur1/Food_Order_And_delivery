package com.example.food_order_and_delivery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    Button login;
    EditText email, password;
    CheckBox saveLoginCheckBox;
    TextView forgotpass, createacc;
    TextInputLayout passwordinp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.login);
        email = findViewById(R.id.username);
        password = findViewById(R.id.password);
        saveLoginCheckBox = findViewById(R.id.rememberme);
        forgotpass = findViewById(R.id.forgotpassword);
        createacc = findViewById(R.id.createaccount);
        passwordinp = findViewById(R.id.login_passwordinp);

        createacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validate()){
                    if (email.getText().toString().equals("admin")&&
                            password.getText().toString().equals("admin")){

                        startActivity(new Intent(getApplicationContext(), NavigationDrawer.class));
                        finish();
                    }else {
                        notauthenticated();
                    }
                }

            }
        });
    }

    private void notauthenticated(){
        email.setText(null);
        password.setText(null);
        email.requestFocus();
        email.setError("Incorrect email or password!!");
    }


    private boolean validate(){
        String emailtxt = email.getText().toString();
        String passwordtxt = password.getText().toString();
        if(TextUtils.isEmpty(emailtxt)){
            email.setError("Email cannot be empty!!");
            email.requestFocus();
            return false;
        }
        if(TextUtils.isEmpty(passwordtxt)){
            passwordinp.setError("Password must not be empty!!");
            password.requestFocus();
            return false;
        }

        return true;
    }


}
