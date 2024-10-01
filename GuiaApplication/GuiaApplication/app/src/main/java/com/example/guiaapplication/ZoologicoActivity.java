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

public class ZoologicoActivity extends AppCompatActivity {
    Button btnZVoltar, btnZMapa, btnZSite, btnZTelefone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_zoologico);
        buscarComponentes();

        btnZVoltar.setOnClickListener( v -> {
            Intent i = new Intent(this,MainActivity.class);
            startActivity(i);
        });

        btnZMapa.setOnClickListener( v -> {
            Uri uri = Uri.parse("geo:0,0?q=Rua+Teodoro+Kaisel+883");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(mapIntent);
        });

        btnZSite.setOnClickListener( v -> {
            Uri webpage = Uri.parse("https://central156.sorocaba.sp.gov.br/Carta-Servicos/Home/Servico/acac498c-5a13-e511-87fb-005056bf74cb");
            Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
            startActivity(intent);
        });

        btnZTelefone.setOnClickListener(v -> {
            Uri uri = Uri.parse("tel:1532275454");
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
        btnZVoltar = (Button)findViewById(R.id.btnZVoltar);
        btnZMapa = (Button)findViewById(R.id.btnZMapa);
        btnZSite = (Button)findViewById(R.id.btnZSite);
        btnZTelefone = (Button)findViewById(R.id.btnZTelefone);
    }
}