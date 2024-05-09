/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.pipesnfilters;

import com.itson.dominio.Jugador;
import com.itson.dominio.Mano;
import com.itson.dominio.Partida;
import com.itson.dominio.Tablero;
import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author
 */
public class PipesNFilters {

    public static void main(String args[]) {
        Pipe pipe = new Pipeline<Partida>();
        Filter<Partida> filterVerificacion = new FilterVerificacion<>();
        Filter<Partida> filterMezclar = new FilterMezclarFichas<>();

        Filter<Partida> filterRepartir = new FilterRepartirFichas<>();
        Filter<Partida> filterAsginacion = new FilterAsignarTurno<>();

        pipe.nextFilter(filterVerificacion);
        pipe.nextFilter(filterMezclar);
        pipe.nextFilter(filterRepartir);
        pipe.nextFilter(filterAsginacion);
        
        ArrayList<Jugador> jugadores = new ArrayList<>();
        //simulación creación de juego
        jugadores.add(new Jugador("Player 1", Color.orange, "avatar1", new Mano()));
        jugadores.add(new Jugador("Player 2", Color.blue, "avatar2", new Mano()));
        jugadores.add(new Jugador("Player 3", Color.red, "avatar3", new Mano()));
        jugadores.add(new Jugador("Player 4", Color.green, "avatar4", new Mano()));
        try {
            System.out.println("Simulación de Iniciar Partida");
            Partida partida = (Partida) pipe.process(new Partida(10, new Tablero(), new Partida(), jugadores));
            System.out.println("Fichas configuradas:" + partida.maximoFichas);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
