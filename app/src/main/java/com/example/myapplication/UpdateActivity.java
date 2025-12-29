package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateActivity extends AppCompatActivity {

    EditText edPoste, edDesc;
    Button btnUpdate, btnDelete;
    DAO db;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        id = getIntent().getIntExtra("id", -1);
        String poste = getIntent().getStringExtra("poste");
        String desc = getIntent().getStringExtra("desc");

        edPoste = findViewById(R.id.edPoste);
        edDesc = findViewById(R.id.edDesc);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);

        db = new DAO(this);

        edPoste.setText(poste);
        edDesc.setText(desc);

        btnUpdate.setOnClickListener(v -> {
            db.updateOffre(new Offre(id, edPoste.getText().toString(), edDesc.getText().toString()));
            finish();
        });

        btnDelete.setOnClickListener(v -> {
            db.deleteOffre(id);
            finish();
        });
    }
}
