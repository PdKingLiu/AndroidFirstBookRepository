package com.example.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruit();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        GridLayoutManager linearLayoutManager = new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(linearLayoutManager);
        FruitAdapter adapter = new FruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);

    }

    private void initFruit() {
        for (int i = 0; i < 3; i++) {
            Fruit apple = new Fruit(getRandomLengthName("Apple"), R.drawable.apple_pic);
            fruitList.add(apple);
            Fruit Banana = new Fruit(getRandomLengthName("Banana"), R.drawable.apple_pic);
            fruitList.add(Banana);
            Fruit Orange = new Fruit(getRandomLengthName("Orange"), R.drawable.apple_pic);
            fruitList.add(Orange);
            Fruit Watermelon = new Fruit(getRandomLengthName("Watermelon"), R.drawable.apple_pic);
            fruitList.add(Watermelon);
            Fruit Pear = new Fruit(getRandomLengthName("Pear"), R.drawable.apple_pic);
            fruitList.add(Pear);
            Fruit Grape = new Fruit(getRandomLengthName("Grape"), R.drawable.apple_pic);
            fruitList.add(Grape);
            Fruit Pineapple = new Fruit(getRandomLengthName("Pineapple"), R.drawable.apple_pic);
            fruitList.add(Pineapple);
            Fruit Strawberry = new Fruit(getRandomLengthName("Strawberry"), R.drawable.apple_pic);
            fruitList.add(Strawberry);
            Fruit Cherry = new Fruit(getRandomLengthName("Cherry"), R.drawable.apple_pic);
            fruitList.add(Cherry);
            Fruit Mango = new Fruit(getRandomLengthName("Mango"), R.drawable.apple_pic);
            fruitList.add(Mango);
        }
    }

    private String getRandomLengthName(String name) {
        Random random = new Random();
        int length = random.nextInt(20) + 1;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append(name);
        }
        return builder.toString();
    }
}
