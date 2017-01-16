package com.example.andrea.boc_bitsofcode;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Created by andrea on 05/01/17.
 */
public class SelezionaSlotDaScrivere extends AppCompatActivity {

    Button butt1, butt2, butt3;
    File save, save1, save2;
    BufferedReader reader;
    AlertDialog.Builder alert;
    int ultimo; //mi serve per creare il nuovo salvataggio dall' alert

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scegli_slot);

        butt1 = (Button) findViewById(R.id.butt1);
        butt2 = (Button) findViewById(R.id.butt2);
        butt3 = (Button) findViewById(R.id.butt3);
        alert = new AlertDialog.Builder(SelezionaSlotDaScrivere.this);

        save=new File(this.getFilesDir(), "save.sav");
        save1=new File(this.getFilesDir(), "save1.sav");
        save2=new File(this.getFilesDir(), "save2.sav");

        alert.setTitle("ATTENZIONE!");
        alert.setMessage("Sei sicuro di voler sovrascrivere questo profilo?\nTutti i dati andaranno persi per sempre\n(un sacco di tempo!)");
        alert.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which){
                switch(ultimo){
                    case 1:
                        startActivity(new Intent(SelezionaSlotDaScrivere.this, CreaProfilo.class).putExtra("salvataggio", save));
                        finish();
                        break;
                    case 2:
                        startActivity(new Intent(SelezionaSlotDaScrivere.this, CreaProfilo.class).putExtra("salvataggio", save1));
                        finish();
                        break;
                    case 3:
                        startActivity(new Intent(SelezionaSlotDaScrivere.this, CreaProfilo.class).putExtra("salvataggio", save2));
                        finish();
                        break;
                }
            }
        });

        alert.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which){
                ; //non faccio niente
            }
        });
        alert.setIcon(android.R.drawable.ic_dialog_alert);


        if(!save.exists()){
            butt1.setText("VUOTO");
        }
        else{
            try {
                reader = new BufferedReader(new FileReader(save));
                butt1.setText(""+reader.readLine());
            }
            catch(Exception e){ //Dovrei gestire due eccezioni, la risolvo così
                Toast.makeText(SelezionaSlotDaScrivere.this, "Errore.", Toast.LENGTH_SHORT).show();
            }

        }

        if(!save1.exists()){
            butt2.setText("VUOTO");
        }
        else{
            try {
                reader = new BufferedReader(new FileReader(save1));
                butt2.setText(""+reader.readLine());
            }
            catch(Exception e){
                Toast.makeText(SelezionaSlotDaScrivere.this, "Errore.", Toast.LENGTH_SHORT).show();
            }
        }

        if(!save2.exists()){
            butt3.setText("VUOTO");
        }
        else{
            try {
                reader = new BufferedReader(new FileReader(save2));
                butt3.setText(""+reader.readLine());
            }
            catch(Exception e){
                Toast.makeText(SelezionaSlotDaScrivere.this, "Errore.", Toast.LENGTH_SHORT).show();
            }
        }

        butt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ultimo=1;
                if(save.exists()){
                    alert.show();
                }
                else{
                    startActivity(new Intent(SelezionaSlotDaScrivere.this, CreaProfilo.class).putExtra("salvataggio", save));
                    finish();
                }
            }
        });

        butt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ultimo=2;
                if(save1.exists()){
                    alert.show();
                }
                else{
                    startActivity(new Intent(SelezionaSlotDaScrivere.this, CreaProfilo.class).putExtra("salvataggio", save1));
                    finish();
                }
            }
        });

        butt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ultimo=3;
                if(save2.exists()){
                    alert.show();
                }
                else{
                    startActivity(new Intent(SelezionaSlotDaScrivere.this, CreaProfilo.class).putExtra("salvataggio", save2));
                    finish();
                }
            }
        });

    }
}
