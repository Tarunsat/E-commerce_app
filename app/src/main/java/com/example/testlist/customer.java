package com.example.testlist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testlist.data.DataBaseHelperUser;

public class customer extends AppCompatActivity {

    // creating variables for our edittext, button and dbhandler

    private EditText editTextName, editTextPhoneNumber,editPassword;
    private Button gobutton;
    private DataBaseHelperUser DataBaseHelperUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);

        // initializing all our variables.
        editTextName = findViewById(R.id.Name);
        editTextPhoneNumber = findViewById(R.id.MobileNo);
        editPassword=findViewById(R.id.Password);
        gobutton = findViewById(R.id.goButton);

        // creating a new dbhandler class
        // and passing our context to it.
        DataBaseHelperUser = new DataBaseHelperUser(customer.this);;

        // below line is to add on click listener for our add course button.

    }
    public void gotoPrevious(View view) {
        Intent i = new Intent(this, AccountActivity.class);
        startActivity(i);
    }
    public void addData (View view) {
        // below line is to get data from all edit text fields.
        String userName = editTextName.getText().toString();
        String userMobile = editTextPhoneNumber.getText().toString();
        String userPass = editPassword.getText().toString();

        // validating if the text fields are empty or not.
        if (userName.isEmpty() && userMobile.isEmpty() && userPass.isEmpty() ) {
            Toast.makeText(getApplicationContext(), "Please enter all the data..", Toast.LENGTH_SHORT).show();
            return;
        }

        // on below line we are calling a method to add new
        // course to sqlite data and pass all our values to it.
        DataBaseHelperUser.addNewCourse(userName, userMobile, userPass);
        // after adding the data we are displaying a toast message.
        Toast.makeText(getApplicationContext(), "Item has been added.", Toast.LENGTH_SHORT).show();
        editTextName.setText("");
        editTextPhoneNumber.setText("");
        editPassword.setText("");

    }

}