package com.example.sendmessage.ui;

import android.content.Intent;
import android.os.Bundle;

import com.example.sendmessage.R;
import com.example.sendmessage.SendMessageApplication;
import com.example.sendmessage.model.Message;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import android.view.View;
import android.widget.EditText;

/**
 * <h1> Funcionalidad de la clase </h1>
 * Esta clase envía 2 cadenas {@link java.lang.String} el usuario y el mensaje a la clase
 * {@link ViewMessageActivity}
 * @author Israel Navarrete
 * @version 1-0 07/10/2020
 * @see <a target=" blank" href="https://developer.android.com/">Android Developer</a>
 */
//TODO Ver por qué no funcionan los enlaces a las clases de Android
public class SendMessageActivity extends AppCompatActivity {

    private EditText edUser;
    private EditText edMessage;
    private final static String TAG="SendMessageActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.addLogAdapter(new AndroidLogAdapter());
        Logger.d(TAG,"SendMessageActivity -> onCreate()");
        setContentView(R.layout.activity_send_message);
        //TODO Hacemos uso de la barra de herrramientas
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //findViewByID
        edUser = findViewById(R.id.edUser);
        edMessage = findViewById(R.id.edMessage);

        //Ponemos que el texto sea igual a ->
        //Primero entramos en nuestra clase Application con un downcasting -
        //porque el metodo GetApplication(); es de la clase Application y con eso hacemos que coja el usuario de nuestra clase ->
        //Dentro de esta cogemos el user, es decir vamos a la clase user ->
        //En la clase user elegimos el nombre del usuario llamado user
        edUser.setText(((SendMessageApplication)getApplication()).getUser().getUser());


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!emptyMessage())
                    SendMessage();
                else
                    showError(getResources().getString(R.string.error_empty_message));
            }
        });
    }


    /**
     * Conprueba que el usuario no pueda mandar un mensaje vacio
     * @return Devuelve si el texto esta vacio o no
     */
    private boolean emptyMessage() {
        return edMessage.getText().toString().isEmpty();
    }

    /**
     * Muestra un mensaje de error generico al usuario
     * @param error
     */
    private void showError(String error) {
        Snackbar.make(findViewById(R.id.coordinator),error,Snackbar.LENGTH_SHORT).show();
    }

    /**
     * Este método envía un mensaje a la Actividad ViewMessageActivity
     */
    public void SendMessage()
    {
        // 1. Crear un objeto bundle donde se introduce
        // dos cadenas de texto
        Bundle bundle = new Bundle();
        //bundle.putString("user", edUser.getText().toString());
        //bundle.putString("message", edMessage.getText().toString());

        Message message = new Message();
        message.setUser(((SendMessageApplication)getApplication()).getUser());
        message.setMessage(edMessage.getText().toString());
        message.setDate("09/10/2020");

        bundle.putSerializable("message",message);


        //2. Secrea el mensaje o Intent que es explícito porque se
        // conoce la Activity origen y la Activity destino
        Intent intent = new Intent(this, ViewMessageActivity.class);

        //3. AÑadir el objeto al intent
        intent.putExtras(bundle);

        //4. iniciar la nueva actividad
        startActivity(intent);
    }

    //region Métodos Callback del ciclo de vida

    @Override
    protected void onStart() {
        super.onStart();
        Logger.d(TAG,"SendMessageActivity -> onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Logger.d(TAG,"SendMessageActivity -> onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Logger.d(TAG,"SendMessageActivity -> onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Logger.d(TAG,"SendMessageActivity -> onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Logger.d(TAG,"SendMessageActivity -> onDestroy()");
    }

    //endregion
}