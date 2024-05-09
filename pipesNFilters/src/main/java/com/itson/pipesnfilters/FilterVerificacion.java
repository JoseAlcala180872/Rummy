/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.pipesnfilters;

import com.itson.dominio.Partida;

/**
 *
 * @author
 */
public class FilterVerificacion<T> implements Filter<T> {

    @Override
    public T process(T data) throws Exception {
        if (data instanceof Partida) {
            Partida p = (Partida) data;
            if (p.maximoFichas < 10 || p.maximoFichas > 13) {
                throw new Exception("El maximo de fichas no corresponde");
            }
            if (p.jugadores.size() < 2) {
                throw new Exception("El número de jugadores no rebasa el minimo");
            }
            if (p.jugadores.size() > 4) {
                throw new Exception("El numero de jugadores rebasa el máximo");
            }
            //añadir demás configuración -comodines etc. etc.
        }
        return data;
    }

    @Override
    public void nextPipe(Pipe siguientePipe) {
    }

}
