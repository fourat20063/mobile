package com.example.seloger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GestionClients extends AppCompatActivity {

    Button ajoutClient , rechercheClient , consultSolv, retour;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion_clients);

        ajoutClient = findViewById(R.id.btnAjoutClient);
        rechercheClient = findViewById(R.id.btnRechercheClient);
        consultSolv= findViewById(R.id.btnConsultationSolvabilite);
        retour= findViewById(R.id.btnRetour);

        ajoutClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AjoutClient.class);
                startActivity(intent);

            }
        });

        rechercheClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RechercheClient.class);
                startActivity(intent);

            }
        });

        consultSolv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ConsultSolvabilite.class);
                startActivity(intent);

            }
        });

        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HomeAdmin.class);
                startActivity(intent);

            }
        });
    }
}