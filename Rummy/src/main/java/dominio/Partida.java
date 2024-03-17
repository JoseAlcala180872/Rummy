/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.ArrayList;

/**
 *
 * @author yalam
 */
public class Partida {
    
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
