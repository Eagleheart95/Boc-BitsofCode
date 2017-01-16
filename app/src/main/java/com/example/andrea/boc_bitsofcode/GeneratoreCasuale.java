package com.example.andrea.boc_bitsofcode;

import java.util.Random;

public class GeneratoreCasuale {

    Random random = new Random();

    public Tipo genera() { //DONE: ho aumentato la probabilità che vengano stampati oggetti che non siano int
        switch (1+random.nextInt() % 7) {
            case 1:
                return new Tipo("int"); //creo un nuovo dato int
            case 2:
                return new Tipo("float"); //creo un nuovo dato float
            case 3:
                return new Tipo("string"); //creo un nuovo dato string
            case 4:
                return new Tipo("booleani");//creo un nuovo dato bool
            case 5:
                return new Tipo("float");
            case 6:
                return new Tipo("string");
            case 7:
                return new Tipo("booleani");
        }

        return new Tipo("int"); //ANTIBUG: in caso mi dia problemi per qualsiasi motivo la generazione dei tipi, genero un int paracadute

    }
}





