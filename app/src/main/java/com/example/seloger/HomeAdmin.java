package com.example.seloger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeAdmin extends AppCompatActivity {

    Button gestionClient , gestionAnnone, deconnexion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_admin2);

        gestionAnnone= findViewById(R.id.gestionAnnonce);
        gestionClient= findViewById(R.id.gestionClient);
        deconnexion=findViewById(R.id.deconnexion);

        gestionClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GestionClients.class);
                startActivity(intent);
            }
        });

        gestionAnnone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), GestionAnnonces.class);
                startActivity(intent);
            }
        });

    }
}