package com.example.sendmessage;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
/**
 * <h1>Funcionalidad de la clase</h1>
 * ESta clase envía dos cadenas {@link java.lang.String}: el usuario y el mensaje a la clase
 * {@link ViewMessageActivity}
 * @author Juan Francisco González
 * @version 1.0, 06/10/2020
 * @see <a target="_blank" href="ttps://developer.android.com">Android DEV</a>
 * */

public class SendMessageActivity extends AppCompatActivity {

    private EditText edUser;
    private EditText edMessage;
    private final static String TAG="SendMessageActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);
        Logger.addLogAdapter(new AndroidLogAdapter());
        Log.d(TAG, "SendMessageActivity -> onCreate()");
        //
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
    //region Métodos Callback del ciclo de vida

    @Override
    protected void onStart() {
        super.onStart();
        Logger.d(TAG, "SendMessageActivity -> onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Logger.d(TAG, "SendMessageActivity -> onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Logger.d(TAG, "SendMessageActivity -> onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Logger.d(TAG, "SendMessageActivity -> onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "SendMessageActivity -> onDestroy()");
    }
    //endregion
}