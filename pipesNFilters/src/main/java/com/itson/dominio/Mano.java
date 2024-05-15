/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yalam
 */
public class Mano implements Serializable{
    private static final long serialVersionUID=1L;
    ArrayList<Fichas> fichasJugador;

    public Mano() {
    }

    public Mano(ArrayList<Fichas> fichasJugador) {
        this.fichasJugador = fichasJugador;
    }
    
    public void agregarFichas(){
        //implementacion pendiente
    }

    public ArrayList<Fichas> getFichasJugador() {
        return fichasJugador;
    }

    public void setFichasJugador(ArrayList<Fichas> fichasJugador) {
        this.fichasJugador = fichasJugador;
    }
}
