package com.example.guiaapplication;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ParqueChicoActivity extends AppCompatActivity {
    Button btnVoltar, btnMapa, btnSite, btnTelefone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_parque_chico);
        buscarComponentes();

        btnVoltar.setOnClickListener( v -> {
            Intent i = new Intent(this,MainActivity.class);
            startActivity(i);
        });

        btnMapa.setOnClickListener( v -> {
            Uri uri = Uri.parse("geo:0,0?q=Avenida+Tres+de+Marco+1025");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(mapIntent);
        });

        btnSite.setOnClickListener( v -> {
            Uri webpage = Uri.parse("https://central156.sorocaba.sp.gov.br/Carta-Servicos/Home/Servico/a20c7586-6413-e511-87fb-005056bf74cb");
            Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
            startActivity(intent);
        });

        btnTelefone.setOnClickListener(v -> {
            Uri uri = Uri.parse("tel:1532281256");
            Intent intent = new Intent(Intent.ACTION_CALL,uri);
            int permissionCheck =
                    ContextCompat.checkSelfPermission(
                            this, android.Manifest.permission.CALL_PHONE);
            if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.
                        requestPermissions(this,
                                new String[]{
                                        android.Manifest.permission.CALL_PHONE},1);
            } else {
                startActivity(intent);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void buscarComponentes(){
        btnVoltar = (Button)findViewById(R.id.btnVoltar);
        btnMapa = (Button)findViewById(R.id.btnMapa);
        btnSite = (Button)findViewById(R.id.btnSite);
        btnTelefone = (Button)findViewById(R.id.btnTelefone);
    }
}