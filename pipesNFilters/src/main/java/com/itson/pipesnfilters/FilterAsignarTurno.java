/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.pipesnfilters;

import com.itson.dominio.Jugador;
import com.itson.dominio.Partida;

/**
 *
 * @author
 */
public class FilterAsignarTurno<T> implements Filter<T> {

    private Pipe pipe;

    @Override
    public T process(T data) {
        if (data instanceof Partida) {
            Partida p = (Partida) data;
            int random = (int) Math.floor(Math.random() * p.jugadores.size());
            System.out.println("Antes de iniciar establecer el primer turno a jugador con indice: " + random);
            Jugador jugador = p.jugadores.get(random);
            System.out.println("El primer turno es del jugador: " + jugador.nombre);
        }
        return data;
    }

    @Override
    public void nextPipe(Pipe siguientePipe) {
        this.pipe = siguientePipe;
    }

}
