package com.example.andrea.boc_bitsofcode;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import java.io.File;


public class NewContinue extends AppCompatActivity{

    Button nuovo, continua, duello;
    File slot1, slot2, slot3; //servirà per gestire il salvataggio, userei volentieri un array, ma crasha
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_continue);

        nuovo=(Button) findViewById(R.id.nuovo);
        continua=(Button) findViewById(R.id.continua);
        duello=(Button) findViewById(R.id.duello);


        slot1=new File(this.getFilesDir(), "save.sav");
        slot2=new File(this.getFilesDir(), "save1.sav");
        slot3=new File(this.getFilesDir(), "save2.sav");

        if(!(slot1.exists()||slot2.exists()||slot3.exists())){ //se non ci sono salvataggi disattivo i tasti continua e duello
            continua.setEnabled(false);
            duello.setEnabled(false);
        }

        nuovo.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                startActivity(new Intent(NewContinue.this, SelezionaSlotDaScrivere.class));
            }

        });


        continua.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                startActivity(new Intent(NewContinue.this, CaricaProfilo.class));
            }
        });

        /*duello.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //TODO: implemanta la classe del duello
            }
        });*/

    }

}
