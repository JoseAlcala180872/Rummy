/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.dominio;

import java.awt.Color;
import java.io.Serializable;

/**
 *
 * @author yalam
 */
public class FichaNumero extends Fichas implements Serializable{
    private static final long serialVersionUID=1L;
    public int numero;
    public Color colorFicha;
    public FichaNumero(){
        
    }
    public FichaNumero(int numero){
        this.numero=numero;
    }
    @Override
    public int obtenerValor() {
        // Implementación de ejemplo
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "FichaNumero{" + "numero=" + numero + ", colorFicha=" + colorFicha + '}';
    }
    
    
}