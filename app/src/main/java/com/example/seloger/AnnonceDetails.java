package com.example.seloger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AnnonceDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_annonce_details);

        Intent intent=getIntent();
        Annonce a=(Annonce) intent.getSerializableExtra("ann");

        TextView idTv=findViewById(R.id.id_text_view);
        TextView typeBTv=findViewById(R.id.typeB_text_view);
        TextView typeATv=findViewById(R.id.typeA_text_view);
        TextView grvTv=findViewById(R.id.gouvernerat_text_view);
        TextView villeTv=findViewById(R.id.ville_text_view);
        TextView adrTv=findViewById(R.id.adresse_text_view);
        TextView srfTv=findViewById(R.id.superficie_text_view);
        TextView prixTv=findViewById(R.id.prix_text_view);
        TextView nbcTv=findViewById(R.id.nbc_text_view);
        TextView etatTv=findViewById(R.id.etat_text_view);
        TextView descTv=findViewById(R.id.description_text_view);
        TextView dateTv=findViewById(R.id.date_text_view);

        idTv.setText("ID :" + a.getId());
        typeBTv.setText("Type du Bien :"+ a.getTypeB());
        typeATv.setText("Type de l'annonce :" + a.getTypeA());
        grvTv.setText("gouvernerat :"+a.getGouvernerat());
        villeTv.setText("ville :" + a.getVille());
        adrTv.setText("adresse :" + a.getAdresse());
        srfTv.setText("Superficie :"+ a.getSuperficie());
        prixTv.setText("Prix"+ a.getPrix());
        nbcTv.setText("Nbc :" + a.getNbc());
        etatTv.setText("Etat :"+ a.getEtat());
        descTv.setText("Description :"+a.getDescription());
        dateTv.setText("Date :" + a.getDate());

        Button modifBtn =findViewById(R.id.modif);
        modifBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ModifAnnonce.class);
                intent.putExtra("annModif",a);
                startActivity(intent);
            }
        });



    }
}