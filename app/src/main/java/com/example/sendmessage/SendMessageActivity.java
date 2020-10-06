package com.example.sendmessage;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;

public class SendMessageActivity extends AppCompatActivity {

    private EditText edUser;
    private EditText edMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //findViewByID
        edUser = findViewById(R.id.edUser);
        edMessage = findViewById(R.id.edMessage);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 1. Crear un objeto bundle donde se introduce
                // dos cadenas de texto
                Bundle bundle = new Bundle();
                bundle.putString("user", edUser.getText().toString());
                bundle.putString("message", edMessage.getText().toString());

                //2. Secrea el mensaje o Intent que es explícito porque se
                // conoce la Activity origen y la Activity destino
                Intent intent = new Intent(SendMessageActivity.this, ViewMessageActivity.class);

                //3. AÑadir el objeto al intent
                intent.putExtras(bundle);

                //4. iniciar la nueva actividad
                startActivity(intent);
            }
        });
    }
}