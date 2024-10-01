package com.example.guiaapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnParqueChico, btnJardim, btnZool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        buscarComponentes();

        btnParqueChico.setOnClickListener( v -> {
            Intent i = new Intent(this,ParqueChicoActivity.class);
            startActivity(i);
        });

        btnJardim.setOnClickListener( v -> {
            Intent i = new Intent(this,JardimActivity.class);
            startActivity(i);
        });

        btnZool.setOnClickListener( v -> {
            Intent i = new Intent(this,ZoologicoActivity.class);
            startActivity(i);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

    public void buscarComponentes(){
        btnParqueChico = (Button)findViewById(R.id.btnParqueChico);
        btnJardim = (Button)findViewById(R.id.btnJardim);
        btnZool = (Button)findViewById(R.id.btnZool);
    }

}