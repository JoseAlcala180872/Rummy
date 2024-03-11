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
public class FichaNumero extends Ficha {
    public int numero;
    public Color colorFicha;

    @Override
    public int obtenerValor() {
        // Implementación de ejemplo
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
}