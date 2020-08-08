package com.example.animals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    String[] continentsName;
    int [] conPic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        continentsName = getResources().getStringArray(R.array.Continents);
        conPic = new int[]{
                R.drawable.ic_asia,
                R.drawable.ic_africa,
                R.drawable.ic_europe,
                R.drawable.ic_north_america,
                R.drawable.ic_south_america,
                R.drawable.ic_australia,
                R.drawable.ic_penguin,
                R.drawable.ic_newzealand

        };


        recyclerView = findViewById(R.id.recylcerId);


        MyAdapter myAdapter = new MyAdapter(this,continentsName,conPic);

        recyclerView.setAdapter(myAdapter);


    }
}