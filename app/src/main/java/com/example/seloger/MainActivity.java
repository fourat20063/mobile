package com.example.seloger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText email,mdp;
    Button connection ;
    DbConnect DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.email);
        mdp= findViewById(R.id.mdp);
        connection = findViewById(R.id.connect);
        DB = new DbConnect(this);
        connection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user= email.getText().toString();
                String pass=mdp.getText().toString();
                if(user.equals("")||pass.equals(""))
                    Toast.makeText(MainActivity.this,"Enter all the fields",Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkAdminUser = DB.checkAdmin(user,pass);
                    if (user.equals("admin")&& pass.equals("admin")) {
                        Toast.makeText(MainActivity.this,"Sign in Successfully",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), HomeAdmin.class);
                        startActivity(intent);

                    }
                    else if(checkAdminUser){
                        Toast.makeText(MainActivity.this,"Sign in Successfully",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), HomeAdmin.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(MainActivity.this,"Admin doesnt Exist",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}