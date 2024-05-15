package com.example.seloger;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RechercheAnnonceID extends AppCompatActivity {
    Button rchA, retour;
    DbConnect dbConnect;
    EditText idA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche_annonce_id);
        dbConnect = new DbConnect(this);
        rchA= findViewById(R.id.btnRecherche);
        retour=findViewById(R.id.btnRetour);
        idA=findViewById(R.id.editTextEmailc);

        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RechercheAnnonce.class);
                startActivity(intent);
            }
        });

        rchA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (idA.getText().toString().equals("")){
                    Toast.makeText(RechercheAnnonceID.this, "Veuillez saisir un ID!", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (!dbConnect.checkAnnonce(idA.getText().toString().trim()))
                    { Toast.makeText(RechercheAnnonceID.this, "Annonce non Existante!", Toast.LENGTH_SHORT).show();}
                    else {
                        Cursor res= dbConnect.afficheAnnonce(idA.getText().toString());

                        if(res.moveToFirst()){
                            StringBuffer buffer= new StringBuffer();
                            buffer.append("ID :"+ res.getString(0)+"\n");
                            buffer.append("TypeB :"+ res.getString(1)+"\n");
                            buffer.append("Type A :"+ res.getString(2)+"\n");
                            buffer.append("Gouvernerat :"+ res.getString(3)+"\n");
                            buffer.append("Ville :"+ res.getString(4)+"\n");
                            buffer.append("Adresse :"+ res.getInt(5)+"\n");
                            buffer.append("Superficie :"+ res.getInt(6)+"\n");
                            buffer.append("Prix :"+ res.getInt(6)+"\n");
                            buffer.append("Date :"+ res.getString(7)+"\n");
                            buffer.append("Description :"+ res.getString(7)+"\n");
                            buffer.append("Nbc :"+ res.getInt(6)+"\n");
                            buffer.append("Etat :"+ res.getString(7)+"\n");


                            showMessage("Resultat",buffer.toString());}
                        res.close();
                    }
                }
            }
        });



    }
    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}