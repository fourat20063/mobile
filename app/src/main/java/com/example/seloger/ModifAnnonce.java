package com.example.seloger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class ModifAnnonce extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modif_annonce);


        EditText  typeBEt= findViewById(R.id.editTextTypeB);
        EditText  typeAEt= findViewById(R.id.editTextTypeA);
        EditText  etatEt= findViewById(R.id.editTextEtat);

        Spinner gvrEt= findViewById(R.id.spinnerGouvernorat);

        EditText  villeEt= findViewById(R.id.editTextVille);
        EditText  adresseEt= findViewById(R.id.editTextAdresse);
        EditText  superficieEt= findViewById(R.id.editTextSuperficie);
        EditText  prixEt= findViewById(R.id.editTextPrix);
        EditText  dateEt= findViewById(R.id.editTextDate);
        EditText  descriptionEt= findViewById(R.id.editTextDescription);
        EditText  nbcEt= findViewById(R.id.editTextNbChambres);
        Intent intent = getIntent();
        Annonce a =(Annonce) intent.getSerializableExtra("annonce");


        typeBEt.setText(a.getTypeB());
        typeAEt.setText(a.getTypeA());
        etatEt.setText(a.getEtat());
        villeEt.setText(a.getVille());
        adresseEt.setText(a.getAdresse());
        superficieEt.setText(""+a.getSuperficie());
        prixEt.setText(""+a.getPrix());
        dateEt.setText(a.getDate());
        descriptionEt.setText(a.getDescription());
        nbcEt.setText(""+a.getNbc());

        DbConnect db= new DbConnect(this);

        String gouvernorat = gvrEt.getSelectedItem().toString().trim();
        Button updateBtn=findViewById(R.id.btnModif);
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ville =villeEt.getText().toString().trim();
                String adresse=adresseEt.getText().toString().trim();
                Integer sprf= Integer.parseInt(superficieEt.getText().toString().trim());
                Integer prix= Integer.parseInt(prixEt.getText().toString().trim());
                String date=dateEt.getText().toString().trim();
                String desc=descriptionEt.getText().toString().trim();
                Integer nbc= Integer.parseInt(nbcEt.getText().toString().trim());
                String typeB=typeBEt.getText().toString().trim();
                String typeA=typeAEt.getText().toString().trim();
                String etat=etatEt.getText().toString().trim();

                Annonce annonce=new Annonce(a.getId(),typeB,typeA,gouvernorat,ville,adresse,sprf,prix,date,desc,nbc,etat);
                annonce.setImg(a.getImg());
                int rslt = db.updateAnnonce(annonce);
                if (rslt != -1){
                    Toast.makeText(ModifAnnonce.this, "Mise a Jour effectuee !", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), RechercheAnnonce.class);
                    startActivity(intent);
                }
            }
        });

        Button retour=findViewById(R.id.btnRetour);
        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RechercheAnnonce.class);
                startActivity(intent);
            }
        });





    }

}