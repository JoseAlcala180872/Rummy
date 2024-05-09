/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.dominio;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Yeisi
 */
public class FichasEnPozo {
    ArrayList<Fichas> pozo;

    public ArrayList<Fichas> getPozo() {
        return pozo;
    }

    public void setPozo(int maximoFichas) {
        System.out.println("El maximo de fichas son: "+maximoFichas);
        pozo = new ArrayList<>();
        ArrayList<FichaNumero> ficha=new ArrayList<>();
        
            for (int i = 0; i < 2; i++) {
            //rojas
            for (int j = 1; j < maximoFichas+1; j++) {
                FichaNumero fichaNumero=new FichaNumero();
                fichaNumero.setNumero(j);
                ficha.add(fichaNumero);
                pozo.add(fichaNumero);
                
            }
            //amarillas
            for (int k = 1; k < maximoFichas+1; k++) {
                FichaNumero fichaNumero=new FichaNumero();
                fichaNumero.setNumero(k);
                ficha.add(fichaNumero);
                pozo.add(fichaNumero);
            }
            //verdes
            for (int l = 1; l < maximoFichas+1; l++) {
                FichaNumero fichaNumero=new FichaNumero();
                fichaNumero.setNumero(l);
                ficha.add(fichaNumero);
                pozo.add(fichaNumero);
            }
            //negras
            for (int m = 1; m < maximoFichas+1; m++) {
                FichaNumero fichaNumero=new FichaNumero();
                fichaNumero.setNumero(m);
                ficha.add(fichaNumero);
                pozo.add(fichaNumero);
            }
        }  
            Collections.shuffle(pozo);
    }
    public void repartirFichas(int numeroJugadores){
        Mano mano=new Mano();
        mano.setFichasJugador(pozo);
        // Crear una lista de listas para representar las fichas de cada jugador
        ArrayList<ArrayList<Fichas>> jugadores = new ArrayList<>();
        for (int i = 0; i < numeroJugadores; i++) {
            jugadores.add(new ArrayList<>());
        }
        // Repartir las fichas
        for (int i = 0; i < pozo.size(); i++) {
            jugadores.get(i % numeroJugadores).add(pozo.get(i));
        }
        // Imprimir las fichas de cada jugador para verificar
        for (int i = 0; i < jugadores.size(); i++) {
            System.out.println("Jugador " + (i + 1) + ": " + jugadores.get(i).toString());
        }
    }
}
