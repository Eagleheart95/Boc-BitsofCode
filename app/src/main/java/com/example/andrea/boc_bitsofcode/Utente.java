package com.example.andrea.boc_bitsofcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Utente {

    public String nome;
    public Livello superati[]= new Livello[MenuLivelli.nLivelli];;

    public Utente (String nome){
        this.nome=nome;
        for(int i=0; i<MenuLivelli.nLivelli; i++){
            superati[i]=new Livello();
        }
    }

    public Utente (BufferedReader r){

        try {
            nome = r.readLine();

            for(int i=0; i<MenuLivelli.nLivelli; i++){
                superati[i]=new Livello();
                superati[i].normale=Integer.parseInt(r.readLine());
                superati[i].medio=Integer.parseInt(r.readLine());
                superati[i].difficile=Integer.parseInt(r.readLine());
            }

        }
        catch (IOException e){
            android.util.Log.d("failed to save file", e.toString());
        }
    }

    public void salva(File file) {
        BufferedWriter writer;
        if(file.exists()){
            file.delete();
        }

        try {
            file.createNewFile();
            file.setReadable(true);
            file.setWritable(true);
            writer = new BufferedWriter(new FileWriter(file.getPath()));
            writer.write(nome+"\n");
            for(int i=0; i<MenuLivelli.nLivelli; i++){
                writer.write(superati[i].normale+"\n"+superati[i].medio+"\n"+superati[i].difficile+"\n");
            }
            writer.close();
        }

        catch(IOException e){
            android.util.Log.d("failed to save file", e.toString());
        }
    }

}


