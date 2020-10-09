package com.example.sendmessage.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.sendmessage.R;
import com.example.sendmessage.model.Message;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

/**
 * Esta clase recibe dos parámetros de la clase {@link SendMessageActivity} dentro
 * del objeto {@link android.os.Bundle} Para recoger los valores se tiene que realizar
 * las siguientes operaciones
 * <ol>
 *      <li>Recoger el Intent que nos han enviado desde la {@link android.app.Activity} origen</li>
 *      <li>Recoger el objeto Bundle</li>
 *      <li>Asignar los String a los componentes visuales o <i>widget</i></li>
 * </ol>
 * @author Israel Navarrete
 * @verion 1-0 07/10/2020
 */
public class ViewMessageActivity extends AppCompatActivity {

    private final static String TAG="ViewMessageActivity";
    private TextView tvUser;
    private TextView tvMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_message);

        //Buscamos la ID de los textView
        tvUser = findViewById(R.id.tvUser);
        tvMessage = findViewById(R.id.tvMessage);

        //1. Recoger el Intent que nos ha enviado SendMessageActivity
        Intent intent =getIntent();

        //2. Recoger el objeto bundle del intent
        Bundle bundle = intent.getExtras();

        //3. Asignar las cadenas String a los widget
        Message message = (Message)bundle.getSerializable("message");
        tvUser.setText(message.getUser().getUser());
        tvMessage.setText(message.getMessage());

        Logger.addLogAdapter(new AndroidLogAdapter());
        Logger.d(TAG,"ViewMessageActivity -> onCreate()");
    }

    //region Métodos Callback del ciclo de vida

    @Override
    protected void onStart() {
        super.onStart();
        Logger.d(TAG,"ViewMessageActivity -> onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Logger.d(TAG,"ViewMessageActivity -> onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Logger.d(TAG,"ViewMessageActivity -> onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Logger.d(TAG,"ViewMessageActivity -> onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Logger.d(TAG,"ViewMessageActivity -> onDestroy()");
    }

    //endregion

}