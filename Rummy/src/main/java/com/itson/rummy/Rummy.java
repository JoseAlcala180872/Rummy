/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.itson.rummy;

import GUI.frmTablero;
import com.itson.cliente.Cliente;
import com.itson.dominio.Jugador;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author José Alcalá 180872
 */
public class Rummy {

    public static void main(String[] args) throws IOException {
        
        
//        frmTablero tablero=new frmTablero();
//        tablero.setVisible(true);
        new Thread(Cliente.getInstance()).start();
    }
}
