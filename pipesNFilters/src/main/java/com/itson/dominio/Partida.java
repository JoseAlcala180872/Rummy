/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.dominio;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author yalam
 */
public class Partida implements Serializable{
    private static final long serialVersionUID = 1234567L;

    public int maximoFichas;
    public Tablero tableroSingle;
    Partida partidaSingle;
    public ArrayList<Jugador> jugadores;

    public Partida() {
    }
    
    public Partida(int maximoFichas, Tablero tableroSingle, Partida partidaSingle, ArrayList<Jugador> jugadores) {
        this.maximoFichas = maximoFichas;
        this.tableroSingle = tableroSingle;
        this.partidaSingle = partidaSingle;
        this.jugadores = jugadores;
    }
    
    public Partida getPartida() {
        // Implementación pendiente
        return null;
    }
    
    public int getInstanse() {
        // Implementación pendiente
        return 0;
    }
}
