package com.example.andrea.boc_bitsofcode;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Livello1diff extends AppCompatActivity{

    Button facile, medio, difficile;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.livello1diff);

        facile=(Button) findViewById(R.id.normal);
        medio=(Button) findViewById(R.id.medium);
        difficile=(Button) findViewById(R.id.hard);

        facile.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Livello1.daActivity=false;//rendo avviabile il livello uno difficoltà normale
                Livello1.punteggio=0;//mi assicuro che il conteggio del punteggio parta effettivamente da 0
                startActivity(new Intent(Livello1diff.this, Livello1.class)); //avvio il livello uno
                finish(); //chiudo quest' activity ormai inutile
            }
        });

        medio.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // TODO: crea la difficoltà media del livello 1
            }
        });

        difficile.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                // TODO: crea la difficoltà difficile del livello 1
            }
        });


    }

}
