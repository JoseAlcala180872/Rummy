/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.pipesnfilters;

import com.itson.dominio.FichaComodin;
import com.itson.dominio.FichaNumero;
import com.itson.dominio.Fichas;
import com.itson.dominio.Partida;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author @param <T>
 */
public class FilterMezclarFichas<T> implements Filter<T> {

    @Override
    public T process(T data) {
        if (data instanceof Partida) {
            Partida p = (Partida) data;
            ArrayList<Fichas> pozo = p.tableroSingle.pozo = new ArrayList<>();
            pozo.add(new FichaComodin());
            pozo.add(new FichaNumero(1));
            pozo.add(new FichaComodin());
            pozo.add(new FichaNumero(2));
            pozo.add(new FichaComodin());
            pozo.add(new FichaNumero(3));

            System.out.println("Antes de mezclar: " + pozo);
            Collections.shuffle(pozo);
            p.tableroSingle.pozo = pozo;
            System.out.println("Mezcladas: " + pozo);
        }
        return data;
    }

    @Override
    public void nextPipe(Pipe siguientePipe) {
    }

}
