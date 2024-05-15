package com.example.seloger;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class AjoutAnnonce extends AppCompatActivity {

   RadioButton cloture,active,terrain,appartement,villa,bureau,vente,location;
   EditText idA,ville,adresse,superficie,prix,date,description,nbc;
   Spinner spn;
   Button valider,retour;
   ImageView img;
   static byte[] imageContent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_annonce);



        //Groupe Radio Type du Bien
        terrain=findViewById(R.id.radioTerrain);
        appartement=findViewById(R.id.radioAppartement);
        villa=findViewById(R.id.radioVilla);
        bureau=findViewById(R.id.radioBureau);
        //Type de l annonce
        vente=findViewById(R.id.radioVente);
        location=findViewById(R.id.radioLocation);
        //Radio Etat de l'annonce
        active=findViewById(R.id.radioActive);
        cloture=findViewById(R.id.radioCloturee);
        //Autre Info
        idA=findViewById(R.id.editTextIdAnnonce);
        ville=findViewById(R.id.editTextVille);
        adresse=findViewById(R.id.editTextAdresse);
        superficie=findViewById(R.id.editTextSuperficie);
        prix=findViewById(R.id.editTextPrix);
        date=findViewById(R.id.editTextDate);
        description=findViewById(R.id.editTextDescription);
        nbc=findViewById(R.id.editTextNbChambres);
        //spinner
        spn=findViewById(R.id.spinnerGouvernorat);
        //les boutons
        valider=findViewById(R.id.btnValider);
        retour=findViewById(R.id.btnRetour);
        //image
        img = findViewById(R.id.imgV);


        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent,100);
            }
        });

        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String typeA;
                String typeB;
                String etat;
                String gouvernorat = spn.getSelectedItem().toString().trim();
                String idA1= idA.getText().toString().trim();
                String ville1=ville.getText().toString().trim();
                String adresse1=adresse.getText().toString().trim();
                String superficie2 = superficie.getText().toString().trim();
                String prix2=prix.getText().toString().trim();
                String date1= date.getText().toString().trim();
                String description1=description.getText().toString().trim();
                String nbc2=nbc.getText().toString().trim();

                //Verification des Champs

                if( idA1.equals("") || gouvernorat.equals("") || ville1.equals("") || adresse1.equals("") || superficie2.equals("") || prix2.equals("") || date1.equals("")|| description1.equals("") || nbc2.equals("")){
                    Toast.makeText(AjoutAnnonce.this, "Veuillez remplir tous les champs!", Toast.LENGTH_SHORT).show();
                }
                else{
                    DbConnect  db= new DbConnect(AjoutAnnonce.this);
                    if(db.checkAnnonce(idA1))
                    { Toast.makeText(AjoutAnnonce.this, "Client Existant!", Toast.LENGTH_SHORT).show();}

                    else{
                        Integer superficie1 = Integer.parseInt(superficie2);
                        Integer prix1=Integer.parseInt(prix2);
                        Integer nbc1=Integer.parseInt(nbc2);

                        if(appartement.isChecked()){
                            typeB="appartement";
                        }
                        else if (terrain.isChecked()) {
                            typeB="terrain";
                        }
                        else if (villa.isChecked()) {
                            typeB="villa";
                        }else {
                            typeB="bureau";
                        }

                        if(location.isChecked()){
                            typeA="location";
                        }else{
                            typeA="vente";
                        }
                        if(active.isChecked()){
                            etat="location";
                        }else{
                            etat="vente";
                        }

                        Annonce annonce= new Annonce(idA1,typeB,typeA,gouvernorat,ville1,adresse1,superficie1,prix1,date1,description1,nbc1,etat);
                        annonce.setImg(imageContent);
                        db.insertAnnonce(annonce);

                    }

                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if( requestCode==100 && resultCode== RESULT_OK){
            Uri imageUri=intent.getData();
            try{
                InputStream inputStream= getContentResolver().openInputStream(imageUri);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                img.setImageBitmap(bitmap);

                ByteArrayOutputStream stream= new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG,0,stream);

                imageContent = stream.toByteArray();

            }catch (FileNotFoundException e){
                e.printStackTrace();
            }
        }
    }
}
