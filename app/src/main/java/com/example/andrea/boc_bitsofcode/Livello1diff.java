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
                if (MenuLivelli.entra==2) {
                    startActivity(new Intent(Livello1diff.this, Livello2.class));
                    finish();

                }else{
                    Livello1.daActivity=false;//rendo avviabile il livello uno difficoltà normale
                    Livello1.punteggio=0;//mi assicuro che il conteggio del punteggio parta effettivamente da 0
                    startActivity(new Intent(Livello1diff.this, Livello1.class));} //avvio il livello uno
                finish(); //chiudo quest' activity ormai inutile
            }
        });

        medio.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (MenuLivelli.entra==2) {
                    /*startActivity(new Intent(Livello1diff.this, Livello2medio.class));
                      finish(); */
                    //TODO: ogni volta che avviate un livello, mettete finish() in modo che poi quest'activity si chiuda, altrimenti a fine livello viene di nuovo visualizzata
                }else{
                    Livello1Medium.daActivity=false;
                    Livello1Medium.punteggio=0;
                    startActivity(new Intent(Livello1diff.this, Livello1Medium.class));
                    finish();
                }

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
