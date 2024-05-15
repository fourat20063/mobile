package com.example.seloger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RechercheAnnonce extends AppCompatActivity {


    Button btnId,btnInfo,btnRetour;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche_annonce);

        btnId=findViewById(R.id.rchIdA);
        btnInfo=findViewById(R.id.rchInfo);
        btnRetour=findViewById(R.id.retour);

        btnRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HomeAdmin.class);
                startActivity(intent);
            }
        });
        btnId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RechercheAnnonceID.class);
                startActivity(intent);
            }
        });

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), RechercheAnnonceINFO.class);
                startActivity(intent);
            }
        });

    }
}













