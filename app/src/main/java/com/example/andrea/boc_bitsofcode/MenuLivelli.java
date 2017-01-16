package com.example.andrea.boc_bitsofcode;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class MenuLivelli extends AppCompatActivity{

    Button uno, due, tre, punteggi; //i tre (per ora) bottoni e quello che mostrerà i punteggi
    public static int nLivelli=3; //DA MODIFICARE OGNI VOLTA CHE SI AGGIUNGE O RIMUOVE UN LIVELLO, SERVE PER IL SALVATAGGIO
    public static Utente giocatore;
    File salvataggio;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menulivelli);

        uno=(Button) findViewById(R.id.uno);
        due=(Button) findViewById(R.id.due);
        tre=(Button) findViewById(R.id.tre);
        punteggi=(Button) findViewById(R.id.punteggi);
        salvataggio=(File)getIntent().getSerializableExtra("salvataggio");

        try{
        giocatore=new Utente(new BufferedReader(new FileReader(salvataggio.getPath())));
        }
        catch(FileNotFoundException e){
            Toast.makeText(MenuLivelli.this, "Impossibile caricare il profilo, il file risulta assente", Toast.LENGTH_LONG).show();
        }

        giocatore.salva(salvataggio);


        uno.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MenuLivelli.this, Livello1diff.class)); //Faccio scegliere la difficoltà del primo livello
            }
        });

        //TODO: IMPLEMENTARE QUELLO CHE DEVONO FARE GLI ALTRI BOTTONI

    }

    @Override
    protected void onResume(){
        super.onResume();

        giocatore.salva(salvataggio);

    }

}
