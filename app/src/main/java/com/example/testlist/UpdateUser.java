package com.example.testlist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testlist.data.DataBaseHelperUser;





public class UpdateUser extends AppCompatActivity {

    private DataBaseHelperUser dbHandler;
    private EditText NameEdt, Password,Mobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user);

        dbHandler = new DataBaseHelperUser(UpdateUser.this);
        NameEdt = findViewById(R.id.Name);
        Mobile=  findViewById(R.id.MobileNo);
        Password = findViewById(R.id.Password);

        // getting our course array
        // list from db handler class.



    }

    public void UpdateData(View view)
    {
        String courseName = NameEdt.getText().toString();
        String courseMobile= Mobile.getText().toString();
        String courseTracks = Password.getText().toString();
        dbHandler.Update(courseName,courseMobile,courseTracks);

        Toast.makeText(getApplicationContext(), "Records Updated", Toast.LENGTH_SHORT).show();

    }
    public void goBack(View view)
    {
        Intent i = new Intent(this, login_page.class);
        startActivity(i);
    }
    public void Signup(View view)
    {
        Intent i = new Intent(this, customer.class);
        startActivity(i);
    }
}