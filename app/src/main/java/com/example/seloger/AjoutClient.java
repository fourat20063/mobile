package com.example.seloger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class AjoutClient extends AppCompatActivity {


    EditText emailC,nomC,prenomC,telC,adresseC,villeC,cpC;

    RadioButton mr,mme,melle;
    DbConnect dbConnect;
    Button retour,valider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_client);
        dbConnect = new DbConnect(this);

        mr=findViewById(R.id.radioMr);
        mme=findViewById(R.id.radioMme);
        melle = findViewById(R.id.radioMlle);

        emailC=findViewById(R.id.editTextEmail);
        nomC=findViewById(R.id.editTextNom);
        prenomC=findViewById(R.id.editTextPrenom);
        telC=findViewById(R.id.editTextTelephone);
        adresseC=findViewById(R.id.editTextAdresse);
        villeC=findViewById(R.id.editTextVille);
        cpC=findViewById(R.id.editTextCodePostal);



        retour= findViewById(R.id.btnRetour);
        valider= findViewById(R.id.btnValider);

        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GestionClients.class);
                startActivity(intent);
            }
        });

        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String chkR="ok";
                    if(!mr.isChecked() && !melle.isChecked() && !mme.isChecked())
                    {  chkR="not";}

                    if(emailC.getText().toString().trim().equals("") || nomC.toString().trim().equals("") || prenomC.toString().trim().equals("") || adresseC.toString().trim().equals("") || villeC.toString().trim().equals("") || telC.toString().trim().equals("") || cpC.toString().trim().equals("") || chkR.equals("not"))
                    { Toast.makeText(AjoutClient.this, "Veuillez remplir tous les champs!", Toast.LENGTH_SHORT).show(); }

                   else{

                       if (dbConnect.checkClient(emailC.getText().toString().trim()))
                       { Toast.makeText(AjoutClient.this, "Client Existant!", Toast.LENGTH_SHORT).show();}
                       else {

                       String civilite;
                       if (mr.isChecked())
                       { civilite="mr";}
                       else if (mme.isChecked())
                       { civilite="mme";}
                       else
                       { civilite="melle";}


                   Boolean isInserted = dbConnect.ajouterClient(emailC.getText().toString().trim(),
                            nomC.getText().toString().trim(),
                            prenomC.toString().trim(),
                            adresseC.getText().toString().trim(),
                            villeC.getText().toString().trim(),
                            Integer.parseInt(telC.getText().toString().trim()),
                            Integer.parseInt(cpC.getText().toString().trim()),
                            civilite);
                    if (isInserted) {
                        Toast.makeText(AjoutClient.this, "Client Ajoute avec Succes !", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(AjoutClient.this, "Error!", Toast.LENGTH_SHORT).show();
                    }} }


                }

        });
    }
}