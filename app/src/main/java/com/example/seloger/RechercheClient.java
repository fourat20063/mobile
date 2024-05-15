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

public class RechercheClient extends AppCompatActivity {
    Button rechercheClient, retour;
    DbConnect dbConnect;
    EditText email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche_client);
        dbConnect = new DbConnect(this);
        rechercheClient= findViewById(R.id.btnRecherche);
        retour=findViewById(R.id.btnRetour);
        email=findViewById(R.id.editTextEmailc);

        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GestionClients.class);
                startActivity(intent);
            }
        });

        rechercheClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email.getText().toString().equals("")){
                    Toast.makeText(RechercheClient.this, "Veuillez saisir un email!", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (!dbConnect.checkClient(email.getText().toString().trim()))
                    { Toast.makeText(RechercheClient.this, "Client non Existant!", Toast.LENGTH_SHORT).show();}
                    else {
                        Cursor res= dbConnect.afficheClient(email.getText().toString());

                            if(res.moveToFirst()){
                                StringBuffer buffer= new StringBuffer();
                            buffer.append("email :"+ res.getString(0)+"\n");
                            buffer.append("nom :"+ res.getString(1)+"\n");
                            buffer.append("prenom :"+ res.getString(2)+"\n");
                            buffer.append("adresse :"+ res.getString(3)+"\n");
                            buffer.append("ville :"+ res.getString(4)+"\n");
                            buffer.append("cp :"+ res.getInt(5)+"\n");
                            buffer.append("tel :"+ res.getInt(6)+"\n");
                            buffer.append("civilite :"+ res.getString(7)+"\n");

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

