package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {

    EditText edPoste, edDesc;
    Button btnAdd;
    DAO db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        edPoste = findViewById(R.id.edPoste);
        edDesc = findViewById(R.id.edDesc);
        btnAdd = findViewById(R.id.btnAdd);

        db = new DAO(this);

        btnAdd.setOnClickListener(v -> {
            db.addOffre(new Offre(
                    edPoste.getText().toString(),
                    edDesc.getText().toString()
            ));
            finish();
        });
    }
}