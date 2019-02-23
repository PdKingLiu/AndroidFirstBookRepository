package com.example.databasetest;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private MyDatabaseHelper dpHeler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dpHeler = new MyDatabaseHelper(this, "BookStore.db", null, 2);
        Button createDatabase = findViewById(R.id.create_database);
        createDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dpHeler.getWritableDatabase();
            }
        });
        Button addData = (Button) findViewById(R.id.add_data);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dpHeler.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("name", "The Da Vinci Code");
                values.put("author", "Dan Brown");
                values.put("pages", "454");
                values.put("price", "16.96");
                db.insert("Book", null, values);
                values.clear();
                values.put("name", "The Lost Symbol");
                values.put("author", "Dan Brown");
                values.put("pages", "510");
                values.put("price", "19.95");
                db.insert("Book", null, values);

            }
        });
        Button updateData = (Button) findViewById(R.id.update_data);
        updateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dpHeler.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("price", 10.99);
                db.update("Book", values, "name = ?",
                        new String[]{"The Da Vinci Code"});
            }
        });
        Button deleteButton = findViewById(R.id.delete_data);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dpHeler.getWritableDatabase();
                db.delete("Book", "pages > ?", new String[]{"500"});
                Log.d("Del", "Del");
            }
        });
        Button queryButton = findViewById(R.id.query_data);
        queryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dpHeler.getWritableDatabase();
                Cursor cursor = db.query("Book", null, null,
                        null, null, null, null);
                if (cursor.moveToFirst()) {
                    do {
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        String author = cursor.getString(cursor.getColumnIndex("author"));
                        double price = cursor.getDouble(cursor.getColumnIndex("price"));
                        int pages = cursor.getInt(cursor.getColumnIndex("pages"));

                        Log.d("MainActivity", "book name is  " + name);
                        Log.d("MainActivity", "book author is  " + author);
                        Log.d("MainActivity", "book price is  " + price);
                        Log.d("MainActivity", "book pages is  " + pages);
                    } while (cursor.moveToNext());
                }
                cursor.close();
            }
        });
    }
}
