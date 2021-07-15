package com.example.testlist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testlist.data.DataBaseCart;
import com.example.testlist.data.DataBaseHelperInventory;
import com.example.testlist.data.modalClass;
import com.example.testlist.data.modalClassCart;
import com.example.testlist.data.modalclasstotal;

import java.util.ArrayList;

public class TotalCostActivity extends menuitems {
    Global sharedData = Global.getInstance();
    private ArrayList<modalClassCart> modalCartArrayList;
    private ArrayList<modalClass> courseModalArrayList;
    private ArrayList<String> TotalArrayList;
    private DataBaseCart dbHandler1;
    private DataBaseHelperInventory dbHandler;
    private RVCartAdapter courseRVAdapter;
    private RecyclerView coursesRV;
    private TextView TotalCost;
    private ArrayList<modalclasstotal> totalarray;
    private TextView totalview;
    private int sum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        display();
        Pay();

    }
    public void gotoMain(View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }


    public void display()
    {


        setContentView(R.layout.activity_total_cost);
        modalCartArrayList= new ArrayList<>();
        courseModalArrayList = new ArrayList<>();
        dbHandler = new DataBaseHelperInventory(TotalCostActivity.this);
        dbHandler1= new DataBaseCart(TotalCostActivity.this);
        modalCartArrayList=dbHandler1.readQuan();
        courseRVAdapter = new RVCartAdapter(courseModalArrayList,modalCartArrayList, TotalCostActivity.this);
        coursesRV = findViewById(R.id.idRVCartCourses);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(TotalCostActivity.this, RecyclerView.VERTICAL, false);
        coursesRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        coursesRV.setAdapter(courseRVAdapter);





    }
    public void Payer(View view)
    {
        dbHandler1.CartDelete();
        Toast.makeText(getApplicationContext(), "Thank you for buying!!", Toast.LENGTH_LONG).show();


    }
    public void Pay()
    {
        int sum=0;
        totalarray=dbHandler1.join();
        System.out.println(totalarray);
        int a= totalarray.size();

        for (int i=0;i<a;i++)
        {

            modalclasstotal modal = totalarray.get(i);
            int s=Integer.parseInt(modal.getQuantity());
            int d=Integer.parseInt(modal.getPrice());
            sum=sum+(s*d);
        }
            totalview=findViewById(R.id.tot);
            totalview.setText(Integer.toString(sum));


    }

}