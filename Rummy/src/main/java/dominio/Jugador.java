/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.awt.Color;

/**
 *
 * @author yalam
 */
public class Jugador {
    //Atributos
    public String nombre;
    public Color colorJugador;
    public String avatar;
    //Metodos
    
    public Jugador() {
    }
    
    public Jugador(String nombre, Color colorJugador, String avatar) {
        this.nombre = nombre;
        this.colorJugador = colorJugador;
        this.avatar = avatar;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Color getColorJugador() {
        return colorJugador;
    }

    public void setColorJugador(Color colorJugador) {
        this.colorJugador = colorJugador;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    
}
