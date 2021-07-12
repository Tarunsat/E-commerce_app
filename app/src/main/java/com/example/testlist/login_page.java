package com.example.testlist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testlist.data.DataBaseHelperUser;

public class login_page extends AppCompatActivity {

    private DataBaseHelperUser dbHandler;
    private EditText NameEdt, PriceEdt;
    AccountActivity Displayer= new AccountActivity();
    Global sharedData = Global.getInstance();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        dbHandler = new DataBaseHelperUser(login_page.this);

        NameEdt = findViewById(R.id.Name);
        PriceEdt = findViewById(R.id.Password);

        // getting our course array
        // list from db handler class.



    }

    public void Signin(View view)
    {
        String courseName = NameEdt.getText().toString();
        String courseTracks = PriceEdt.getText().toString();
        if (dbHandler.Check(courseName,courseTracks)==false)
        {
            Toast.makeText(getApplicationContext(), "Either Username or Password is wrong", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Welcome", Toast.LENGTH_SHORT).show();
            sharedData.setValue(courseName);

            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);


        }
    }
    public void Signup(View view)
    {
        Intent i = new Intent(this, customer.class);
        startActivity(i);
    }

}