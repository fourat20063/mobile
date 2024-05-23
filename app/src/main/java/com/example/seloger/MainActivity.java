package com.example.seloger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText email, mdp;
    Button connection;
    DbConnect DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeUI();
        DB = new DbConnect(this);

        connection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleLogin();
            }
        });
    }

    private void initializeUI() {
        email = findViewById(R.id.email);
        mdp = findViewById(R.id.mdp);
        connection = findViewById(R.id.connect);
    }

    private void handleLogin() {
        String user = email.getText().toString();
        String pass = mdp.getText().toString();

        if (user.isEmpty() || pass.isEmpty()) {
            Toast.makeText(MainActivity.this, "Enter all the fields", Toast.LENGTH_SHORT).show();
            return;
        }

        if (user.equals("admin") && pass.equals("admin")) {
            loginSuccess();
        } else {
            Boolean checkAdminUser = DB.checkAdmin(user, pass);
            if (checkAdminUser) {
                loginSuccess();
            } else {
                Toast.makeText(MainActivity.this, "Admin doesn't exist", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void loginSuccess() {
        Toast.makeText(MainActivity.this, "Sign in Successfully", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), HomeAdmin.class);
        startActivity(intent);
        finish();
    }
}
