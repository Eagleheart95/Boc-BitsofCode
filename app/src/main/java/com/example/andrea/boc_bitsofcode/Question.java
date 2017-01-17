package com.example.andrea.boc_bitsofcode;

import java.util.Random;

/**
 * Created by andrea on 17/01/17.
 */
public class Question {
    String domanda="Che tipo di dato usi per memorizzare il numero di zampe di un cane?"; //ANTIBUG: in caso di problemi nella generazione casuale verrà mostrata questa domanda e il gioco andrà avanti normalmente
    int risposta=12, scelta;
    Random rand=new Random();

    public void genera(){
        scelta=rand.nextInt()%12;

        if(scelta<0){
            scelta=(-scelta);
        }

        switch(scelta){
            case 0:
                domanda="Che tipo di dato usi per memorizzare il numero di bambini nella tua classe?";
                break;
            case 1:
                domanda="Che tipo di dato usi per memorizzare il resto del gelataio?";
                break;
            case 2:
                domanda="Che tipo di dato usi per memorizzare il tuo nome?";
                break;
            case 3:
                domanda="Che tipo di dato usi per memorizzare il valore true?";
                break;
            case 4:
                domanda="Che tipo di dato usi per memorizzare il numero di stelle nel cielo?";//OK sarebbe long e neanche basta, però mi piace far fare pensieri filosofici alle giovani menti
                break;
            case 5:
                domanda="Che tipo di dato usi per memorizzare il prezzo delle figurine?";
                break;
            case 6:
                domanda="Che tipo di dato usi per memorizzare il nome della tua città?";
                break;
            case 7:
                domanda="Che tipo di dato usi per memorizzare il valore false?";
                break;
            case 8:
                domanda="Che tipo di dato usi per memorizzare il numero di figurine dentro un pacchetto?";//Si, da piccolo facevo la raccolta di figurine se non si fosse capito
                break;
            case 9:
                domanda="Che tipo di dato usi per memorizzare il prezzo di un pacchetto di patatine?";
                break;
            case 10:
                domanda="Che tipo di dato usi per memorizzare il nome del tuo cartone animato preferito?";
                break;
            case 11:
                domanda="Che tipo di dato usi per memorizzare il risultato di 21<14?";
                break;
        }
        risposta=scelta;
    }
}
