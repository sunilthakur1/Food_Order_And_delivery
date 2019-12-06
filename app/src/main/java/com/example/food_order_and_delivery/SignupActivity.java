package com.example.food_order_and_delivery;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.food_order_and_delivery.model.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class SignupActivity extends AppCompatActivity  {
    EditText name, dob, phone, email, img;
    RadioGroup radioGroup;
    RadioButton rb_male, rb_female, rb_other;
    Spinner sp_location;
    Button btn_submit,btn_view_user;
    String Name, DOB, Phn, Email, country, gender, Img;
    String[] location = {
            "Kathmandu", "Bhaktapur", "Patan"
    };
//    final Calendar myCalendar = Calendar.getInstance();
    List<User> userList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        sp_location = findViewById(R.id.location);

        ArrayAdapter adapter= new ArrayAdapter(this, R.layout.spinner_values, location);
        sp_location.setAdapter(adapter);




    }






}
