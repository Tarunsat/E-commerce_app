package com.example.testlist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testlist.data.DataBaseCart;
import com.example.testlist.data.DataBaseHelperInventory;
import com.example.testlist.data.modalClass;
import com.example.testlist.data.modalClassCart;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<modalClass> courseModalArrayList;
    private ArrayList<modalClassCart> modalCartArrayList;
    private DataBaseHelperInventory dbHandler;
    private DataBaseCart dbHandler1;

    private RVAAdapter courseRVAdapter;
    private RecyclerView coursesRV;
    Global sharedData = Global.getInstance();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String n= sharedData.getValue();
        if (n.equals("0"))
        {
            Intent i = new Intent(this, login_page.class);
            startActivity(i);
        }


        courseModalArrayList = new ArrayList<>();
        modalCartArrayList= new ArrayList<>();
        dbHandler = new DataBaseHelperInventory(MainActivity.this);
        dbHandler1= new DataBaseCart(MainActivity.this);

        // getting our course array
        // list from db handler class.
        courseModalArrayList = dbHandler.readCourses();
        modalCartArrayList=dbHandler1.readQuan();

        // on below line passing our array lost to our adapter class.
        courseRVAdapter = new RVAAdapter(courseModalArrayList,modalCartArrayList, MainActivity.this);
        coursesRV = findViewById(R.id.idRVCourses);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false);
        coursesRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        coursesRV.setAdapter(courseRVAdapter);


    }
    public void gotoAccount(View view){
        Intent i = new Intent(this, AccountActivity.class);
        startActivity(i);
    }
    public void gotoCart(View view){
        Intent i = new Intent(this, TotalCostActivity.class);
        startActivity(i);
    }
    public void Additems(View view)
    {
        Intent i = new Intent(this, addDatatoInventory.class);
        startActivity(i);
    }

}