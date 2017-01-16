package com.example.andrea.boc_bitsofcode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Start extends AppCompatActivity {

    private ImageView immagine;
    private Button via;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        immagine = (ImageView) findViewById(R.id.immagine);
        via = (Button) findViewById(R.id.via);

        immagine.setImageResource(R.mipmap.logo);

        via.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Start.this, NewContinue.class));
                finish();
            }
        });
    }
}
