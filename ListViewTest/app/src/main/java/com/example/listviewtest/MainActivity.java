package com.example.listviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Fruit> fruitList= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruit();
        FruitAdapter adapter = new FruitAdapter(
                MainActivity.this, R.layout.fruit_item, fruitList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Fruit fruit = fruitList.get(i);
                Toast.makeText(MainActivity.this,fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initFruit() {
        for (int i = 0; i < 3; i++) {
            Fruit apple = new Fruit("Apple",R.drawable.apple_pic);
            fruitList.add(apple);
            Fruit Banana = new Fruit("Banana",R.drawable.apple_pic);
            fruitList.add(Banana);
            Fruit Orange = new Fruit("Orange",R.drawable.apple_pic);
            fruitList.add(Orange);
            Fruit Watermelon = new Fruit("Watermelon",R.drawable.apple_pic);
            fruitList.add(Watermelon);
            Fruit Pear = new Fruit("Pear",R.drawable.apple_pic);
            fruitList.add(Pear);
            Fruit Grape = new Fruit("Grape",R.drawable.apple_pic);
            fruitList.add(Grape);
            Fruit Pineapple = new Fruit("Pineapple",R.drawable.apple_pic);
            fruitList.add(Pineapple);
            Fruit Strawberry = new Fruit("Strawberry",R.drawable.apple_pic);
            fruitList.add(Strawberry);
            Fruit Cherry = new Fruit("Cherry",R.drawable.apple_pic);
            fruitList.add(Cherry);
            Fruit Mango = new Fruit("Mango",R.drawable.apple_pic);
            fruitList.add(Mango);
        }
    }
}
