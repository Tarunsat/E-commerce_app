package com.example.testlist.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DataBaseHelperUser extends SQLiteOpenHelper {

    // creating a constant variables for our database.
    // below variable is for our database name.
    private static final String DB_NAME = "userdb";

    // below int is our database version
    private static final int DB_VERSION = 1;

    // below variable is for our table name.
    private static final String TABLE_NAME = "users";

    // below variable is for our id column.
    private static final String ID_COL = "id";

    // below variable is for our course name column
    private static final String NAME_COL = "name";

    // below variable id for our course duration column.
    private static final String MOBILE_COL = "mobile";

    // below variable for our course description column.
    private static final String PASSWORD_COL = "password";



    // creating a constructor for our database handler.
    public DataBaseHelperUser(Context context) {
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
                + NAME_COL + " TEXT,"
                + MOBILE_COL + " TEXT,"
                + PASSWORD_COL + " TEXT)";

        // at last we are calling a exec sql
        // method to execute above sql query
        db.execSQL(query);
    }

    // this method is use to add new course to our sqlite database.
    public void addNewCourse(String userName, String userMobile, String userPass) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(NAME_COL, userName);
        values.put(MOBILE_COL, userMobile);
        values.put(PASSWORD_COL, userPass);


        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_NAME, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }
    public ArrayList<modalClassUser> readData() {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorCourses = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        // on below line we are creating a new array list.
        ArrayList<modalClassUser> courseModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorCourses.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                courseModalArrayList.add(new modalClassUser(cursorCourses.getString(1),
                        cursorCourses.getString(2)));
            } while (cursorCourses.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorCourses.close();
        return courseModalArrayList;
    }
    public boolean Check(String a,String b) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE "
                + NAME_COL + " LIKE '%" + a + "%' AND " + PASSWORD_COL +
                " LIKE '%" + b + "%'", null);
        if (cursor.getCount() <= 0) {
            cursor.close();
            return false;
        }

        cursor.close();
        return true;

    }
    public void Update(String a, String b,String c)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(" UPDATE " + TABLE_NAME + " SET "+ MOBILE_COL +"=" + b + " SET "+ PASSWORD_COL +"=" + c + " WHERE "
                + NAME_COL + " LIKE '%" + a + "%';" , null);

        cursor.close();

    }



    public ArrayList<modalClassUser> Search(String a,String b)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM "+ TABLE_NAME + " WHERE "
                + NAME_COL + " LIKE '%" + a + "%' AND " + PASSWORD_COL +
                " LIKE '%" + b + "%'",null);


        ArrayList<modalClassUser> SearchArrayList = new ArrayList<>();

        if(cursor.moveToFirst())
        {
            do {
                // on below line we are adding the data from cursor to our array list.
                SearchArrayList.add(new modalClassUser(cursor.getString(1),
                        cursor.getString(2)));
            } while (cursor.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursor.close();
        return SearchArrayList;
    }

    public ArrayList<String> DisplayData(String a)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT " + NAME_COL+","+MOBILE_COL+" FROM "+ TABLE_NAME + " WHERE "
                + NAME_COL + " LIKE '%" + a + "%'" ,null);


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


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
