package com.example.seloger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class ModifAnnonce extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modif_annonce);

        RadioGroup typeBEt =findViewById(R.id.radioGroupTypeBien);
        RadioGroup typeAEt = findViewById(R.id.radioGroupTypeAnnonce);
        RadioGroup etatEt = findViewById(R.id.radioGroupEtatAnnonce);

        Spinner gvrEt= findViewById(R.id.spinnerGouvernorat);

        EditText  villeEt= findViewById(R.id.editTextVille);
        EditText  adresseEt= findViewById(R.id.editTextAdresse);
        EditText  superficieEt= findViewById(R.id.editTextSuperficie);
        EditText  prixEt= findViewById(R.id.editTextPrix);
        EditText  dateEt= findViewById(R.id.editTextDate);
        EditText  descriptionEt= findViewById(R.id.editTextDescription);
        EditText  nbcEt= findViewById(R.id.editTextNbChambres);
        Intent intent = getIntent();
        Annonce a =(Annonce) intent.getSerializableExtra("annModif");

        villeEt.setText(a.getVille());
        adresseEt.setText(a.getAdresse());
        superficieEt.setText(a.getSuperficie());

    }
}