package com.example.seloger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.seloger.Adapters.AnnonceAdapter;

import java.util.ArrayList;

public class RechercheAnnonceINFO extends AppCompatActivity {

    Button retour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche_annonce_info);

        DbConnect db=new DbConnect(this);
        ArrayList<Annonce> annonces=db.afficheAnnonces();
        RecyclerView rv = findViewById(R.id.rv);
        AnnonceAdapter adapter = new AnnonceAdapter(annonces);
        rv.setAdapter(adapter);
        rv.hasFixedSize();
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);

        retour=findViewById(R.id.retour);
        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RechercheAnnonce.class);
                startActivity(intent);
            }
        });
    }

}