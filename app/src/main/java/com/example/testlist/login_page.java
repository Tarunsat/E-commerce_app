package com.example.testlist;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testlist.data.DataBaseHelperUser;
import com.example.testlist.data.modalClassUser;

import java.util.ArrayList;

public class login_page extends AppCompatActivity {
    private ArrayList<modalClassUser> userModalArrayList;
    private DataBaseHelperUser dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        userModalArrayList = new ArrayList<>();
        dbHandler = new DataBaseHelperUser(login_page.this);

        // getting our course array
        // list from db handler class.
        userModalArrayList = dbHandler.readData();
/*
        modalClassUser modal = userModalArrayList.get(position);
        String a= modal.getUserName();
        String b=modal.getUserPass();
        */

    }

    public void Signin()
    {

    }
}