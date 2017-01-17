package com.example.andrea.boc_bitsofcode;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by andrea on 17/01/17.
 */
public class Livello1Medium extends AppCompatActivity {

    TextView text; //la casella di testo in cui stampo il valore generato e quella in cui stampo la serie di risposte esatte
    Button interi, reali, stringhe, booleani; // i 4 bottoni dell' interfaccia
    private Question polloFritto = new Question(); //lla domanda che viene stampata e sulla quale effettuo i controlli
    static int punteggio = 0;
    int moltiplicatore, serie = 0;
    final int puntiARisposta = 50;
    private int giusti = 0; //tengo conto di quante risposte sono state indovinate, variabile contatore per la stampa del messaggio di vittoria
    private final int daIndovinare = 19; //Rrendo più facile la modifica del codice e lo rendo più leggibile
    Vibrator vi;
    static boolean daActivity = false;
    CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.livello1medio);

        vi = (Vibrator) getSystemService(VIBRATOR_SERVICE); //inizializzo la vibrazione

        text = (TextView) findViewById(R.id.text);
        interi = (Button) findViewById(R.id.interi);
        reali = (Button) findViewById(R.id.reali);
        stringhe = (Button) findViewById(R.id.stringa);
        booleani = (Button) findViewById(R.id.booleani);
        polloFritto.genera(); //genero il primo valore che dovrà essere valutato dall' utente
        text.setText("" + polloFritto.domanda); //stampo la domanda generata

        timer = new CountDownTimer(500, 100) { //Inizializzo il timer per la gestione del cambiamento di colore
            @Override
            public void onTick(long millisUntilFinished) {
                text.setTextColor(Color.RED);
            }

            @Override
            public void onFinish() {
                text.setTextColor(Color.parseColor("#FFEB3B"));
            }
        };

        interi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {   //controllo se è stato premuto il bottone int e decido cosa fare
                if ((polloFritto.risposta%4)==0) {  //in caso sia la risposta esatta:
                    if (giusti < daIndovinare) { //controllo quante ne sono state indovinate
                        polloFritto.genera(); //genero un nuovo valore casuale
                        text.setText("" + polloFritto.domanda); // stampo il nuovo valore casuale
                        giusti++; // incremento il numero di risposte esatte date
                        serie++; //incremento la serie
                        calcolaPunteggio(); //calcolo il punteggio
                    } else { //se sono state indovinate abbastanza risposte
                        startActivity(new Intent(Livello1Medium.this, Vittoria1Media.class).putExtra("punteggio", punteggio)); //apro la pagina della vittoria YEEEE

                    }
                } else { //se la risposta è sbagliata
                    timer.start(); //cambio il colore del font per 1/2 secondo
                    vi.vibrate(500); //vibra
                    serie = 0; //azzero la serie
                }
            }
        });

        reali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //come int
                if ((polloFritto.risposta%4)==1) {
                    if (giusti < daIndovinare) {
                        polloFritto.genera();
                        text.setText("" + polloFritto.domanda);
                        giusti++;
                        serie++;
                        calcolaPunteggio();
                    } else {
                        startActivity(new Intent(Livello1Medium.this, Vittoria1Media.class).putExtra("punteggio", punteggio));
                    }
                } else {
                    timer.start();
                    if (polloFritto.risposta==0) {
                        Toast.makeText(Livello1Medium.this, "I bambini bassi non valgono 0.5", Toast.LENGTH_LONG).show(); //scusate, non ho resistito
                    }
                    vi.vibrate(500); //vibra
                    serie = 0;
                }
            }
        });

        stringhe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {   //controllo se è stato premuto il bottone int e decido cosa fare
                if ((polloFritto.risposta%4)==2) {  //in caso sia la risposta esatta:
                    if (giusti < daIndovinare) { //controllo quante ne sono state indovinate
                        polloFritto.genera(); //genero un nuovo valore casuale
                        text.setText("" + polloFritto.domanda); // stampo il nuovo valore casuale
                        giusti++; // incremento il numero di risposte esatte date
                        serie++; //incremento la serie
                        calcolaPunteggio(); //calcolo il punteggio
                    } else { //se sono state indovinate abbastanza risposte
                        startActivity(new Intent(Livello1Medium.this, Vittoria1Media.class).putExtra("punteggio", punteggio)); //apro la pagina della vittoria YEEEE

                    }
                } else { //se la risposta è sbagliata
                    timer.start(); //cambio il colore del font per 1/2 secondo
                    vi.vibrate(500); //vibra
                    serie = 0; //azzero la serie
                }
            }
        });

        booleani.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {   //controllo se è stato premuto il bottone int e decido cosa fare
                if ((polloFritto.risposta%4)==3) {  //in caso sia la risposta esatta:
                    if (giusti < daIndovinare) { //controllo quante ne sono state indovinate
                        polloFritto.genera(); //genero un nuovo valore casuale
                        text.setText("" + polloFritto.domanda); // stampo il nuovo valore casuale
                        giusti++; // incremento il numero di risposte esatte date
                        serie++; //incremento la serie
                        calcolaPunteggio(); //calcolo il punteggio
                    } else { //se sono state indovinate abbastanza risposte
                        startActivity(new Intent(Livello1Medium.this, Vittoria1Media.class).putExtra("punteggio", punteggio)); //apro la pagina della vittoria YEEEE

                    }
                } else { //se la risposta è sbagliata
                    timer.start(); //cambio il colore del font per 1/2 secondo
                    vi.vibrate(500); //vibra
                    serie = 0; //azzero la serie
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (daActivity) {//Se ho cambiato activity chiudo il livello1
            finish();
        }

    }

    private void calcolaPunteggio() {
        if (serie >= 0 && serie < 5) {
            moltiplicatore = 1;
        } else {
            if (serie >= 5 && serie < 10) {
                moltiplicatore = 2;
            } else {
                if (serie >= 10 && serie < 15) {
                    moltiplicatore = 3;
                } else {
                    moltiplicatore = 4;
                }
            }
        }

        punteggio += puntiARisposta * moltiplicatore;

    }
}
