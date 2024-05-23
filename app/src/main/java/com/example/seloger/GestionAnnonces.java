package com.example.seloger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GestionAnnonces extends AppCompatActivity {

    Button btnA , btnS,btnR,btnM,btnRetour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion_annonces);

        btnA=findViewById(R.id.btnAjoutAnnonce);

        btnR=findViewById(R.id.btnRechercheAnnonce);
        btnS=findViewById(R.id.btnSuppAnnonce);
        btnRetour=findViewById(R.id.btnRetour);

        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AjoutAnnonce.class);
                startActivity(intent);
            }
        });

        btnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SuppAnnonce.class);
                startActivity(intent);
            }
        });

        btnR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RechercheAnnonce.class);
                startActivity(intent);
            }
        });

        btnRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HomeAdmin.class);
                startActivity(intent);
            }
        });

    }
}