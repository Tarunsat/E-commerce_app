package com.example.testlist;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testlist.data.DataBaseHelperInventory;

public class addDatatoInventory extends AppCompatActivity {

    // creating variables for our edittext, button and dbhandler
    private EditText NameEdt, PriceEdt, StockEdt, ImageEdt;
    private Button addCourseBtn;
    private DataBaseHelperInventory dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_datato_inventory);

        // initializing all our variables.
        NameEdt = findViewById(R.id.idEdtCourseName);
        PriceEdt = findViewById(R.id.idEdtCourseTracks);
        StockEdt = findViewById(R.id.idEdtCourseDuration);
        ImageEdt = findViewById(R.id.idEdtCourseDescription);
        addCourseBtn = findViewById(R.id.idBtnAddCourse);

        // creating a new dbhandler class
        // and passing our context to it.
        dbHandler = new DataBaseHelperInventory(addDatatoInventory.this);
/*
        // below line is to add on click listener for our add course button.
        addCourseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // below line is to get data from all edit text fields.
                String courseName = NameEdt.getText().toString();
                String courseTracks = PriceEdt.getText().toString();
                String courseDuration = StockEdt.getText().toString();
                String courseDescription = ImageEdt.getText().toString();

                // validating if the text fields are empty or not.
                if (courseName.isEmpty() && courseTracks.isEmpty() && courseDuration.isEmpty() && courseDescription.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.
                dbHandler.addNewItem(courseName, courseDuration, courseDescription, courseTracks);

                // after adding the data we are displaying a toast message.
                Toast.makeText(getApplicationContext(), "Item has been added.", Toast.LENGTH_SHORT).show();
                NameEdt.setText("");
                PriceEdt.setText("");
                StockEdt.setText("");
                ImageEdt.setText("");
                */


    }
    public void Additemstodba(View view)
    {
        // below line is to get data from all edit text fields.
        String courseName = NameEdt.getText().toString();
        String courseTracks = PriceEdt.getText().toString();
        String courseDuration = StockEdt.getText().toString();
        String courseDescription = ImageEdt.getText().toString();

        // validating if the text fields are empty or not.
        if (courseName.isEmpty() && courseTracks.isEmpty() && courseDuration.isEmpty() && courseDescription.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please enter all the data..", Toast.LENGTH_SHORT).show();
            return;
        }

        // on below line we are calling a method to add new
        // course to sqlite data and pass all our values to it.
        dbHandler.addNewItem(courseName, courseDuration, courseDescription, courseTracks);

        // after adding the data we are displaying a toast message.
        Toast.makeText(getApplicationContext(), "Item has been added.", Toast.LENGTH_SHORT).show();
        NameEdt.setText("");
        PriceEdt.setText("");
        StockEdt.setText("");
        ImageEdt.setText("");
    }
}