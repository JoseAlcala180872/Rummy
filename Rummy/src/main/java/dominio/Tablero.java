/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author yalam
 */
public class Tablero implements Serializable{
    private static final long serialVersionUID=1L;
    public FichasEnJuego fichasEnJuego;
    public Tablero tableroSingle;
    public ArrayList<Fichas> pozo;
    
    public boolean isPrimero() {
        // Implementación pendiente
        return false;
    }
    
    public Tablero getTablero() {
        // Implementación pendiente
        return null;
    }
}