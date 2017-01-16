package com.example.andrea.boc_bitsofcode;


import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.graphics.Point;
import java.lang.Math;


public class Livello1 extends AppCompatActivity {

    TextView text; //la casella di testo in cui stampo il valore generato e quella in cui stampo la serie di risposte esatte
    Button interi, reali, stringhe, booleani; // i 4 bottoni dell' interfaccia
    private Tipo polloFritto; //l' oggetto che viene stampato e sul quale effettuo i controlli
    static int punteggio = 0;
    int moltiplicatore, serie=0;
    final int puntiARisposta=50;
    private int giusti = 0; //tengo conto di quante risposte sono state indovinate, variabile contatore per la stampa del messaggio di vittoria
    private final int daIndovinare=19; //Rrendo più facile la modifica del codice e lo rendo più leggibile
    private GeneratoreCasuale generatore = new GeneratoreCasuale(); //genera casualmente gli oggetti di tipo Tipo appoggiandosi alla classe Random
    Vibrator vi;
    static boolean daActivity=false;
    CountDownTimer timer;
    Thread thread; // per il continuo aggiornamento del dato fluttuante
    Boolean dx = true; // per lo spostamento sul piano orizzontale
    Boolean su = true; // per lo spostamento sul piano verticale
    Display display;
    Point size;
    int max_width;
    int max_height;
    int angolo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livello1);

        display = getWindowManager().getDefaultDisplay();
        size = new Point();
        display.getSize(size);
        max_width = size.x;
        max_height = size.y;
        angolo = 0;

        vi=(Vibrator) getSystemService(VIBRATOR_SERVICE); //inizializzo la vibrazione

        text= (TextView) findViewById(R.id.text);
        interi=(Button) findViewById(R.id.interi);
        reali=(Button) findViewById(R.id.reali);
        stringhe=(Button) findViewById(R.id.stringa);
        booleani=(Button) findViewById(R.id.booleani);
        polloFritto= generatore.genera(); //genero il primo valore che dovrà essere valutato dall' utente
        text.setText(""+polloFritto.valore); //stampo il valore generato

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

        // movimento del dato
        thread = new Thread() {
            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(100);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (angolo<360) angolo++;
                                else angolo=0;

                                int coseno = ((int) Math.cos(Math.toRadians(angolo)));
                                int seno = ((int) Math.sin(Math.toRadians(angolo)));

                                // si muove piano piano in orizzontale
                                text.setX(max_width/3 + coseno*max_width/4);
                                // si muove piano piano in verticale
                                text.setY(max_height/3 + seno*max_width/4);
                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };
        thread.start();


        // controllo sul bottone cliccato
        interi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {   //controllo se è stato premuto il bottone int e decido cosa fare
                if (polloFritto.tipo.equals("int")){  //in caso sia la risposta esatta:
                    if(giusti<daIndovinare) { //controllo quante ne sono state indovinate
                        polloFritto = generatore.genera(); //genero un nuovo valore casuale
                        text.setText(""+polloFritto.valore); // stampo il nuovo valore casuale
                        giusti++; // incremento il numero di risposte esatte date
                        serie++; //incremento la serie
                        calcolaPunteggio(); //calcolo il punteggio
                    }
                    else{ //se sono state indovinate abbastanza risposte
                        startActivity(new Intent(Livello1.this, Vittoria.class).putExtra("punteggio", punteggio)); //apro la pagina della vittoria YEEEE

                    }
                }
                else{ //se la risposta è sbagliata
                    timer.start(); //cambio il colore del font per 1/2 secondo
                    vi.vibrate(500); //vibra
                    serie=0; //azzero la serie
                }
            }
        });

        reali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //come int
                if (polloFritto.tipo.equals("float")){
                    if(giusti<daIndovinare) {
                        polloFritto = generatore.genera();
                        text.setText(""+polloFritto.valore);
                        giusti++;
                        serie++;
                        calcolaPunteggio();
                    }
                    else{
                        startActivity(new Intent(Livello1.this, Vittoria.class).putExtra("punteggio", punteggio));
                    }
                }
                else{
                    timer.start();
                    vi.vibrate(500); //vibra
                    serie=0;
                }
            }
        });

        stringhe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //come int e reali
                if (polloFritto.tipo.equals("string")){
                    if(giusti<daIndovinare) {
                        polloFritto = generatore.genera();
                        text.setText(""+polloFritto.valore);
                        giusti++;
                        serie++;
                        calcolaPunteggio();
                    }
                    else{
                        startActivity(new Intent(Livello1.this, Vittoria.class).putExtra("punteggio", punteggio));
                    }
                }
                else{
                    timer.start();
                    vi.vibrate(500); //vibra
                    serie=0;
                }
            }
        });

        booleani.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //come int, reali e string
                if (polloFritto.tipo.equals("booleani")) {
                    if (giusti < daIndovinare) {
                        polloFritto = generatore.genera();
                        text.setText("" + polloFritto.valore);
                        giusti++;
                        serie++;
                        calcolaPunteggio();
                    } else {
                        startActivity(new Intent(Livello1.this, Vittoria.class).putExtra("punteggio", punteggio));
                    }
                }
                else {
                    timer.start();
                    vi.vibrate(500); //vibra
                    serie=0;
                }
            }
        });
    }

    @Override
    protected void onResume(){
        super.onResume();

        if(daActivity){//Se ho cambiato activity chiudo il livello1
            finish();
        }

    }

    private void calcolaPunteggio(){
        if(serie>=0 && serie <5){
            moltiplicatore=1;
        }
        else{
            if(serie>=5 && serie <10){
                moltiplicatore=2;
            }
            else{
                if(serie>=10 && serie <15){
                    moltiplicatore=3;
                }
                else{
                    moltiplicatore=4;
                }
            }
        }

        punteggio+=puntiARisposta*moltiplicatore;


    }

}
