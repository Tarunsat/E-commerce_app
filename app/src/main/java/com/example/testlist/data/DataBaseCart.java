package com.example.testlist.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.testlist.Global;

import java.util.ArrayList;



public class DataBaseCart extends SQLiteOpenHelper {
    Global sharedData = Global.getInstance();
    // creating a constant variables for our database.
    // below variable is for our database name.
    private static final String DB_NAME = "Cartdb";

    // below int is our database version
    private static final int DB_VERSION = 1;

    // below variable is for our table name.
    private static final String TABLE_NAME = "cart";

    // below variable is for our id column.
    private static final String ID_COL = "id";

    // below variable is for our course name column
    private static final String USER_COL = "user";

    // below variable id for our course duration column.
    private static final String PRODUCT_COL = "product";

    // below variable for our course description column.
    private static final String QUAN_COL = "quantity";





    // creating a constructor for our database handler.
    public DataBaseCart(Context context)

    {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // below method is for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {
        // on below line we are creating
        // an sqlite query and we are
        // setting our column names
        // along with their data types.
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + USER_COL + " TEXT,"
                + PRODUCT_COL + " TEXT, "
                + QUAN_COL + " TEXT)"
                ;

        // at last we are calling a exec sql
        // method to execute above sql query
        db.execSQL(query);

    }

    // this method is use to add new course to our sqlite database.
    public void addNewItem(String itemName,String itemStock, String itemPrice) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(USER_COL, itemName);
        values.put(PRODUCT_COL, itemStock);
        values.put(QUAN_COL, itemPrice);



        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_NAME, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }
    public void Delete(String d)
    {
        String n= sharedData.getValue();

        SQLiteDatabase db = this.getWritableDatabase();

        db.delete("cart","user=? and product=?",new String[]{n,d});
    }
    public void UpdateQuantity(String itemPrice,String d)
    {
        String n= sharedData.getValue();
        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.

        // on below line we are passing all values
        // along with its key and value pair.
        ContentValues newValues = new ContentValues();
        newValues.put(QUAN_COL, itemPrice);

        db.update(TABLE_NAME, newValues, "product LIKE'"+ d +"'", null);

       // Cursor cursor = db.rawQuery(" UPDATE " + TABLE_NAME + " SET " + QUAN_COL + " = '"+itemPrice+"' WHERE "
         //       + USER_COL + " LIKE '%"+n+"%' AND " + PRODUCT_COL + " LIKE '%"+d+"%';" , null);

        // after adding all values we are passing
        // content values to our table.

        // at last we are closing our
        // database after adding database.
       // cursor.close();
    }

    public String QuantityDisplay(String a,String b)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT " + QUAN_COL +" FROM "+ TABLE_NAME + " WHERE "
                + USER_COL + " LIKE '%" + a + "%' AND " + PRODUCT_COL + " LIKE '%"+ b +"%'"  ,null);


        String Display = "0";

        if(cursor.moveToFirst())
        {
            do {
                // on below line we are adding the data from cursor to our array list.
               Display= cursor.getString(0);
               
            }
            while (cursor.moveToNext());
            // moving our cursor to next.
        }
       
        // at last closing our cursor
        // and returning our array list.
        cursor.close();
        return Display;
    }
    public ArrayList<String> total(String a)
    {
        String n= sharedData.getValue();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT " + QUAN_COL +","+PRODUCT_COL+" FROM "+ TABLE_NAME + " WHERE "
                + USER_COL + " LIKE '%" + n + "%'" ,null);


        ArrayList<String> SearchArrayList = new ArrayList<>();

        if(cursor.moveToFirst())
        {
            do {
                // on below line we are adding the data from cursor to our array list.
                SearchArrayList.add(cursor.getString(0));
                SearchArrayList.add(cursor.getString(1));
            }
            while (cursor.moveToNext());
            // moving our cursor to next.
        }
        System.out.println(SearchArrayList);
        // at last closing our cursor
        // and returning our array list.
        cursor.close();
        return SearchArrayList;
    }

    public ArrayList<modalClassCart> readQuan() {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorCourses = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        // on below line we are creating a new array list.
        ArrayList<modalClassCart> courseModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorCourses.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                courseModalArrayList.add(new modalClassCart(cursorCourses.getString(1),
                        cursorCourses.getString(2),
                        cursorCourses.getString(3)));
            } while (cursorCourses.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorCourses.close();
        return courseModalArrayList;
    }
    public ArrayList<modalclasstotal> join() {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorCourses = db.rawQuery("SELECT cart.quantity as quantity_alt,inventory.price as price_alt FROM cart  INNER JOIN inventory ON inventory.name = cart.product;", null);

        // on below line we are creating a new array list.
        ArrayList<modalclasstotal> courseModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorCourses.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                courseModalArrayList.add(new modalclasstotal(cursorCourses.getString(cursorCourses.getColumnIndex("price_alt")),
                        cursorCourses.getString(cursorCourses.getColumnIndex("quantity_alt"))
                        ));


            } while (cursorCourses.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorCourses.close();
        return courseModalArrayList;
    }




    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}