package com.example.andrea.boc_bitsofcode;

import java.util.Random;

public class Tipo {

    String valore="''Doraemon''"; //ANTIBUG: ogni oggetto di tipo Tipo è inizializzato ai valori "Doraemon" e string per non generare in nessun caso oggetti nulli
    String tipo="string";
    private Random random= new Random();
    private Integer buffInt;
    private Float buffFloat;

    public Tipo(String tipo){
        this.tipo = tipo;

        if (tipo.equals("int")){ //creo i dati di tipo int
            buffInt = abs(random.nextInt())%1000;
            valore= buffInt.toString();
        }

        if(tipo.equals("float")) { // creo i dati di tipo float/double TO DO: troppi decimali, trova il modo di sistemarli
            buffFloat=(float)(abs(random.nextInt())%100000)/100;
            valore= buffFloat.toString();
        }

        if(tipo.equals("string")){ //creo i dati di tipo stringa
            switch (random.nextInt()%11){
                case 0:
                    valore="''ciao''";
                    break;
                case 1:
                    valore= "''a''";
                    break;
                case 2:
                    valore= "''federica''";
                    break;
                case 3:
                    valore= "''stefano''";
                    break;
                case 4:
                    valore="''b''";
                    break;
                case 5:
                    valore= "''casa''";
                    break;
                case 6:
                    valore= "''Fenu nostro dio''";
                    break;
                case 7:
                    valore= "''casanova''";
                    break;
                case 8:
                    valore= "''c''";
                    break;
                case 9:
                    valore= "''Djanni''";
                    break;
                case 10:
                    valore="''Kaffééééééééé''";
                    break;
            }
        }

        if(tipo.equals("booleani")){ //creo i dati booleani
            if(random.nextBoolean()){
                valore="true";
            }
            else{
                valore="false";
            }
        }

    }

    public String getValore(){
        return valore;
    }

    public String getTipo(){
        return tipo;
    }

    private int abs (int x){
        if(x<0){
            return -x;
        }
        return x;
    }
}



