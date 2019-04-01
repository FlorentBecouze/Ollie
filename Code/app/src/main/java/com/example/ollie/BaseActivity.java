package com.example.ollie;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;


import com.orbotix.Ollie;

import java.io.Serializable;
import java.util.Map;


public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * Encapsule le code lié à la navigation d'une activité à l'autre par un bouton.
     */
    protected void configureNavigationBtn(Button btn, final Class<?> cls, final Map<String, Serializable> args) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToActivity(cls, args);
            }
        });

    }

    protected void goToActivity(final Class<?> cls, final Map<String, Serializable> args) {
        Intent navIntent = new Intent(getApplicationContext(), cls);
        for(String key: args.keySet()) {
            navIntent.putExtra(key, args.get(key));
        }
        startActivity(navIntent);
    }


}
