package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton addButton;
    DAO db;
    ArrayList<Offre> list;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DAO(this);

        recyclerView = findViewById(R.id.recyclerOffres);
        addButton = findViewById(R.id.add_button);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadData();

        addButton.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, AddActivity.class);
            startActivity(i);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadData();
    }

    private void loadData() {
        list = db.getAllOffres();
        adapter = new CustomAdapter(MainActivity.this, list);
        recyclerView.setAdapter(adapter);
    }
}
