package com.example.testlist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.testlist.data.DataBaseHelperUser;

import java.util.ArrayList;

public class AccountActivity extends menuitems {
    private DataBaseHelperUser dbHandler;
    private TextView Name, Mobile;
    private ArrayList<String> courseModalArrayList;
    Global sharedData = Global.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        Display();
        /*
        dbHandler = new DataBaseHelperUser(AccountActivity.this);
        Name = findViewById(R.id.usenam);
        Mobile = findViewById(R.id.mobil1);

        courseModalArrayList = new ArrayList<>();


        // getting our course array
        // list from db handler class.
        courseModalArrayList = dbHandler.DisplayData(Global.userNameTotal);

        Name.setText(courseModalArrayList.get(1));
        Mobile.setText(courseModalArrayList.get(2));

         */


    }
    public void gotoMain(View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);

    }
    public void gotoCustomer(View view) {
        Intent i = new Intent(this, UpdateUser.class);
        startActivity(i);

    }
    public void Signinpage(View view) {
        Intent i = new Intent(this, login_page.class);
        startActivity(i);
    }
    public void Signuppage(View view) {
        Intent i = new Intent(this, customer.class);
        startActivity(i);
    }

    public void Display()
    {
        dbHandler = new DataBaseHelperUser(AccountActivity.this);
        Name = findViewById(R.id.usenam);
        Mobile = findViewById(R.id.mobil1);

        courseModalArrayList = new ArrayList<>();


        // getting our course array
        // list from db handler class.
        String s = sharedData.getValue();
        courseModalArrayList = dbHandler.DisplayData(s);

        Name.setText(courseModalArrayList.get(0));
        Mobile.setText(courseModalArrayList.get(1));
    }



}



