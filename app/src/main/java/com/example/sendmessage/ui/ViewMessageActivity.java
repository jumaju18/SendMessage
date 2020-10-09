package com.example.sendmessage.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.widget.TextView;

import com.example.sendmessage.R;
import com.example.sendmessage.modelo.Message;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

/**
 * <h1>Funcionalidad de la clase</h1>
 * ESta clase envía dos cadenas de la clase {@link SendMessageActivity} dentro del objeto
 * {@link android.os.Bundle} Para recoger los valores se tiene que realizar las siguiente operaciones:
 * <ol>
 *     <li>Recoger el Intent qe nos han enviado desde la {@link android.app.Activity} origen</li>
 *     <li>Recoger el objeto Bundle</li>
 *     <li>Asignar los strinf a los componentes visuales o <i>widget</i></li>
 * </ol>
 * @author Juan Francisco González
 * @version 1.0, 06/10/2020
 * @see <a target="_blank" href="ttps://developer.android.com">Android DEV</a>
 */
//TODO ver porqué no funciona los enlaces a las clases de Android
public class ViewMessageActivity extends AppCompatActivity {

    private final static String TAG="ViewMessageActivity";
    private TextView tvUser;
    private TextView tvMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_message);
        tvUser = findViewById((R.id.tvUser));
        tvMessage = findViewById((R.id.tvMessage));

        //1. Recoger el Intent que nos ha enviado SendMessageActivity
        Intent intent = getIntent();
        //2. REcoger el objeto Bundle del Intent
        Bundle bundle = intent.getExtras();
        //3. Asignar las cadenas String a los widget
        Message message = (Message)bundle.getSerializable("message");
        tvUser.setText(bundle.getString("user"));
        tvMessage.setText(bundle.getString("message"));

        Logger.addLogAdapter(new AndroidLogAdapter());
        Logger.d(TAG, "ViewMessageActivity -> onCreate()");
    }
    //region Métodos Callback del ciclo de vida

    @Override
    protected void onStart() {
        super.onStart();
        Logger.d(TAG, "ViewMessageActivity -> onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Logger.d(TAG, "ViewMessageActivity -> onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Logger.d(TAG, "ViewMessageActivity -> onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Logger.d(TAG, "ViewMessageActivity -> onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Logger.d(TAG, "ViewMessageActivity -> onDestroy()");
    }
    //endregion

}