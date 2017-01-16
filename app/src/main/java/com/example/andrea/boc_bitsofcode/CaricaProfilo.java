package com.example.andrea.boc_bitsofcode;

import android.content.Intent;
import android.os.Bundle;
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
public class CaricaProfilo extends AppCompatActivity {

    Button butt1, butt2, butt3;
    File save, save1, save2;
    BufferedReader reader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scegli_slot);

        butt1 = (Button) findViewById(R.id.butt1);
        butt2 = (Button) findViewById(R.id.butt2);
        butt3 = (Button) findViewById(R.id.butt3);

        save=new File(this.getFilesDir(), "save.sav");
        save1=new File(this.getFilesDir(), "save1.sav");
        save2=new File(this.getFilesDir(), "save2.sav");

        if(!save.exists()){
            butt1.setEnabled(false);
            butt1.setText("VUOTO");
        }
        else{
            try {
                reader = new BufferedReader(new FileReader(save.getPath()));
                butt1.setText(""+reader.readLine());
            }
            catch(Exception e){ //Dovrei gestire due eccezioni, è la voglia che manca
                Toast.makeText(CaricaProfilo.this, "Errore.", Toast.LENGTH_SHORT).show();
            }

        }

        if(!save1.exists()){
            butt2.setEnabled(false);
            butt2.setText("VUOTO");
        }
        else{
            try {
                reader = new BufferedReader(new FileReader(save1.getPath()));
                butt2.setText(""+reader.readLine());
            }
            catch(Exception e){ //Dovrei gestire due eccezioni, è la voglia che manca
                Toast.makeText(CaricaProfilo.this, "Errore.", Toast.LENGTH_SHORT).show();
            }
        }

        if(!save2.exists()){
            butt3.setEnabled(false);
            butt3.setText("VUOTO");
        }
        else{
            try {
                reader = new BufferedReader(new FileReader(save2.getPath()));
                butt3.setText(""+reader.readLine());
            }
            catch(Exception e){ //Dovrei gestire due eccezioni, è la voglia che manca
                Toast.makeText(CaricaProfilo.this, "Errore.", Toast.LENGTH_SHORT).show();
            }
        }

        butt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CaricaProfilo.this, MenuLivelli.class).putExtra("salvataggio", save));
                finish();
            }
        });

        butt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CaricaProfilo.this, MenuLivelli.class).putExtra("salvataggio", save1));
                finish();
            }
        });

        butt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CaricaProfilo.this, MenuLivelli.class).putExtra("salvataggio", save2));
                finish();
            }
        });

    }
}
