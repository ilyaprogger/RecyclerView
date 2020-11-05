package com.example.laba4;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.io.InputStreamReader;

import name.ank.lab4.BibDatabase;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MyAdapter myAdapter;
    BibDatabase database;
    private final int MAX = Integer.MAX_VALUE;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setHasFixedSize(true);
        try {
            setup();
        } catch (IOException e) {
            e.printStackTrace();
        }
        myAdapter = new MyAdapter(MAX, database);
        recyclerView.setAdapter(myAdapter);
    }

    public void setup() throws IOException {
        try (InputStreamReader reader = new InputStreamReader(getResources().openRawResource(R.raw.articles))) {
            database = new BibDatabase(reader);
        }
    }
}