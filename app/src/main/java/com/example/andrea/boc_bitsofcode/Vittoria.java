package com.example.andrea.boc_bitsofcode;

import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Vittoria extends AppCompatActivity{

    EditText text;
    Button avanti;
    Vibrator vi; //un dildo

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.vittoria);

        vi=(Vibrator) getSystemService(VIBRATOR_SERVICE); //inizializzo la vibrazione

        vi.vibrate(new long[]{0, 500, 110, 500, 110, 450, 110, 200, 110, 170, 40, 450, 110, 200, 110, 170, 40, 500}, -1); //TA TA TA TATATA TATATAAAA

        text= (EditText) findViewById(R.id.text); //Inizializzo la textbox di vittoria (da sistemare in front end)
        avanti=(Button) findViewById(R.id.avanti);

        text.setText("Il tuo punteggio è: "+Livello1.punteggio); //Stampo il messaggio di vittoria TODO: frontend è roba vostra <3
        Livello1.daActivity=true;

        if(MenuLivelli.giocatore.superati[0].normale<Livello1.punteggio){
            MenuLivelli.giocatore.superati[0].normale=Livello1.punteggio;
        }

        avanti.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish(); //chiudo quest' activity ormai inutile
            }
        });

    }
}
